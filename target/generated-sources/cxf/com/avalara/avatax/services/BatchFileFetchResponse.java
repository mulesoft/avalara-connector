
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
 *         &lt;element name="BatchFileFetchResult" type="{http://avatax.avalara.com/services}BatchFileFetchResult" minOccurs="0"/>
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
    "batchFileFetchResult"
})
@XmlRootElement(name = "BatchFileFetchResponse")
public class BatchFileFetchResponse {

    @XmlElement(name = "BatchFileFetchResult")
    protected BatchFileFetchResult batchFileFetchResult;

    /**
     * Gets the value of the batchFileFetchResult property.
     * 
     * @return
     *     possible object is
     *     {@link BatchFileFetchResult }
     *     
     */
    public BatchFileFetchResult getBatchFileFetchResult() {
        return batchFileFetchResult;
    }

    /**
     * Sets the value of the batchFileFetchResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchFileFetchResult }
     *     
     */
    public void setBatchFileFetchResult(BatchFileFetchResult value) {
        this.batchFileFetchResult = value;
    }

}
