
package com.avalara.avatax.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Batch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Batch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccountId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BatchId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BatchStatusId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BatchTypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BatchAgent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CompanyId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CreatedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CreatedUserId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CompletedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Files" type="{http://avatax.avalara.com/services}ArrayOfBatchFile" minOccurs="0"/>
 *         &lt;element name="ModifiedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ModifiedUserId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Options" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecordCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CurrentRecord" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Batch", propOrder = {
    "accountId",
    "batchId",
    "batchStatusId",
    "batchTypeId",
    "batchAgent",
    "companyId",
    "createdDate",
    "createdUserId",
    "completedDate",
    "files",
    "modifiedDate",
    "modifiedUserId",
    "name",
    "options",
    "recordCount",
    "currentRecord"
})
public class Batch {

    @XmlElement(name = "AccountId")
    protected int accountId;
    @XmlElement(name = "BatchId")
    protected int batchId;
    @XmlElement(name = "BatchStatusId")
    protected String batchStatusId;
    @XmlElement(name = "BatchTypeId")
    protected String batchTypeId;
    @XmlElement(name = "BatchAgent")
    protected String batchAgent;
    @XmlElement(name = "CompanyId")
    protected int companyId;
    @XmlElement(name = "CreatedDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;
    @XmlElement(name = "CreatedUserId")
    protected int createdUserId;
    @XmlElement(name = "CompletedDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar completedDate;
    @XmlElement(name = "Files")
    protected ArrayOfBatchFile files;
    @XmlElement(name = "ModifiedDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modifiedDate;
    @XmlElement(name = "ModifiedUserId")
    protected int modifiedUserId;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Options")
    protected String options;
    @XmlElement(name = "RecordCount")
    protected int recordCount;
    @XmlElement(name = "CurrentRecord")
    protected int currentRecord;

    /**
     * Gets the value of the accountId property.
     * 
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     */
    public void setAccountId(int value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the batchId property.
     * 
     */
    public int getBatchId() {
        return batchId;
    }

    /**
     * Sets the value of the batchId property.
     * 
     */
    public void setBatchId(int value) {
        this.batchId = value;
    }

    /**
     * Gets the value of the batchStatusId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchStatusId() {
        return batchStatusId;
    }

    /**
     * Sets the value of the batchStatusId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchStatusId(String value) {
        this.batchStatusId = value;
    }

    /**
     * Gets the value of the batchTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchTypeId() {
        return batchTypeId;
    }

    /**
     * Sets the value of the batchTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchTypeId(String value) {
        this.batchTypeId = value;
    }

    /**
     * Gets the value of the batchAgent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchAgent() {
        return batchAgent;
    }

    /**
     * Sets the value of the batchAgent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchAgent(String value) {
        this.batchAgent = value;
    }

    /**
     * Gets the value of the companyId property.
     * 
     */
    public int getCompanyId() {
        return companyId;
    }

    /**
     * Sets the value of the companyId property.
     * 
     */
    public void setCompanyId(int value) {
        this.companyId = value;
    }

    /**
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDate(XMLGregorianCalendar value) {
        this.createdDate = value;
    }

    /**
     * Gets the value of the createdUserId property.
     * 
     */
    public int getCreatedUserId() {
        return createdUserId;
    }

    /**
     * Sets the value of the createdUserId property.
     * 
     */
    public void setCreatedUserId(int value) {
        this.createdUserId = value;
    }

    /**
     * Gets the value of the completedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCompletedDate() {
        return completedDate;
    }

    /**
     * Sets the value of the completedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCompletedDate(XMLGregorianCalendar value) {
        this.completedDate = value;
    }

    /**
     * Gets the value of the files property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBatchFile }
     *     
     */
    public ArrayOfBatchFile getFiles() {
        return files;
    }

    /**
     * Sets the value of the files property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBatchFile }
     *     
     */
    public void setFiles(ArrayOfBatchFile value) {
        this.files = value;
    }

    /**
     * Gets the value of the modifiedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModifiedDate() {
        return modifiedDate;
    }

    /**
     * Sets the value of the modifiedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModifiedDate(XMLGregorianCalendar value) {
        this.modifiedDate = value;
    }

    /**
     * Gets the value of the modifiedUserId property.
     * 
     */
    public int getModifiedUserId() {
        return modifiedUserId;
    }

    /**
     * Sets the value of the modifiedUserId property.
     * 
     */
    public void setModifiedUserId(int value) {
        this.modifiedUserId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the options property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptions() {
        return options;
    }

    /**
     * Sets the value of the options property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptions(String value) {
        this.options = value;
    }

    /**
     * Gets the value of the recordCount property.
     * 
     */
    public int getRecordCount() {
        return recordCount;
    }

    /**
     * Sets the value of the recordCount property.
     * 
     */
    public void setRecordCount(int value) {
        this.recordCount = value;
    }

    /**
     * Gets the value of the currentRecord property.
     * 
     */
    public int getCurrentRecord() {
        return currentRecord;
    }

    /**
     * Sets the value of the currentRecord property.
     * 
     */
    public void setCurrentRecord(int value) {
        this.currentRecord = value;
    }

}
