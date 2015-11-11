
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
 *         &lt;element name="BatchProcessRequest" type="{http://avatax.avalara.com/services}BatchProcessRequest" minOccurs="0"/>
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
    "batchProcessRequest"
})
@XmlRootElement(name = "BatchProcess")
public class BatchProcess {

    @XmlElement(name = "BatchProcessRequest")
    protected BatchProcessRequest batchProcessRequest;

    /**
     * Gets the value of the batchProcessRequest property.
     * 
     * @return
     *     possible object is
     *     {@link BatchProcessRequest }
     *     
     */
    public BatchProcessRequest getBatchProcessRequest() {
        return batchProcessRequest;
    }

    /**
     * Sets the value of the batchProcessRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchProcessRequest }
     *     
     */
    public void setBatchProcessRequest(BatchProcessRequest value) {
        this.batchProcessRequest = value;
    }

}
