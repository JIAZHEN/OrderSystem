/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ordersystemclient.model;

import java.io.Serializable;

/**
 *
 * @author Jacob
 */
public class Category  implements Serializable{
    private int cateId;
    private String cateEName;
    private String cateCName;

    /**
     * @return the cateId
     */
    public int getCateId() {
        return cateId;
    }

    /**
     * @param cateId the cateId to set
     */
    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    /**
     * @return the cateEName
     */
    public String getCateEName() {
        return cateEName;
    }

    /**
     * @param cateEName the cateEName to set
     */
    public void setCateEName(String cateEName) {
        this.cateEName = cateEName;
    }

    /**
     * @return the cateCName
     */
    public String getCateCName() {
        return cateCName;
    }

    /**
     * @param cateCName the cateCName to set
     */
    public void setCateCName(String cateCName) {
        this.cateCName = cateCName;
    }
    
}