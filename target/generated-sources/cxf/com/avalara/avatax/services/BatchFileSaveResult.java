
package com.avalara.avatax.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BatchFileSaveResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchFileSaveResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://avatax.avalara.com/services}BaseResult">
 *       &lt;sequence>
 *         &lt;element name="BatchFileId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchFileSaveResult", propOrder = {
    "batchFileId"
})
public class BatchFileSaveResult
    extends BaseResult
{

    @XmlElement(name = "BatchFileId")
    protected int batchFileId;

    /**
     * Gets the value of the batchFileId property.
     * 
     */
    public int getBatchFileId() {
        return batchFileId;
    }

    /**
     * Sets the value of the batchFileId property.
     * 
     */
    public void setBatchFileId(int value) {
        this.batchFileId = value;
    }

}
