
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
 *         &lt;element name="ValidateResult" type="{http://avatax.avalara.com/services}ValidateResult" minOccurs="0"/>
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
    "validateResult"
})
@XmlRootElement(name = "ValidateResponse")
public class ValidateResponse {

    @XmlElement(name = "ValidateResult")
    protected ValidateResult validateResult;

    /**
     * Gets the value of the validateResult property.
     * 
     * @return
     *     possible object is
     *     {@link ValidateResult }
     *     
     */
    public ValidateResult getValidateResult() {
        return validateResult;
    }

    /**
     * Sets the value of the validateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidateResult }
     *     
     */
    public void setValidateResult(ValidateResult value) {
        this.validateResult = value;
    }

}
