/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mule.modules.avalara;

import org.apache.commons.lang.StringUtils;

import com.avalara.avatax.services.Ping;
import com.avalara.avatax.services.Validate;
import com.avalara.avatax.services.IsAuthorized;


/**
 * @author Damian Pelaez
 * @since Nov 4, 2013
 */
public enum AddressRequestType implements RequestType
{
    /**
     * Validate performs an explicit address validation. This is a standalone
     * address validation call (meaning address validation only no tax
     * calculations) that is passed to the AvaTax web service.
     * During the same call (or port opening), results are returned with a success
     * message (if no ambiguous address information was passed) together with a
     * normalized address. Otherwise an error message indicating the problem and
     * summary details related to the address submitted is returned.
     */
    Validate(Validate.class),
    
    /**
     * Ping Avalara Address Service to test connectivity and version of the service.
     */
    Ping(Ping.class),
    
    /**
     * IsAuthorized retrieves information about the operations that a user is
     * allowed to perform.
     * A Successful call with valid credentials and a list of valid operations
     * returns a list of those operations the account is authorized to use, which
     * may be a subset of the requested operations and account expiration date.
     * For security, never returns any operations other than the ones specifically
     * requested.
     */
    IsAuthorized(IsAuthorized.class);

    private final Class<?> type;
    
    private AddressRequestType(Class<?> type)
    {
        this.type = type;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public <T> T newInstance()
    {
        try
        {
            return (T) type.newInstance();
        }
        catch (Exception e)
        {
            throw new AssertionError(e);
        }
    }

    /**
     * @return the associated class for this entity type
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> Class<T> getType()
    {
        return (Class<T>) type;
    }
    
    /**
     * @return the simple name of the associated class for this entity type
     */
    @Override
    public String getSimpleName()
    {
        return getType().getSimpleName();
    }
    
    @Override
    public String getResourceName()
    {
        return StringUtils.uncapitalize(getSimpleName());
    }
}
