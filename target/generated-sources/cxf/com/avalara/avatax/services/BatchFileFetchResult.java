
package com.avalara.avatax.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BatchFileFetchResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchFileFetchResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://avatax.avalara.com/services}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="BatchFiles" type="{http://avatax.avalara.com/services}ArrayOfBatchFile" minOccurs="0"/>
 *         &lt;element name="RecordCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchFileFetchResult", propOrder = {
    "batchFiles",
    "recordCount"
})
public class BatchFileFetchResult
    extends BaseResult
{

    @XmlElement(name = "BatchFiles")
    protected ArrayOfBatchFile batchFiles;
    @XmlElement(name = "RecordCount")
    protected int recordCount;

    /**
     * Gets the value of the batchFiles property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBatchFile }
     *     
     */
    public ArrayOfBatchFile getBatchFiles() {
        return batchFiles;
    }

    /**
     * Sets the value of the batchFiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBatchFile }
     *     
     */
    public void setBatchFiles(ArrayOfBatchFile value) {
        this.batchFiles = value;
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

}
