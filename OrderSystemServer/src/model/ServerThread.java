/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.net.ssl.SSLSocket;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.jdom.*;

/**
 * A server thread to deal with commands. Every command is a XML document
 * 
 * @author jxx084
 */
/*
 * a class which will work as a thread on server to deal with one client
 */
public class ServerThread extends Thread {
    // to record the log

    private SSLSocket selfSocket = null;
    // to store every online client
    private ArrayList<ClientInfo> clientList;
    private ArrayList<ClientInfo> hostList;
    // to store my own information
    private String uid;
    private Connection conn;
    private DataInputStream fromClient;
    private DataOutputStream toClient;
    private ObjectInputStream objectFromClient;
    private ObjectOutputStream objectToClient;
    private ArrayList<SSLSocket> socketList;

    /**
     * create a new server thread
     *
     * @param socket
     *            new the socket for new client
     * @param list
     *            the list which store all of client writer
     * @param conn
     *            database connection
     * @param offlineMessage
     *            a map with all offline message, user id of sender as key
     */
    public ServerThread(SSLSocket socket, ArrayList<SSLSocket> socketList, ArrayList<ClientInfo> clientList,
            ArrayList<ClientInfo> hostList, Connection conn) {
        super("Client");
        this.socketList = socketList;
        this.selfSocket = socket;
        this.clientList = clientList;
        this.hostList = hostList;
        this.conn = conn;
        this.uid = "0";
        try {
            this.fromClient = new DataInputStream(selfSocket.getInputStream());
            this.toClient = new DataOutputStream(selfSocket.getOutputStream());

            objectFromClient = new ObjectInputStream(selfSocket.getInputStream());
            objectToClient = new ObjectOutputStream(selfSocket.getOutputStream());

        } catch (IOException e) {
        }
    }

    /**
     * to run this thread
     */
    @Override
    public void run() {
        while (true) {
            try {
                Document doc = (Document) objectFromClient.readObject();
                Element command = doc.getRootElement().getChild("command");
                // for stop command
                if (command.getAttributeValue("type").equals("stop")) {
                    objectToClient.writeObject(doc);
                    break;
                } // for host login command
                else if (command.getAttributeValue("type").equals("hostLogin")) {
                    String username = command.getChildText("username");
                    String password = command.getChildText("password");
                    if (permitLogin(username, password)) {
                        hostList.add(new ClientInfo(uid, objectToClient));
                        // send the client status to host
                        Element clientListRoot = new Element("message");
                        for(ClientInfo e : clientList) {
                            Element clientListRootCommand = new Element("Client");
                            clientListRootCommand.addContent((new Element("clientId").setText(e.getUid())));
                            clientListRootCommand.addContent((new Element("clientStatus").setText("" + e.getStatus())));
                            clientListRoot.addContent(clientListRootCommand);
                        }
                        Document clientStatusDoc = new Document(clientListRoot);
                        toClient.writeBoolean(true);
                        objectToClient.writeObject(clientStatusDoc);
                    } else {
                        toClient.writeBoolean(false);
                    }
                } // for client login command
                else if (command.getAttributeValue("type").equals("ClientLogin")) {
                    String clientId = command.getChildText("clientId");
                    boolean flag = false;
                    for (ClientInfo e : clientList) {
                        if (e.getUid().equals(clientId)) {
                            e.setStatus(1);
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        // to tell every host new client comes
                        Element loginRoot = new Element("message");
                        Element loginRootCommand = new Element("command");
                        loginRootCommand.setAttribute("type", "NewClientHasLogin");
                        loginRootCommand.addContent(new Element("clientId").setText(clientId));
                        loginRoot.addContent(loginRootCommand);
                        Document loginDoc = new Document(loginRoot);
                        for (ClientInfo e : hostList) {
                            e.getObjectToClient().writeObject(loginDoc);
                        }
                        toClient.writeBoolean(true);
                    } else {
                        toClient.writeBoolean(false);
                    }
                } else if (command.getAttributeValue("type").equals("openTable")) {
                    String tableId = command.getChildText("tableId");
                    if (SetTableStatus(tableId, 1)) {
                        for (int i = 0; i < clientList.size(); i++) {
                            ClientInfo client = clientList.get(i);
                            if (client.getUid().equals("mainForm")) {
                            }
                        }
                    } else {
                        toClient.writeBoolean(false);
                    }
                }
            } catch (IOException e1) {
            } catch (ClassNotFoundException e1) {
            }

        }
        // Close I/O and socket in server, don't close in the client
        // Otherwise IOException

        for (int i = 0; i < hostList.size(); i++) {
            if (hostList.get(i).getUid().equals(uid)) {
                hostList.remove(i);
                break;
            }
        }
        // to tell every client new client leaves
        try {
            socketList.remove(selfSocket);
            objectFromClient.close();
            objectToClient.close();
            fromClient.close();
            toClient.close();
            selfSocket.close();
        } catch (IOException e2) {
        }
        System.out.println("Someone left. Currently there are "
                + clientList.size() + " clients and " + socketList.size() + " sockets");
    }

    /**
     * Detect whether the given username and password are available or not
     *
     * @param email
     *            a given username
     * @param password
     *            a given password
     * @return true if they are available, false for not
     */
    public boolean permitLogin(String username, String password) {
        boolean repeat = false;
        boolean result = false;
        for (int i = 0; i < hostList.size(); i++) {
            if (hostList.get(i).getEmail().equals(username)) {
                repeat = true;
            }
        }
        if (repeat) {
            result = false;
        } else {
            PreparedStatement pStmt;
            try {
//                StandardStringDigester digester = new StandardStringDigester();
//                digester.setAlgorithm("SHA-1"); // SHA-1 Algorithm
//                digester.setIterations(50000);
                String sql = "SELECT * FROM users where user_id = ?";
                pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, username);
                String passwordDB = "";
                ResultSet rs = pStmt.executeQuery();
                if (rs.next()) {
                    uid = String.valueOf(rs.getInt("user_id"));
                    passwordDB = rs.getString("password");
                }
                try {
                    if (passwordDB.equals(password)) {
                        result = true;
                    }
                    pStmt.close();
                } catch (EncryptionOperationNotPossibleException eone) {
                }
            } catch (SQLException e) {
            }
        }
        return result;
    }

    public boolean SetTableStatus(String tableId, int status) {
        PreparedStatement pStmt;
        try {
            String sql = "update tables set statu = ? where table_id= ?";
            pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, status);
            pStmt.setString(2, tableId);
            String passwordDB = "";
            pStmt.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    /**
     * to log out a user
     *
     * @param uid
     *            the user id to be logout
     */
    public void logout(String uid) {
        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.get(i).getUid().equals(uid)) {
                clientList.remove(i);
                break;
            }
        }
        try {
            // to tell every client new client leaves
            Element logoutRoot = new Element("message");
            Element logoutCommand = new Element("command");
            logoutCommand.setAttribute("type", "NewClientHasLogout");
            logoutCommand.addContent(new Element("uid").setText("" + uid));
            logoutRoot.addContent(logoutCommand);
            Document logoutDoc = new Document(logoutRoot);
            for (ClientInfo e : clientList) {
                e.getObjectToClient().writeObject(logoutDoc);
            }
            // to stop the client input thread
            Element stopRoot = new Element("message");
            Element stopCommand = new Element("command");
            stopCommand.setAttribute("type", "stop");
            stopRoot.addContent(stopCommand);
            Document stopDoc = new Document(stopRoot);
            objectToClient.writeObject(stopDoc);
        } catch (IOException e2) {
        }
        System.out.println("Someone left. Currently there are "
                + clientList.size() + " clients");
        System.out.println("english version");
	
    }
}
