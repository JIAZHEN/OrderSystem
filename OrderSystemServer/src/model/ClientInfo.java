package model;

import java.io.*;

/**
 * a class which has all info about a online client
 */
public class ClientInfo {

    private String uid;
    // indicate the status of client, 0 as offline, 1 as online but no order,
    // 2 as ordered, 3 as need service, 4 as deliver, 5 as check out
    private int status;
    private String email;
    private String image;
    private ObjectOutputStream objectToClient;

    /**
     * create an online client with multiple info
     *
     * @param uid
     *            the user id
     * @param email
     *            the user email
     * @param image
     *            the number of user image
     * @param toClient
     *            the data output stream to this client
     * @param objectToClient
     *            the object output stream to this client
     */
    public ClientInfo(String uid, ObjectOutputStream objectToClient) {
        this.uid = uid;
        this.objectToClient = objectToClient;
    }

    public ClientInfo(String uid, int status) {
        this.uid = uid;
        this.status = status;
    }

    /**
     * get the object output stream
     *
     * @return object output stream
     */
    public ObjectOutputStream getObjectToClient() {
        return objectToClient;
    }

    /**
     * get the user id
     *
     * @return user id
     *

    /**
     * get the user email
     *
     * @return user email
     */
    public String getEmail() {
        return email;
    }

    /**
     * get the user email
     *
     * @return user email
     */
    public String getImage() {
        return image;
    }

    /**
     * @return the uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
