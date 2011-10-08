/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ordersystemclient.model;

/**
 *
 * @author JIAZHEN
 */
public class ClientStatus {

    private String clientId;
    private int status;

    public ClientStatus(String clientId, int status) {
        this.clientId = clientId;
        this.status = status;
    }

    public String getClientId() {
        return clientId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    

}
