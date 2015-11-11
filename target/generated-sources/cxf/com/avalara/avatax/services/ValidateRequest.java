
package com.avalara.avatax.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ValidateRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValidateRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://avatax.avalara.com/services}BaseAddress" minOccurs="0"/>
 *         &lt;element name="TextCase" type="{http://avatax.avalara.com/services}TextCase"/>
 *         &lt;element name="Coordinates" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Taxability" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidateRequest", propOrder = {
    "address",
    "textCase",
    "coordinates",
    "taxability",
    "date"
})
public class ValidateRequest {

    @XmlElement(name = "Address")
    protected BaseAddress address;
    @XmlElement(name = "TextCase", required = true)
    protected TextCase textCase;
    @XmlElement(name = "Coordinates")
    protected boolean coordinates;
    @XmlElement(name = "Taxability")
    protected boolean taxability;
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link BaseAddress }
     *     
     */
    public BaseAddress getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseAddress }
     *     
     */
    public void setAddress(BaseAddress value) {
        this.address = value;
    }

    /**
     * Gets the value of the textCase property.
     * 
     * @return
     *     possible object is
     *     {@link TextCase }
     *     
     */
    public TextCase getTextCase() {
        return textCase;
    }

    /**
     * Sets the value of the textCase property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextCase }
     *     
     */
    public void setTextCase(TextCase value) {
        this.textCase = value;
    }

    /**
     * Gets the value of the coordinates property.
     * 
     */
    public boolean isCoordinates() {
        return coordinates;
    }

    /**
     * Sets the value of the coordinates property.
     * 
     */
    public void setCoordinates(boolean value) {
        this.coordinates = value;
    }

    /**
     * Gets the value of the taxability property.
     * 
     */
    public boolean isTaxability() {
        return taxability;
    }

    /**
     * Sets the value of the taxability property.
     * 
     */
    public void setTaxability(boolean value) {
        this.taxability = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

}
