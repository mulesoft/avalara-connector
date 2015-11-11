
package org.mule.modules.avalara.processors;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.datatype.XMLGregorianCalendar;
import com.avalara.avatax.services.PostTaxResult;
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
import org.mule.modules.avalara.AvalaraDocumentType;
import org.mule.modules.avalara.AvalaraModule;
import org.mule.modules.avalara.connectivity.AvalaraModuleConnectionManager;
import org.mule.modules.avalara.exception.AvalaraAuthenticationException;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * PostTaxMessageProcessor invokes the {@link org.mule.modules.avalara.AvalaraModule#postTax(java.lang.String, java.lang.String, org.mule.modules.avalara.AvalaraDocumentType, java.lang.String, javax.xml.datatype.XMLGregorianCalendar, java.lang.String, java.lang.String, boolean, java.lang.String)} method in {@link AvalaraModule }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-11-11T05:00:21-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class PostTaxMessageProcessor
    extends AbstractConnectedProcessor
    implements MessageProcessor, OperationMetaDataEnabled
{

    protected Object docId;
    protected String _docIdType;
    protected Object companyCode;
    protected String _companyCodeType;
    protected Object docType;
    protected AvalaraDocumentType _docTypeType;
    protected Object docCode;
    protected String _docCodeType;
    protected Object docDate;
    protected XMLGregorianCalendar _docDateType;
    protected Object totalAmount;
    protected String _totalAmountType;
    protected Object totalTax;
    protected String _totalTaxType;
    protected Object commit;
    protected boolean _commitType;
    protected Object newDocCode;
    protected String _newDocCodeType;

    public PostTaxMessageProcessor(String operationName) {
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
     * Sets docType
     * 
     * @param value Value to set
     */
    public void setDocType(Object value) {
        this.docType = value;
    }

    /**
     * Sets commit
     * 
     * @param value Value to set
     */
    public void setCommit(Object value) {
        this.commit = value;
    }

    /**
     * Sets newDocCode
     * 
     * @param value Value to set
     */
    public void setNewDocCode(Object value) {
        this.newDocCode = value;
    }

    /**
     * Sets totalAmount
     * 
     * @param value Value to set
     */
    public void setTotalAmount(Object value) {
        this.totalAmount = value;
    }

    /**
     * Sets docDate
     * 
     * @param value Value to set
     */
    public void setDocDate(Object value) {
        this.docDate = value;
    }

    /**
     * Sets totalTax
     * 
     * @param value Value to set
     */
    public void setTotalTax(Object value) {
        this.totalTax = value;
    }

    /**
     * Sets docId
     * 
     * @param value Value to set
     */
    public void setDocId(Object value) {
        this.docId = value;
    }

    /**
     * Sets docCode
     * 
     * @param value Value to set
     */
    public void setDocCode(Object value) {
        this.docCode = value;
    }

    /**
     * Sets companyCode
     * 
     * @param value Value to set
     */
    public void setCompanyCode(Object value) {
        this.companyCode = value;
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
            final String _transformedDocId = ((String) evaluateAndTransform(getMuleContext(), event, PostTaxMessageProcessor.class.getDeclaredField("_docIdType").getGenericType(), null, docId));
            final String _transformedCompanyCode = ((String) evaluateAndTransform(getMuleContext(), event, PostTaxMessageProcessor.class.getDeclaredField("_companyCodeType").getGenericType(), null, companyCode));
            final AvalaraDocumentType _transformedDocType = ((AvalaraDocumentType) evaluateAndTransform(getMuleContext(), event, PostTaxMessageProcessor.class.getDeclaredField("_docTypeType").getGenericType(), null, docType));
            final String _transformedDocCode = ((String) evaluateAndTransform(getMuleContext(), event, PostTaxMessageProcessor.class.getDeclaredField("_docCodeType").getGenericType(), null, docCode));
            final XMLGregorianCalendar _transformedDocDate = ((XMLGregorianCalendar) evaluateAndTransform(getMuleContext(), event, PostTaxMessageProcessor.class.getDeclaredField("_docDateType").getGenericType(), null, docDate));
            final String _transformedTotalAmount = ((String) evaluateAndTransform(getMuleContext(), event, PostTaxMessageProcessor.class.getDeclaredField("_totalAmountType").getGenericType(), null, totalAmount));
            final String _transformedTotalTax = ((String) evaluateAndTransform(getMuleContext(), event, PostTaxMessageProcessor.class.getDeclaredField("_totalTaxType").getGenericType(), null, totalTax));
            final Boolean _transformedCommit = ((Boolean) evaluateAndTransform(getMuleContext(), event, PostTaxMessageProcessor.class.getDeclaredField("_commitType").getGenericType(), null, commit));
            final String _transformedNewDocCode = ((String) evaluateAndTransform(getMuleContext(), event, PostTaxMessageProcessor.class.getDeclaredField("_newDocCodeType").getGenericType(), null, newDocCode));
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
                    return ((AvalaraModule) object).postTax(_transformedDocId, _transformedCompanyCode, _transformedDocType, _transformedDocCode, _transformedDocDate, _transformedTotalAmount, _transformedTotalTax, _transformedCommit, _transformedNewDocCode);
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
        return new DefaultResult<MetaData>(new DefaultMetaData(getPojoOrSimpleModel(PostTaxResult.class)));
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
                    return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error processing metadata at AvalaraModule at postTax retrieving was successful but result is null");
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
