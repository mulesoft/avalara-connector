
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
 *         &lt;element name="FetchRequest" type="{http://avatax.avalara.com/services}FetchRequest" minOccurs="0"/>
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
    "fetchRequest"
})
@XmlRootElement(name = "BatchFetch")
public class BatchFetch {

    @XmlElement(name = "FetchRequest")
    protected FetchRequest fetchRequest;

    /**
     * Gets the value of the fetchRequest property.
     * 
     * @return
     *     possible object is
     *     {@link FetchRequest }
     *     
     */
    public FetchRequest getFetchRequest() {
        return fetchRequest;
    }

    /**
     * Sets the value of the fetchRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link FetchRequest }
     *     
     */
    public void setFetchRequest(FetchRequest value) {
        this.fetchRequest = value;
    }

}
