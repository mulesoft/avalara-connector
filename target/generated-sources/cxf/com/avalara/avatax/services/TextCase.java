
package com.avalara.avatax.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TextCase.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TextCase">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Default"/>
 *     &lt;enumeration value="Upper"/>
 *     &lt;enumeration value="Mixed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TextCase")
@XmlEnum
public enum TextCase {

    @XmlEnumValue("Default")
    DEFAULT("Default"),
    @XmlEnumValue("Upper")
    UPPER("Upper"),
    @XmlEnumValue("Mixed")
    MIXED("Mixed");
    private final String value;

    TextCase(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TextCase fromValue(String v) {
        for (TextCase c: TextCase.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
