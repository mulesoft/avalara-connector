
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
 *         &lt;element name="BatchFile" type="{http://avatax.avalara.com/services}BatchFile" minOccurs="0"/>
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
    "batchFile"
})
@XmlRootElement(name = "BatchFileSave")
public class BatchFileSave {

    @XmlElement(name = "BatchFile")
    protected BatchFile batchFile;

    /**
     * Gets the value of the batchFile property.
     * 
     * @return
     *     possible object is
     *     {@link BatchFile }
     *     
     */
    public BatchFile getBatchFile() {
        return batchFile;
    }

    /**
     * Sets the value of the batchFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchFile }
     *     
     */
    public void setBatchFile(BatchFile value) {
        this.batchFile = value;
    }

}
