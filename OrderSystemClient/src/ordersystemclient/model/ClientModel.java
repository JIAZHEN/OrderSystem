/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ordersystemclient.model;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.*;
import org.jdom.*;

/**
 *
 * @author Administrator
 */
public class ClientModel extends Observable{

    SSLSocketFactory secSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    // Create Secure Sockets Layer socket
    private SSLSocket socket;
    // use data input stream because we need to send message with UTF-8 code
    private DataInputStream fromServer;
    // to read the message with UTF-8 code
    private DataOutputStream toServer;
    // to receive the xml object
    private ObjectInputStream objectFromServer;
    // to pass the xml object
    private ObjectOutputStream objectToServer;

    public ClientModel() {
        // initialize the number of online clients
        try {
            // for the security
            // lab host cca-ug04-0936
            socket = (SSLSocket) secSocketFactory.createSocket("localhost",
                    3333);
            String[] enabledCipherSuites = {"SSL_DH_anon_WITH_RC4_128_MD5"};
            socket.setEnabledCipherSuites(enabledCipherSuites);

            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());

            objectToServer = new ObjectOutputStream(socket.getOutputStream());
            objectFromServer = new ObjectInputStream(socket.getInputStream());

        } catch (UnknownHostException e) {
            System.out.println("host errors");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Client errors");
            System.exit(1);
        }
    }

    public boolean login(String clientId) {

        Element root = new Element("message");
        // level one content
        Element command = new Element("command");
        command.setAttribute("type", "ClientLogin"); // define the commend type
        // level two contents
        command.addContent(new Element("clientId").setText(clientId));
        root.addContent(command);
        // this field will store the whole message in XML format
        Document doc = new Document(root);
        boolean result = false;
        try {
            objectToServer.writeObject(doc);
            result = fromServer.readBoolean();
        } catch (IOException e) {

        }
        return result;
    }
    
    /**open table command
     * 
     * @param tableId
     * @return 
     */
     public boolean openTable(String tableId) {

        Element root = new Element("message");
        // level one content
        Element command = new Element("command");
        command.setAttribute("type", "openTable"); // define the commend type
        // level two contents
        command.addContent(new Element("tableId").setText(tableId));
        root.addContent(command);
        // this field will store the whole message in XML format
        Document doc = new Document(root);
        boolean result = false;
        try {
            objectToServer.writeObject(doc);
            result = fromServer.readBoolean();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return result;
    }

    public void stop() {
        Element root = new Element("message");
        // level one content
        Element command = new Element("command");
        command.setAttribute("type", "stop"); // define the commend type
        root.addContent(command);
        // this field will store the whole message in XML format
        Document doc = new Document(root);
        try {
            objectToServer.writeObject(doc);
        } catch (IOException ex) {
            Logger.getLogger(ClientModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startInputThread() {
        // this reader will always listen to server
        ClientInputThread clientOutput = new ClientInputThread(fromServer,
                this, objectFromServer);
        clientOutput.start();
        System.out.println("ClientInputThread start");
    }
}
