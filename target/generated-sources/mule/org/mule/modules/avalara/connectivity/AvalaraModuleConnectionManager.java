
package org.mule.modules.avalara.connectivity;

import javax.annotation.Generated;
import org.apache.commons.pool.KeyedObjectPool;
import org.mule.api.ConnectionException;
import org.mule.api.ConnectionExceptionCode;
import org.mule.api.MetadataAware;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.config.MuleProperties;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.context.MuleContextAware;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.retry.RetryPolicyTemplate;
import org.mule.common.DefaultResult;
import org.mule.common.DefaultTestResult;
import org.mule.common.FailureType;
import org.mule.common.TestResult;
import org.mule.common.Testable;
import org.mule.config.PoolingProfile;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.modules.avalara.AvalaraModule;
import org.mule.modules.avalara.adapters.AvalaraModuleConnectionIdentifierAdapter;
import org.mule.modules.avalara.connection.ConnectionManager;
import org.mule.modules.avalara.connection.UnableToAcquireConnectionException;
import org.mule.modules.avalara.pooling.DevkitGenericKeyedObjectPool;


/**
 * A {@code AvalaraModuleConnectionManager} is a wrapper around {@link AvalaraModule } that adds connection management capabilities to the pojo.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-11-11T05:00:21-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class AvalaraModuleConnectionManager
    extends ExpressionEvaluatorSupport
    implements MetadataAware, MuleContextAware, ProcessAdapter<AvalaraModuleConnectionIdentifierAdapter> , Capabilities, Disposable, Initialisable, Testable, ConnectionManager<AvalaraModuleConnectionKey, AvalaraModuleConnectionIdentifierAdapter>
{

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
    private String taxServiceEndpoint;
    private String addressServiceEndpoint;
    private String batchServiceEndpoint;
    /**
     * Mule Context
     * 
     */
    protected MuleContext muleContext;
    /**
     * Flow Construct
     * 
     */
    protected FlowConstruct flowConstruct;
    /**
     * Connector Pool
     * 
     */
    private KeyedObjectPool connectionPool;
    protected PoolingProfile poolingProfile;
    protected RetryPolicyTemplate retryPolicyTemplate;
    private final static String MODULE_NAME = "Avalara";
    private final static String MODULE_VERSION = "3.0.3";
    private final static String DEVKIT_VERSION = "3.5.3";
    private final static String DEVKIT_BUILD = "UNNAMED.2049.ec39f2b";
    private final static String MIN_MULE_VERSION = "3.5.0";

    /**
     * Sets taxServiceEndpoint
     * 
     * @param value Value to set
     */
    public void setTaxServiceEndpoint(String value) {
        this.taxServiceEndpoint = value;
    }

    /**
     * Retrieves taxServiceEndpoint
     * 
     */
    public String getTaxServiceEndpoint() {
        return this.taxServiceEndpoint;
    }

    /**
     * Sets addressServiceEndpoint
     * 
     * @param value Value to set
     */
    public void setAddressServiceEndpoint(String value) {
        this.addressServiceEndpoint = value;
    }

    /**
     * Retrieves addressServiceEndpoint
     * 
     */
    public String getAddressServiceEndpoint() {
        return this.addressServiceEndpoint;
    }

    /**
     * Sets batchServiceEndpoint
     * 
     * @param value Value to set
     */
    public void setBatchServiceEndpoint(String value) {
        this.batchServiceEndpoint = value;
    }

    /**
     * Retrieves batchServiceEndpoint
     * 
     */
    public String getBatchServiceEndpoint() {
        return this.batchServiceEndpoint;
    }

    /**
     * Sets muleContext
     * 
     * @param value Value to set
     */
    public void setMuleContext(MuleContext value) {
        this.muleContext = value;
    }

    /**
     * Retrieves muleContext
     * 
     */
    public MuleContext getMuleContext() {
        return this.muleContext;
    }

    /**
     * Sets flowConstruct
     * 
     * @param value Value to set
     */
    public void setFlowConstruct(FlowConstruct value) {
        this.flowConstruct = value;
    }

    /**
     * Retrieves flowConstruct
     * 
     */
    public FlowConstruct getFlowConstruct() {
        return this.flowConstruct;
    }

    /**
     * Sets poolingProfile
     * 
     * @param value Value to set
     */
    public void setPoolingProfile(PoolingProfile value) {
        this.poolingProfile = value;
    }

    /**
     * Retrieves poolingProfile
     * 
     */
    public PoolingProfile getPoolingProfile() {
        return this.poolingProfile;
    }

    /**
     * Sets retryPolicyTemplate
     * 
     * @param value Value to set
     */
    public void setRetryPolicyTemplate(RetryPolicyTemplate value) {
        this.retryPolicyTemplate = value;
    }

    /**
     * Retrieves retryPolicyTemplate
     * 
     */
    public RetryPolicyTemplate getRetryPolicyTemplate() {
        return this.retryPolicyTemplate;
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

    public void initialise() {
        connectionPool = new DevkitGenericKeyedObjectPool(new AvalaraModuleConnectionFactory(this), poolingProfile);
        if (retryPolicyTemplate == null) {
            retryPolicyTemplate = muleContext.getRegistry().lookupObject(MuleProperties.OBJECT_DEFAULT_RETRY_POLICY_TEMPLATE);
        }
    }

    @Override
    public void dispose() {
        try {
            connectionPool.close();
        } catch (Exception e) {
        }
    }

    public AvalaraModuleConnectionIdentifierAdapter acquireConnection(AvalaraModuleConnectionKey key)
        throws Exception
    {
        return ((AvalaraModuleConnectionIdentifierAdapter) connectionPool.borrowObject(key));
    }

    public void releaseConnection(AvalaraModuleConnectionKey key, AvalaraModuleConnectionIdentifierAdapter connection)
        throws Exception
    {
        connectionPool.returnObject(key, connection);
    }

    public void destroyConnection(AvalaraModuleConnectionKey key, AvalaraModuleConnectionIdentifierAdapter connection)
        throws Exception
    {
        connectionPool.invalidateObject(key, connection);
    }

    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        if (capability == ModuleCapability.CONNECTION_MANAGEMENT_CAPABLE) {
            return true;
        }
        return false;
    }

    @Override
    public<P >ProcessTemplate<P, AvalaraModuleConnectionIdentifierAdapter> getProcessTemplate() {
        return new AvalaraModuleManagedConnectionProcessTemplate(this, muleContext);
    }

    @Override
    public AvalaraModuleConnectionKey getDefaultConnectionKey() {
        return new AvalaraModuleConnectionKey(getAccount(), getAvalaraClient(), getLicense());
    }

    @Override
    public AvalaraModuleConnectionKey getEvaluatedConnectionKey(MuleEvent event)
        throws Exception
    {
        if (event!= null) {
            final String _transformedAccount = ((String) evaluateAndTransform(muleContext, event, this.getClass().getDeclaredField("account").getGenericType(), null, getAccount()));
            if (_transformedAccount == null) {
                throw new UnableToAcquireConnectionException("Parameter account in method connect can't be null because is not @Optional");
            }
            final String _transformedAvalaraClient = ((String) evaluateAndTransform(muleContext, event, this.getClass().getDeclaredField("avalaraClient").getGenericType(), null, getAvalaraClient()));
            if (_transformedAvalaraClient == null) {
                throw new UnableToAcquireConnectionException("Parameter avalaraClient in method connect can't be null because is not @Optional");
            }
            final String _transformedLicense = ((String) evaluateAndTransform(muleContext, event, this.getClass().getDeclaredField("license").getGenericType(), null, getLicense()));
            if (_transformedLicense == null) {
                throw new UnableToAcquireConnectionException("Parameter license in method connect can't be null because is not @Optional");
            }
            return new AvalaraModuleConnectionKey(_transformedAccount, _transformedAvalaraClient, _transformedLicense);
        }
        return getDefaultConnectionKey();
    }

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

    public String getMinMuleVersion() {
        return MIN_MULE_VERSION;
    }

    public TestResult test() {
        AvalaraModuleConnectionIdentifierAdapter connection = null;
        DefaultTestResult result;
        AvalaraModuleConnectionKey key = getDefaultConnectionKey();
        try {
            connection = acquireConnection(key);
            result = new DefaultTestResult(org.mule.common.Result.Status.SUCCESS);
        } catch (Exception e) {
            try {
                destroyConnection(key, connection);
            } catch (Exception ie) {
            }
            result = ((DefaultTestResult) buildFailureTestResult(e));
        } finally {
            if (connection!= null) {
                try {
                    releaseConnection(key, connection);
                } catch (Exception ie) {
                }
            }
        }
        return result;
    }

    public DefaultResult buildFailureTestResult(Exception exception) {
        DefaultTestResult result;
        if (exception instanceof ConnectionException) {
            ConnectionExceptionCode code = ((ConnectionException) exception).getCode();
            if (code == ConnectionExceptionCode.UNKNOWN_HOST) {
                result = new DefaultTestResult(org.mule.common.Result.Status.FAILURE, exception.getMessage(), FailureType.UNKNOWN_HOST, exception);
            } else {
                if (code == ConnectionExceptionCode.CANNOT_REACH) {
                    result = new DefaultTestResult(org.mule.common.Result.Status.FAILURE, exception.getMessage(), FailureType.RESOURCE_UNAVAILABLE, exception);
                } else {
                    if (code == ConnectionExceptionCode.INCORRECT_CREDENTIALS) {
                        result = new DefaultTestResult(org.mule.common.Result.Status.FAILURE, exception.getMessage(), FailureType.INVALID_CREDENTIALS, exception);
                    } else {
                        if (code == ConnectionExceptionCode.CREDENTIALS_EXPIRED) {
                            result = new DefaultTestResult(org.mule.common.Result.Status.FAILURE, exception.getMessage(), FailureType.INVALID_CREDENTIALS, exception);
                        } else {
                            if (code == ConnectionExceptionCode.UNKNOWN) {
                                result = new DefaultTestResult(org.mule.common.Result.Status.FAILURE, exception.getMessage(), FailureType.UNSPECIFIED, exception);
                            } else {
                                result = new DefaultTestResult(org.mule.common.Result.Status.FAILURE, exception.getMessage(), FailureType.UNSPECIFIED, exception);
                            }
                        }
                    }
                }
            }
        } else {
            result = new DefaultTestResult(org.mule.common.Result.Status.FAILURE, exception.getMessage(), FailureType.UNSPECIFIED, exception);
        }
        return result;
    }

}
