
package org.mule.modules.avalara.process;

import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessInterceptor;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.modules.avalara.adapters.AvalaraModuleConnectionIdentifierAdapter;
import org.mule.modules.avalara.connection.ConnectionManager;
import org.mule.modules.avalara.connection.UnableToAcquireConnectionException;
import org.mule.modules.avalara.connection.UnableToReleaseConnectionException;
import org.mule.modules.avalara.connectivity.AvalaraModuleConnectionKey;
import org.mule.modules.avalara.processors.ConnectivityProcessor;
import org.mule.security.oauth.callback.ProcessCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-11-11T05:00:21-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class AvalaraModuleManagedConnectionProcessInterceptor<T >
    extends ExpressionEvaluatorSupport
    implements ProcessInterceptor<T, AvalaraModuleConnectionIdentifierAdapter>
{

    private static Logger logger = LoggerFactory.getLogger(AvalaraModuleManagedConnectionProcessInterceptor.class);
    private final ConnectionManager<AvalaraModuleConnectionKey, AvalaraModuleConnectionIdentifierAdapter> connectionManager;
    private final MuleContext muleContext;
    private final ProcessInterceptor<T, AvalaraModuleConnectionIdentifierAdapter> next;

    public AvalaraModuleManagedConnectionProcessInterceptor(ProcessInterceptor<T, AvalaraModuleConnectionIdentifierAdapter> next, ConnectionManager<AvalaraModuleConnectionKey, AvalaraModuleConnectionIdentifierAdapter> connectionManager, MuleContext muleContext) {
        this.next = next;
        this.connectionManager = connectionManager;
        this.muleContext = muleContext;
    }

    @Override
    public T execute(ProcessCallback<T, AvalaraModuleConnectionIdentifierAdapter> processCallback, AvalaraModuleConnectionIdentifierAdapter object, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        AvalaraModuleConnectionIdentifierAdapter connection = null;
        AvalaraModuleConnectionKey key = null;
        if (hasConnectionKeysOverride(messageProcessor)) {
            ConnectivityProcessor connectivityProcessor = ((ConnectivityProcessor) messageProcessor);
            final String _transformedAccount = ((String) evaluateAndTransform(muleContext, event, connectivityProcessor.typeFor("_accountType"), null, connectivityProcessor.getAccount()));
            if (_transformedAccount == null) {
                throw new UnableToAcquireConnectionException("Parameter account in method connect can't be null because is not @Optional");
            }
            final String _transformedAvalaraClient = ((String) evaluateAndTransform(muleContext, event, connectivityProcessor.typeFor("_avalaraClientType"), null, connectivityProcessor.getAvalaraClient()));
            if (_transformedAvalaraClient == null) {
                throw new UnableToAcquireConnectionException("Parameter avalaraClient in method connect can't be null because is not @Optional");
            }
            final String _transformedLicense = ((String) evaluateAndTransform(muleContext, event, connectivityProcessor.typeFor("_licenseType"), null, connectivityProcessor.getLicense()));
            if (_transformedLicense == null) {
                throw new UnableToAcquireConnectionException("Parameter license in method connect can't be null because is not @Optional");
            }
            key = new AvalaraModuleConnectionKey(_transformedAccount, _transformedAvalaraClient, _transformedLicense);
        } else {
            key = connectionManager.getEvaluatedConnectionKey(event);
        }
        try {
            if (logger.isDebugEnabled()) {
                logger.debug(("Attempting to acquire connection using "+ key.toString()));
            }
            connection = connectionManager.acquireConnection(key);
            if (connection == null) {
                throw new UnableToAcquireConnectionException();
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug((("Connection has been acquired with [id="+ connection.getConnectionIdentifier())+"]"));
                }
            }
            return next.execute(processCallback, connection, messageProcessor, event);
        } catch (Exception e) {
            if (processCallback.getManagedExceptions()!= null) {
                for (Class exceptionClass: ((List<Class<? extends Exception>> ) processCallback.getManagedExceptions())) {
                    if (exceptionClass.isInstance(e)) {
                        if (logger.isDebugEnabled()) {
                            logger.debug((((("An exception ( "+ exceptionClass.getName())+") has been thrown. Destroying the connection with [id=")+ connection.getConnectionIdentifier())+"]"));
                        }
                        try {
                            if (connection!= null) {
                                connectionManager.destroyConnection(key, connection);
                                connection = null;
                            }
                        } catch (Exception innerException) {
                            logger.error(innerException.getMessage(), innerException);
                        }
                    }
                }
            }
            throw e;
        } finally {
            try {
                if (connection!= null) {
                    if (logger.isDebugEnabled()) {
                        logger.debug((("Releasing the connection back into the pool [id="+ connection.getConnectionIdentifier())+"]"));
                    }
                    connectionManager.releaseConnection(key, connection);
                }
            } catch (Exception e) {
                throw new UnableToReleaseConnectionException(e);
            }
        }
    }

    /**
     * Validates that the current message processor has changed any of its connection parameters at processor level. If so, a new AvalaraModuleConnectionKey must be generated
     * 
     * @param messageProcessor
     *     the message processor to test against the keys
     * @return
     *     true if any of the parameters in @Connect method annotated with @ConnectionKey was override in the XML, false otherwise  
     */
    private Boolean hasConnectionKeysOverride(MessageProcessor messageProcessor) {
        if ((messageProcessor == null)||(!(messageProcessor instanceof ConnectivityProcessor))) {
            return false;
        }
        ConnectivityProcessor connectivityProcessor = ((ConnectivityProcessor) messageProcessor);
        if (connectivityProcessor.getAccount()!= null) {
            return true;
        }
        if (connectivityProcessor.getAvalaraClient()!= null) {
            return true;
        }
        return false;
    }

    public T execute(ProcessCallback<T, AvalaraModuleConnectionIdentifierAdapter> processCallback, AvalaraModuleConnectionIdentifierAdapter object, Filter filter, MuleMessage message)
        throws Exception
    {
        throw new UnsupportedOperationException();
    }

}
