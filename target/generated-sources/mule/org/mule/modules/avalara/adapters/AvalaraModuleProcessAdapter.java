
package org.mule.modules.avalara.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.avalara.AvalaraModule;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>AvalaraModuleProcessAdapter</code> is a wrapper around {@link AvalaraModule } that enables custom processing strategies.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-11-11T05:00:21-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class AvalaraModuleProcessAdapter
    extends AvalaraModuleLifecycleAdapter
    implements ProcessAdapter<AvalaraModuleCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, AvalaraModuleCapabilitiesAdapter> getProcessTemplate() {
        final AvalaraModuleCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,AvalaraModuleCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, AvalaraModuleCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, AvalaraModuleCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
