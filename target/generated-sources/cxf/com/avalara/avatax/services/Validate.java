
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
 *         &lt;element name="ValidateRequest" type="{http://avatax.avalara.com/services}ValidateRequest" minOccurs="0"/>
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
    "validateRequest"
})
@XmlRootElement(name = "Validate")
public class Validate {

    @XmlElement(name = "ValidateRequest")
    protected ValidateRequest validateRequest;

    /**
     * Gets the value of the validateRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ValidateRequest }
     *     
     */
    public ValidateRequest getValidateRequest() {
        return validateRequest;
    }

    /**
     * Sets the value of the validateRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidateRequest }
     *     
     */
    public void setValidateRequest(ValidateRequest value) {
        this.validateRequest = value;
    }

}
