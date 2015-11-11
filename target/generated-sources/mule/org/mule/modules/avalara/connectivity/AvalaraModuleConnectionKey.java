
package org.mule.modules.avalara.connectivity;

import javax.annotation.Generated;


/**
 * A tuple of connection parameters
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-11-11T05:00:21-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class AvalaraModuleConnectionKey {

    /**
     * 
     */
    private String account;
    /**
     * 
     */
    private String avalaraClient;
    /**
     * 
     */
    private String license;

    public AvalaraModuleConnectionKey(String account, String avalaraClient, String license) {
        this.account = account;
        this.avalaraClient = avalaraClient;
        this.license = license;
    }

    /**
     * Sets avalaraClient
     * 
     * @param value Value to set
     */
    public void setAvalaraClient(String value) {
        this.avalaraClient = value;
    }

    /**
     * Retrieves avalaraClient
     * 
     */
    public String getAvalaraClient() {
        return this.avalaraClient;
    }

    /**
     * Sets account
     * 
     * @param value Value to set
     */
    public void setAccount(String value) {
        this.account = value;
    }

    /**
     * Retrieves account
     * 
     */
    public String getAccount() {
        return this.account;
    }

    /**
     * Sets license
     * 
     * @param value Value to set
     */
    public void setLicense(String value) {
        this.license = value;
    }

    /**
     * Retrieves license
     * 
     */
    public String getLicense() {
        return this.license;
    }

    @Override
    public int hashCode() {
        int result = ((this.account!= null)?this.account.hashCode(): 0);
        result = ((31 *result)+((this.avalaraClient!= null)?this.avalaraClient.hashCode(): 0));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AvalaraModuleConnectionKey)) {
            return false;
        }
        AvalaraModuleConnectionKey that = ((AvalaraModuleConnectionKey) o);
        if (((this.account!= null)?(!this.account.equals(that.account)):(that.account!= null))) {
            return false;
        }
        if (((this.avalaraClient!= null)?(!this.avalaraClient.equals(that.avalaraClient)):(that.avalaraClient!= null))) {
            return false;
        }
        return true;
    }

}
