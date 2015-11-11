
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
 *         &lt;element name="BatchProcessResult" type="{http://avatax.avalara.com/services}BatchProcessResult" minOccurs="0"/>
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
    "batchProcessResult"
})
@XmlRootElement(name = "BatchProcessResponse")
public class BatchProcessResponse {

    @XmlElement(name = "BatchProcessResult")
    protected BatchProcessResult batchProcessResult;

    /**
     * Gets the value of the batchProcessResult property.
     * 
     * @return
     *     possible object is
     *     {@link BatchProcessResult }
     *     
     */
    public BatchProcessResult getBatchProcessResult() {
        return batchProcessResult;
    }

    /**
     * Sets the value of the batchProcessResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchProcessResult }
     *     
     */
    public void setBatchProcessResult(BatchProcessResult value) {
        this.batchProcessResult = value;
    }

}
