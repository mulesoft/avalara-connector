
/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
 */

package org.mule.modules.unit;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.Validate;
import org.junit.Test;

/**
 * TODO: Description of the class, Comments in english by default
 * 
 * @author Gaston Ponti
 * @since Oct 19, 2011
 */
public class DateConverterTest
{
    @Test
    public void converterTest()
    {
        XMLGregorianCalendar c = (XMLGregorianCalendar) conv.convert(XMLGregorianCalendar.class, new Date());
    }

    private Converter conv;
    private final DatatypeFactory datatypeFactory;
    {
        conv = new Converter()
        {

            @SuppressWarnings("rawtypes")
            @Override
            public Object convert(Class arg0, Object arg1)
            {
                Validate.isTrue(arg0 == XMLGregorianCalendar.class);

                return toGregorianCalendar((Date) arg1);
            }
        };
        try
        {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch (DatatypeConfigurationException e)
        {
            throw new AssertionError(e);
        }
    }

    private XMLGregorianCalendar toGregorianCalendar(Date openingBalanceDate)
    {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(openingBalanceDate);
        return datatypeFactory.newXMLGregorianCalendar(cal);
    }
}
