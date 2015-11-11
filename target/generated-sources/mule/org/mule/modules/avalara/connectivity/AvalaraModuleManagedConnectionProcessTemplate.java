
package org.mule.modules.avalara.connectivity;

import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessInterceptor;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.avalara.adapters.AvalaraModuleConnectionIdentifierAdapter;
import org.mule.modules.avalara.connection.ConnectionManager;
import org.mule.modules.avalara.process.AvalaraModuleManagedConnectionProcessInterceptor;
import org.mule.security.oauth.callback.ProcessCallback;
import org.mule.security.oauth.process.ProcessCallbackProcessInterceptor;
import org.mule.security.oauth.process.RetryProcessInterceptor;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-11-11T05:00:21-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class AvalaraModuleManagedConnectionProcessTemplate<P >implements ProcessTemplate<P, AvalaraModuleConnectionIdentifierAdapter>
{

    private final ProcessInterceptor<P, AvalaraModuleConnectionIdentifierAdapter> processInterceptor;

    public AvalaraModuleManagedConnectionProcessTemplate(ConnectionManager<AvalaraModuleConnectionKey, AvalaraModuleConnectionIdentifierAdapter> connectionManager, MuleContext muleContext) {
        ProcessInterceptor<P, AvalaraModuleConnectionIdentifierAdapter> processCallbackProcessInterceptor = new ProcessCallbackProcessInterceptor<P, AvalaraModuleConnectionIdentifierAdapter>();
        ProcessInterceptor<P, AvalaraModuleConnectionIdentifierAdapter> managedConnectionProcessInterceptor = new AvalaraModuleManagedConnectionProcessInterceptor<P>(processCallbackProcessInterceptor, connectionManager, muleContext);
        ProcessInterceptor<P, AvalaraModuleConnectionIdentifierAdapter> retryProcessInterceptor = new RetryProcessInterceptor<P, AvalaraModuleConnectionIdentifierAdapter>(managedConnectionProcessInterceptor, muleContext, connectionManager.getRetryPolicyTemplate());
        processInterceptor = retryProcessInterceptor;
    }

    public P execute(ProcessCallback<P, AvalaraModuleConnectionIdentifierAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, messageProcessor, event);
    }

    public P execute(ProcessCallback<P, AvalaraModuleConnectionIdentifierAdapter> processCallback, Filter filter, MuleMessage message)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, filter, message);
    }

}
