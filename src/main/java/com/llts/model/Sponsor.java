package com.llts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "sponsor")
public class Sponsor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "companyID", nullable = false)
    private Integer key;

    @Column(name = "companyName", nullable = false)
    private String companyName;

    @Column(name = "sponsorID")
    private Integer sponsorID;

    @Column(name = "sponsorName", nullable = false)
    private String sponsorName;

    @Column(name = "status")
    private String status;

    public void setKey(Integer companyID) {
        this.key = companyID;
    }

    public Integer getKey() {
        return key;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setSponsorID(Integer sponsorID) {
        this.sponsorID = sponsorID;
    }

    public Integer getSponsorID() {
        return sponsorID;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "companyID=" + key + '\'' +
                "companyName=" + companyName + '\'' +
                "sponsorID=" + sponsorID + '\'' +
                "sponsorName=" + sponsorName + '\'' +
                "status=" + status + '\'' +
                '}';
    }
}