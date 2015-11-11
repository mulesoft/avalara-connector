
package org.mule.modules.avalara.processors;

import java.lang.reflect.Type;
import javax.annotation.Generated;
import org.mule.devkit.processor.DevkitBasedMessageProcessor;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-11-11T05:00:21-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public abstract class AbstractConnectedProcessor
    extends DevkitBasedMessageProcessor
    implements ConnectivityProcessor
{

    protected Object account;
    protected String _accountType;
    protected Object avalaraClient;
    protected String _avalaraClientType;
    protected Object license;
    protected String _licenseType;

    public AbstractConnectedProcessor(String operationName) {
        super(operationName);
    }

    /**
     * Sets avalaraClient
     * 
     * @param value Value to set
     */
    public void setAvalaraClient(Object value) {
        this.avalaraClient = value;
    }

    /**
     * Retrieves avalaraClient
     * 
     */
    @Override
    public Object getAvalaraClient() {
        return this.avalaraClient;
    }

    /**
     * Sets account
     * 
     * @param value Value to set
     */
    public void setAccount(Object value) {
        this.account = value;
    }

    /**
     * Retrieves account
     * 
     */
    @Override
    public Object getAccount() {
        return this.account;
    }

    /**
     * Sets license
     * 
     * @param value Value to set
     */
    public void setLicense(Object value) {
        this.license = value;
    }

    /**
     * Retrieves license
     * 
     */
    @Override
    public Object getLicense() {
        return this.license;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public Type typeFor(String fieldName)
        throws NoSuchFieldException
    {
        return AbstractConnectedProcessor.class.getDeclaredField(fieldName).getGenericType();
    }

}
