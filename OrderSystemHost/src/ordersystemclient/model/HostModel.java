/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ordersystemclient.model;

import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.*;
import org.jdom.*;

/**
 *
 * @author Administrator
 */
public class HostModel extends Observable {

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
    // to indicate the clients
    private ArrayList<ClientStatus> clientList;
    
     private List<Brand> brandCEList;
     private List<Category> categCEList;

    public HostModel() {
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

            clientList = new ArrayList<ClientStatus>();

        } catch (UnknownHostException e) {
            System.out.println("host errors");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Client errors");
            System.exit(1);
        }
    }

    public boolean login(String username, String password) {

        Element root = new Element("message");
        // level one content
        Element command = new Element("command");
        command.setAttribute("type", "hostLogin"); // define the commend type
        // level two contents
        command.addContent(new Element("username").setText(username));
        command.addContent(new Element("password").setText(password));
        root.addContent(command);
        // this field will store the whole message in XML format
        Document doc = new Document(root);
        boolean result = false;
        try {
            objectToServer.writeObject(doc);
            result = fromServer.readBoolean();
            if (result) {
                Document clientStatusdoc = (Document) objectFromServer.readObject();
                List<Element> clientStatusList = clientStatusdoc.getRootElement().getChildren();
                if (clientStatusList != null) {
                    for (int i = 0; i < clientStatusList.size(); i++) {
                        Element element = clientStatusList.get(i);
                        String clientId = element.getChildText("clientId");
                        int status = Integer.valueOf(element.getChildText("clientStatus"));
                        System.out.println(clientId + " : " + status);
                        clientList.add(new ClientStatus(clientId, status));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {

        }
        return result;
    }
 //send request to get the brandlist
    public boolean getBrandList() {

        Brand brand;
        Element root = new Element("message");
        // level one content
        Element command = new Element("command");
        //send the getBrandList
        command.setAttribute("type", "getBrandList"); // define the commend type
        // level two contents
        root.addContent(command);
        // this field will store the whole message in XML format
        Document doc = new Document(root);
        try {
            objectToServer.writeObject(doc);
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return true;
    }
    
    //send request to server to get the categoryList;
    public boolean getCategoryList() {

        Brand brand;
        Element root = new Element("message");
        // level one content
        Element command = new Element("command");
        //send the  CategoryList
        command.setAttribute("type", "getCategoryList"); // define the commend type
        // level two contents
        root.addContent(command);
        // this field will store the whole message in XML format
        Document doc = new Document(root);
        try {
            objectToServer.writeObject(doc);
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return true;
    }
    public void openTable(String clientId) {
        for(ClientStatus e : clientList) {
            if(e.getClientId().equals(clientId)) {
                e.setStatus(1);
                setChanged();
                notifyObservers();
            }
        }
    }

     public boolean addNewDish(String dishName, String dishCategory, String dishPrice,String dishPicPath,String dishIntroduction) {

        Element root = new Element("message");
        // level one content
        Element command = new Element("command");
        command.setAttribute("type", "addDish"); // define the commend type
        // level two contents
        command.addContent(new Element("dishName").setText(dishName));
        command.addContent(new Element("dishCategory").setText(dishCategory));
        command.addContent(new Element("dishPrice").setText(dishPrice));
        command.addContent(new Element("dishPicPath").setText(dishPicPath));
        command.addContent(new Element("dishIntroduction").setText(dishIntroduction));
        
        root.addContent(command);
        // this field will store the whole message in XML format
        Document doc = new Document(root);
        boolean result = false;
        try {
            objectToServer.writeObject(doc);
            result = fromServer.readBoolean();
            if (result) {
                Document clientStatusdoc = (Document) objectFromServer.readObject();
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {

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
            Logger.getLogger(HostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startInputThread() {
        // this reader will always listen to server
        HostInputThread clientOutput = new HostInputThread(fromServer,
                this, objectFromServer);
        clientOutput.start();
        System.out.println("ClientInputThread start");
    }

    public ArrayList<ClientStatus> getClientList() {
        return clientList;
    }
    
     /**
     * @return the brandCEList
     */
    public List<Brand> getBrandCEList() {
        return brandCEList;
    }

    /**
     * @param brandCEList the brandCEList to set
     */

    /**
     * @param brandCEList the brandCEList to set
     */
    public void setBrandCEList(List<Brand> brandCEList) {
        this.brandCEList = brandCEList;
    }

    /**
     * @return the categCEList
     */
    public List<Category> getCategCEList() {
        return categCEList;
    }

    /**
     * @param categCEList the categCEList to set
     */
    public void setCategCEList(List<Category> categCEList) {
        this.categCEList = categCEList;
    }
}
