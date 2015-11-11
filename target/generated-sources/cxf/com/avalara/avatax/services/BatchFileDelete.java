
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
 *         &lt;element name="DeleteRequest" type="{http://avatax.avalara.com/services}DeleteRequest" minOccurs="0"/>
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
    "deleteRequest"
})
@XmlRootElement(name = "BatchFileDelete")
public class BatchFileDelete {

    @XmlElement(name = "DeleteRequest")
    protected DeleteRequest deleteRequest;

    /**
     * Gets the value of the deleteRequest property.
     * 
     * @return
     *     possible object is
     *     {@link DeleteRequest }
     *     
     */
    public DeleteRequest getDeleteRequest() {
        return deleteRequest;
    }

    /**
     * Sets the value of the deleteRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeleteRequest }
     *     
     */
    public void setDeleteRequest(DeleteRequest value) {
        this.deleteRequest = value;
    }

}
