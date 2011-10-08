package model;

import java.sql.*;
import java.io.*;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.*;

/**
 * the model behind server
 */
public class ServerModel extends Observable {
    // Create SSL Socket Factory for SSLServerSocket

    SSLServerSocketFactory secSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
    private SSLServerSocket serverSocket;
    // store the clients' print writer stream
    private ArrayList<ClientInfo> clientList;
    private ArrayList<ClientInfo> hostList;
    private ArrayList<SSLSocket> socketList;
    // database connection
    //private DatabaseConnectionPSQL conn; // connection of psql
    private DatabaseConnection dbConn; // connection of mysql
    // a flag to indicate whether the server start or not
    private boolean start;

    /**
     * create a server model
     */
    public ServerModel() {
        super();
        start = false;
        // initialize socket
        clientList = new ArrayList<ClientInfo>();
        hostList = new ArrayList<ClientInfo>();
        socketList = new ArrayList<SSLSocket>();
        //conn = new DatabaseConnectionPSQL();
        dbConn = new DatabaseConnection();
        initialClients();

    }

    private void initialClients() {
        PreparedStatement pStmt;
        String sql = "select * from tables order by table_id";
        try {
            pStmt = dbConn.getConnection().prepareStatement(sql);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()) {
                clientList.add(new ClientInfo(rs.getString("table_id"), 0));
            }
            pStmt.close();
            System.out.println("Client list size is: " + clientList.size());
        } catch (SQLException ex) {
            
        }
    }

    /**
     * Start server
     *
     * @throws SocketException
     */
    public void startServer() {
        try {
            serverSocket = (SSLServerSocket) secSocketFactory.createServerSocket(3333);
            // Set Cipher Suites which you would like to use
            String[] enabledCipherSuites = {"SSL_DH_anon_WITH_RC4_128_MD5"};
            serverSocket.setEnabledCipherSuites(enabledCipherSuites);

            while (true) {
                SSLSocket socket = (SSLSocket) serverSocket.accept();
                socketList.add(socket);
                System.out.println("Someone comes");
                ServerThread s = new ServerThread(socket, socketList,
                        clientList, hostList, dbConn.getConnection());
                s.start();
            }
        } catch (IOException e) {
            System.out.println("Server has been closed.");
        }
    }

    /**
     * Get the list which stores online clients
     *
     * @return a list of online clients
     */
    public ArrayList<ClientInfo> getList() {
        return clientList;
    }

    /**
     * Detect whether server has been started or not
     *
     * @return true if server start, else for false
     */
    public boolean isStart() {
        return start;
    }

    /**
     * Start or stop server
     *
     * @param start
     *            a given order to server
     */
    public void setStart(boolean start) {
        this.start = start;
        setChanged();
        notifyObservers();
    }

    /**
     * To get the database connection
     * @return the database connection
     */
    public DatabaseConnection getDBConn() {
        return dbConn;
    }
}
