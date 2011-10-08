/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ordersystemclient.model;

import java.io.*;

import org.jdom.Document;
import org.jdom.Element;

/**
 * a class which is a thread and will deal with user's input
 * 
 * @author jxx084
 */
public class ClientInputThread extends Thread {
    // to receive the xml object

    private ObjectInputStream recievedCommand;
    private ClientModel clientModel;

    /**
     * create such a thread
     *
     * @param recieveMessage
     *            the data stream from server
     * @param clientModel
     *            the underlying client model
     * @param recievedCommand
     *            the object stream from server
     */
    public ClientInputThread(DataInputStream recieveMessage,
            ClientModel clientModel, ObjectInputStream recievedCommand) {
        super();
        this.clientModel = clientModel;
        this.recievedCommand = recievedCommand;
    }

    public void run() {
        try {
            while (true) {
                Document doc = (Document) recievedCommand.readObject();
                Element command = doc.getRootElement().getChild("command");
                if (command.getAttributeValue("type").equals("stop")) {
                    break;
                } 
                 
            }
            System.out.println("ClientInputThread break");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
