
package com.avalara.avatax.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BatchFetchResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchFetchResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://avatax.avalara.com/services}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="Batches" type="{http://avatax.avalara.com/services}ArrayOfBatch" minOccurs="0"/>
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
@XmlType(name = "BatchFetchResult", propOrder = {
    "batches",
    "recordCount"
})
public class BatchFetchResult
    extends BaseResult
{

    @XmlElement(name = "Batches")
    protected ArrayOfBatch batches;
    @XmlElement(name = "RecordCount")
    protected int recordCount;

    /**
     * Gets the value of the batches property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBatch }
     *     
     */
    public ArrayOfBatch getBatches() {
        return batches;
    }

    /**
     * Sets the value of the batches property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBatch }
     *     
     */
    public void setBatches(ArrayOfBatch value) {
        this.batches = value;
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
