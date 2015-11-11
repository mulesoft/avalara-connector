
package com.avalara.avatax.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BatchSaveResult" type="{http://avatax.avalara.com/services}BatchSaveResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "batchSaveResult"
})
@XmlRootElement(name = "BatchSaveResponse")
public class BatchSaveResponse {

    @XmlElement(name = "BatchSaveResult")
    protected BatchSaveResult batchSaveResult;

    /**
     * Gets the value of the batchSaveResult property.
     * 
     * @return
     *     possible object is
     *     {@link BatchSaveResult }
     *     
     */
    public BatchSaveResult getBatchSaveResult() {
        return batchSaveResult;
    }

    /**
     * Sets the value of the batchSaveResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchSaveResult }
     *     
     */
    public void setBatchSaveResult(BatchSaveResult value) {
        this.batchSaveResult = value;
    }

}
