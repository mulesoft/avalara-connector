
package org.mule.modules.avalara.adapters;

import javax.annotation.Generated;
import org.mule.modules.avalara.AvalaraModule;
import org.mule.modules.avalara.connection.Connection;


/**
 * A <code>AvalaraModuleConnectionIdentifierAdapter</code> is a wrapper around {@link AvalaraModule } that implements {@link org.mule.devkit.dynamic.api.helper.Connection} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-11-11T05:00:21-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class AvalaraModuleConnectionIdentifierAdapter
    extends AvalaraModuleProcessAdapter
    implements Connection
{


    public String getConnectionIdentifier() {
        return super.getConnectionIdentifier();
    }

}
