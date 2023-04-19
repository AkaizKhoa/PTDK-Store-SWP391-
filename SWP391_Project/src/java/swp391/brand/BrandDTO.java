/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swp391.brand;

import java.util.Date;

/**
 *
 * @author Duy
 */
public class BrandDTO {
    private int brandID;
    private String name;
    private String description;
    private Date createTime;
private boolean status;
    
    
    public BrandDTO() {
    }

    public BrandDTO(int brandID, String name, String description, Date createTime) {
        this.brandID = brandID;
        this.name = name;
        this.description = description;
        this.createTime = createTime;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public BrandDTO(int brandID, String name, String description) {
        this.brandID = brandID;
        this.name = name;
        this.description = description;
    }
 public BrandDTO(int brandID, String name, String description, boolean status) {
        this.brandID = brandID;
        this.name = name;
        this.description = description;
        this.status = status;
    }
    public BrandDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
       public BrandDTO(String name, String description, boolean status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }


    public BrandDTO(int brandID, String name) {
        this.brandID = brandID;
        this.name = name;
    }


    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
}
