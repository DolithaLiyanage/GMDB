/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmdb.hibernate.entity;

import java.util.Date;
import javax.persistence.Embeddable;


/**
 *
 * @author pc
 */

@Embeddable
public class BaseEntity {
    
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date lastMoodifiedTime;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

   

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getLastMoodifiedTime() {
        return lastMoodifiedTime;
    }

    public void setLastMoodifiedTime(Date lastMoodifiedTime) {
        this.lastMoodifiedTime = lastMoodifiedTime;
    }
    
    
}
