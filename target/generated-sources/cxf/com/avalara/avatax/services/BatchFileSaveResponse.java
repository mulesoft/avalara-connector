
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
 *         &lt;element name="BatchFileSaveResult" type="{http://avatax.avalara.com/services}BatchFileSaveResult" minOccurs="0"/>
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
    "batchFileSaveResult"
})
@XmlRootElement(name = "BatchFileSaveResponse")
public class BatchFileSaveResponse {

    @XmlElement(name = "BatchFileSaveResult")
    protected BatchFileSaveResult batchFileSaveResult;

    /**
     * Gets the value of the batchFileSaveResult property.
     * 
     * @return
     *     possible object is
     *     {@link BatchFileSaveResult }
     *     
     */
    public BatchFileSaveResult getBatchFileSaveResult() {
        return batchFileSaveResult;
    }

    /**
     * Sets the value of the batchFileSaveResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchFileSaveResult }
     *     
     */
    public void setBatchFileSaveResult(BatchFileSaveResult value) {
        this.batchFileSaveResult = value;
    }

}
