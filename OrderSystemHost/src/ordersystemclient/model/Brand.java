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
public class Brand implements Serializable{
    private int brandId;
    private String brandEName;
    private String brandCName;

    /**
     * @return the brandId
     */
    public int getBrandId() {
        return brandId;
    }

    /**
     * @param brandId the brandId to set
     */
    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    /**
     * @return the brandEName
     */
    public String getBrandEName() {
        return brandEName;
    }

    /**
     * @param brandEName the brandEName to set
     */
    public void setBrandEName(String brandEName) {
        this.brandEName = brandEName;
    }

    /**
     * @return the brandCName
     */
    public String getBrandCName() {
        return brandCName;
    }

    /**
     * @param brandCName the brandCName to set
     */
    public void setBrandCName(String brandCName) {
        this.brandCName = brandCName;
    }
}
