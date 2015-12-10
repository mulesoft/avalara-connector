/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under
 * the terms of the CPAL v1.0 license, a copy of which has been included with this
 * distribution in the LICENSE.md file.
 */

package org.mule.modules.avalara;


import org.apache.commons.lang.StringUtils;

import com.avalara.avatax.services.BatchFetch;
import com.avalara.avatax.services.BatchFileFetch;
import com.avalara.avatax.services.BatchSave;
import com.avalara.avatax.services.IsAuthorized;
import com.avalara.avatax.services.Ping;


/**
 * @author Damian Pelaez
 * @since Nov 4, 2013
 */

public enum BatchRequestType implements RequestType
{
    /**
     * BatchFetch uses a generic FetchRequest object to return details about
     * a specified batch or group of batches. Filters must be populated (as the
     * service will otherwise return all accessible records of the specified
     * type).
     * The response object is returned in Common Response Format, with an array
     * of Batch objects that meet the criteria of the FetchRequest.
     */
    BatchFetch(BatchFetch.class),

    /**
     * BatchFileFetch uses a generic FetchRequest object to return details about
     * a specified batch file or group of batch files. Filters must be populated
     * (as the service will otherwise return all accessible records of the
     * specified type).
     * The response object is returned in Common Response Format, with an array
     * of BatchFile objects that meet the criteria of the FetchRequest.
     */
    BatchFileFetch(BatchFileFetch.class),
    
    /**
     * BatchSave uses a Batch object to load and save a batch into the AvaTax
     * system. It will automatically process the loaded batch. The file loaded
     * needs to be in a .csv, .xls, or .xlsx format, with a header row, and data
     * consistent with the appropriate import format.
     */
    BatchSave(BatchSave.class),
    
    /**
     * Ping Avalara Batch Service to test connectivity and version of the service.
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
    
    private BatchRequestType(Class<?> type)
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
    public String getSimpleName()
    {
        return getType().getSimpleName();
    }
    
    public String getResourceName()
    {
        return StringUtils.uncapitalize(getSimpleName());
    }
}
