
package com.avalara.avatax.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValidAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValidAddress">
 *   &lt;complexContent>
 *     &lt;extension base="{http://avatax.avalara.com/services}BaseAddress">
 *       &lt;sequence>
 *         &lt;element name="Line4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FipsCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CarrierRoute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostNet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddressType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ValidateStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GeocodeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidAddress", propOrder = {
    "line4",
    "county",
    "fipsCode",
    "carrierRoute",
    "postNet",
    "addressType",
    "validateStatus",
    "geocodeType"
})
public class ValidAddress
    extends BaseAddress
{

    @XmlElement(name = "Line4")
    protected String line4;
    @XmlElement(name = "County")
    protected String county;
    @XmlElement(name = "FipsCode")
    protected String fipsCode;
    @XmlElement(name = "CarrierRoute")
    protected String carrierRoute;
    @XmlElement(name = "PostNet")
    protected String postNet;
    @XmlElement(name = "AddressType")
    protected String addressType;
    @XmlElement(name = "ValidateStatus")
    protected String validateStatus;
    @XmlElement(name = "GeocodeType")
    protected String geocodeType;

    /**
     * Gets the value of the line4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLine4() {
        return line4;
    }

    /**
     * Sets the value of the line4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLine4(String value) {
        this.line4 = value;
    }

    /**
     * Gets the value of the county property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounty() {
        return county;
    }

    /**
     * Sets the value of the county property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounty(String value) {
        this.county = value;
    }

    /**
     * Gets the value of the fipsCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFipsCode() {
        return fipsCode;
    }

    /**
     * Sets the value of the fipsCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFipsCode(String value) {
        this.fipsCode = value;
    }

    /**
     * Gets the value of the carrierRoute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarrierRoute() {
        return carrierRoute;
    }

    /**
     * Sets the value of the carrierRoute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarrierRoute(String value) {
        this.carrierRoute = value;
    }

    /**
     * Gets the value of the postNet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostNet() {
        return postNet;
    }

    /**
     * Sets the value of the postNet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostNet(String value) {
        this.postNet = value;
    }

    /**
     * Gets the value of the addressType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * Sets the value of the addressType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressType(String value) {
        this.addressType = value;
    }

    /**
     * Gets the value of the validateStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidateStatus() {
        return validateStatus;
    }

    /**
     * Sets the value of the validateStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidateStatus(String value) {
        this.validateStatus = value;
    }

    /**
     * Gets the value of the geocodeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeocodeType() {
        return geocodeType;
    }

    /**
     * Sets the value of the geocodeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeocodeType(String value) {
        this.geocodeType = value;
    }

}
