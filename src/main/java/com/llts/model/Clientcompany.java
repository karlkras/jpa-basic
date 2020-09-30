package com.llts.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "clientcompany")
public class Clientcompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    private Integer key;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "guid", nullable = false)
    private String guid;

    @Column(name = "docTransPricingScheme", nullable = false)
    private String docTransPricingScheme;

    @Column(name = "paymentTerms", nullable = false)
    private Integer paymentTerms;

    @Column(name = "dtBucket")
    private String dtBucket;

    @Column(name = "commissionType")
    private String commissionType;

    @Column(name = "addPMSurchargeforDocTrans")
    private Integer addPMSurchargeforDocTrans;

    @Column(name = "usLinguistsRequired")
    private Integer usLinguistsRequired;

    @Column(name = "passTradosLeveraging")
    private Integer passTradosLeveraging;

    @Column(name = "prospect")
    private String prospect;

    @Column(name = "llsClientID")
    private String llsClientID;

    @Column(name = "billingInstructions")
    private String billingInstructions;

    @Column(name = "billingEmail")
    private String billingEmail;

    @Column(name = "legalEntity")
    private String legalEntity;

    @Column(name = "legalEntityCompany")
    private String legalEntityCompany;

    @Column(name = "specialInstructions")
    private String specialInstructions;

    @Column(name = "clientPONumber")
    private String clientPONumber;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer ID) {
        this.key = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getDocTransPricingScheme() {
        return docTransPricingScheme;
    }

    public void setDocTransPricingScheme(String docTransPricingScheme) {
        this.docTransPricingScheme = docTransPricingScheme;
    }

    public Integer getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(Integer paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getDtBucket() {
        return dtBucket;
    }

    public void setDtBucket(String dtBucket) {
        this.dtBucket = dtBucket;
    }

    public String getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(String commissionType) {
        this.commissionType = commissionType;
    }

    public Integer getAddPMSurchargeforDocTrans() {
        return addPMSurchargeforDocTrans;
    }

    public void setAddPMSurchargeforDocTrans(Integer addPMSurchargeforDocTrans) {
        this.addPMSurchargeforDocTrans = addPMSurchargeforDocTrans;
    }

    public Integer getUsLinguistsRequired() {
        return usLinguistsRequired;
    }

    public void setUsLinguistsRequired(Integer usLinguistsRequired) {
        this.usLinguistsRequired = usLinguistsRequired;
    }

    public Integer getPassTradosLeveraging() {
        return passTradosLeveraging;
    }

    public void setPassTradosLeveraging(Integer passTradosLeveraging) {
        this.passTradosLeveraging = passTradosLeveraging;
    }

    public String getProspect() {
        return prospect;
    }

    public void setProspect(String prospect) {
        this.prospect = prospect;
    }

    public String getLlsClientID() {
        return llsClientID;
    }

    public void setLlsClientID(String llsClientID) {
        this.llsClientID = llsClientID;
    }

    public String getBillingInstructions() {
        return billingInstructions;
    }

    public void setBillingInstructions(String billingInstructions) {
        this.billingInstructions = billingInstructions;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    public String getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(String legalEntity) {
        this.legalEntity = legalEntity;
    }

    public String getLegalEntityCompany() {
        return legalEntityCompany;
    }

    public void setLegalEntityCompany(String legalEntityCompany) {
        this.legalEntityCompany = legalEntityCompany;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public String getClientPONumber() {
        return clientPONumber;
    }

    public void setClientPONumber(String clientPONumber) {
        this.clientPONumber = clientPONumber;
    }
}
