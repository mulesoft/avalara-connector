
package com.avalara.avatax.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValidateResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValidateResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://avatax.avalara.com/services}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="ValidAddresses" type="{http://avatax.avalara.com/services}ArrayOfValidAddress" minOccurs="0"/>
 *         &lt;element name="Taxable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidateResult", propOrder = {
    "validAddresses",
    "taxable"
})
public class ValidateResult
    extends BaseResult
{

    @XmlElement(name = "ValidAddresses")
    protected ArrayOfValidAddress validAddresses;
    @XmlElement(name = "Taxable")
    protected boolean taxable;

    /**
     * Gets the value of the validAddresses property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfValidAddress }
     *     
     */
    public ArrayOfValidAddress getValidAddresses() {
        return validAddresses;
    }

    /**
     * Sets the value of the validAddresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfValidAddress }
     *     
     */
    public void setValidAddresses(ArrayOfValidAddress value) {
        this.validAddresses = value;
    }

    /**
     * Gets the value of the taxable property.
     * 
     */
    public boolean isTaxable() {
        return taxable;
    }

    /**
     * Sets the value of the taxable property.
     * 
     */
    public void setTaxable(boolean value) {
        this.taxable = value;
    }

}
