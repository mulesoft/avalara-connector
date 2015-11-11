
package com.avalara.avatax.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for BatchSaveResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchSaveResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://avatax.avalara.com/services}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="BatchId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EstimatedCompletion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchSaveResult", propOrder = {
    "batchId",
    "estimatedCompletion"
})
public class BatchSaveResult
    extends BaseResult
{

    @XmlElement(name = "BatchId")
    protected int batchId;
    @XmlElement(name = "EstimatedCompletion", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar estimatedCompletion;

    /**
     * Gets the value of the batchId property.
     * 
     */
    public int getBatchId() {
        return batchId;
    }

    /**
     * Sets the value of the batchId property.
     * 
     */
    public void setBatchId(int value) {
        this.batchId = value;
    }

    /**
     * Gets the value of the estimatedCompletion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEstimatedCompletion() {
        return estimatedCompletion;
    }

    /**
     * Sets the value of the estimatedCompletion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEstimatedCompletion(XMLGregorianCalendar value) {
        this.estimatedCompletion = value;
    }

}
