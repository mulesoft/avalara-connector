
package org.mule.modules.avalara.processors;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.avalara.avatax.services.BatchSaveResult;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.config.ConfigurationException;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.registry.RegistrationException;
import org.mule.common.DefaultResult;
import org.mule.common.FailureType;
import org.mule.common.Result;
import org.mule.common.metadata.ConnectorMetaDataEnabled;
import org.mule.common.metadata.DefaultMetaData;
import org.mule.common.metadata.DefaultPojoMetaDataModel;
import org.mule.common.metadata.DefaultSimpleMetaDataModel;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.MetaDataModel;
import org.mule.common.metadata.OperationMetaDataEnabled;
import org.mule.common.metadata.datatype.DataType;
import org.mule.common.metadata.datatype.DataTypeFactory;
import org.mule.modules.avalara.AvalaraModule;
import org.mule.modules.avalara.BatchType;
import org.mule.modules.avalara.connectivity.AvalaraModuleConnectionManager;
import org.mule.modules.avalara.exception.AvalaraAuthenticationException;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * SaveBatchMessageProcessor invokes the {@link org.mule.modules.avalara.AvalaraModule#saveBatch(org.mule.modules.avalara.BatchType, int, java.lang.String, java.lang.String)} method in {@link AvalaraModule }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-11-11T05:00:21-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class SaveBatchMessageProcessor
    extends AbstractConnectedProcessor
    implements MessageProcessor, OperationMetaDataEnabled
{

    protected Object batchType;
    protected BatchType _batchTypeType;
    protected Object companyId;
    protected int _companyIdType;
    protected Object content;
    protected String _contentType;
    protected Object batchName;
    protected String _batchNameType;

    public SaveBatchMessageProcessor(String operationName) {
        super(operationName);
    }

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    @Override
    public void start()
        throws MuleException
    {
        super.start();
    }

    @Override
    public void stop()
        throws MuleException
    {
        super.stop();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Sets content
     * 
     * @param value Value to set
     */
    public void setContent(Object value) {
        this.content = value;
    }

    /**
     * Sets batchName
     * 
     * @param value Value to set
     */
    public void setBatchName(Object value) {
        this.batchName = value;
    }

    /**
     * Sets batchType
     * 
     * @param value Value to set
     */
    public void setBatchType(Object value) {
        this.batchType = value;
    }

    /**
     * Sets companyId
     * 
     * @param value Value to set
     */
    public void setCompanyId(Object value) {
        this.companyId = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws Exception
     */
    public MuleEvent doProcess(final MuleEvent event)
        throws Exception
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(AvalaraModuleConnectionManager.class, false, event);
            final BatchType _transformedBatchType = ((BatchType) evaluateAndTransform(getMuleContext(), event, SaveBatchMessageProcessor.class.getDeclaredField("_batchTypeType").getGenericType(), null, batchType));
            final Integer _transformedCompanyId = ((Integer) evaluateAndTransform(getMuleContext(), event, SaveBatchMessageProcessor.class.getDeclaredField("_companyIdType").getGenericType(), null, companyId));
            final String _transformedContent = ((String) evaluateAndTransform(getMuleContext(), event, SaveBatchMessageProcessor.class.getDeclaredField("_contentType").getGenericType(), null, content));
            final String _transformedBatchName = ((String) evaluateAndTransform(getMuleContext(), event, SaveBatchMessageProcessor.class.getDeclaredField("_batchNameType").getGenericType(), null, batchName));
            Object resultPayload;
            final ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            resultPayload = processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class<? extends Exception>> getManagedExceptions() {
                    return Arrays.asList(((Class<? extends Exception> []) new Class[] {AvalaraAuthenticationException.class }));
                }

                public boolean isProtected() {
                    return false;
                }

                public Object process(Object object)
                    throws Exception
                {
                    return ((AvalaraModule) object).saveBatch(_transformedBatchType, _transformedCompanyId, _transformedContent, _transformedBatchName);
                }

            }
            , this, event);
            event.getMessage().setPayload(resultPayload);
            return event;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Result<MetaData> getInputMetaData() {
        return new DefaultResult<MetaData>(null, (Result.Status.SUCCESS));
    }

    @Override
    public Result<MetaData> getOutputMetaData(MetaData inputMetadata) {
        return new DefaultResult<MetaData>(new DefaultMetaData(getPojoOrSimpleModel(BatchSaveResult.class)));
    }

    private MetaDataModel getPojoOrSimpleModel(Class clazz) {
        DataType dataType = DataTypeFactory.getInstance().getDataType(clazz);
        if (DataType.POJO.equals(dataType)) {
            return new DefaultPojoMetaDataModel(clazz);
        } else {
            return new DefaultSimpleMetaDataModel(dataType);
        }
    }

    public Result<MetaData> getGenericMetaData(MetaDataKey metaDataKey) {
        ConnectorMetaDataEnabled connector;
        try {
            connector = ((ConnectorMetaDataEnabled) findOrCreate(AvalaraModuleConnectionManager.class, true, null));
            try {
                Result<MetaData> metadata = connector.getMetaData(metaDataKey);
                if ((Result.Status.FAILURE).equals(metadata.getStatus())) {
                    return metadata;
                }
                if (metadata.get() == null) {
                    return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error processing metadata at AvalaraModule at saveBatch retrieving was successful but result is null");
                }
                return metadata;
            } catch (Exception e) {
                return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
            }
        } catch (ClassCastException cast) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error getting metadata, there was no connection manager available. Maybe you're trying to use metadata from an Oauth connector");
        } catch (ConfigurationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (RegistrationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (IllegalAccessException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (InstantiationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (Exception e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        }
    }

}
