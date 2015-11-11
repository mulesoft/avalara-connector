
package com.avalara.avatax.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfBatchFile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBatchFile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BatchFile" type="{http://avatax.avalara.com/services}BatchFile" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBatchFile", propOrder = {
    "batchFile"
})
public class ArrayOfBatchFile {

    @XmlElement(name = "BatchFile", nillable = true)
    protected List<BatchFile> batchFile;

    /**
     * Gets the value of the batchFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the batchFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBatchFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BatchFile }
     * 
     * 
     */
    public List<BatchFile> getBatchFile() {
        if (batchFile == null) {
            batchFile = new ArrayList<BatchFile>();
        }
        return this.batchFile;
    }

}
