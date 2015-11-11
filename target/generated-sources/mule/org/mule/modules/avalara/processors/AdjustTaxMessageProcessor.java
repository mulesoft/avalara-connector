
package org.mule.modules.avalara.processors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.xml.datatype.XMLGregorianCalendar;
import com.avalara.avatax.services.AdjustTaxResult;
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
import org.mule.modules.avalara.DetailLevelType;
import org.mule.modules.avalara.ServiceModeType;
import org.mule.modules.avalara.connectivity.AvalaraModuleConnectionManager;
import org.mule.modules.avalara.exception.AvalaraAuthenticationException;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * AdjustTaxMessageProcessor invokes the {@link org.mule.modules.avalara.AvalaraModule#adjustTax(int, java.lang.String, java.lang.String, org.mule.modules.avalara.AvalaraDocumentType, java.lang.String, javax.xml.datatype.XMLGregorianCalendar, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, org.mule.modules.avalara.DetailLevelType, java.lang.String, java.lang.String, boolean, java.lang.String, java.util.Map, java.lang.String, org.mule.modules.avalara.ServiceModeType, javax.xml.datatype.XMLGregorianCalendar, java.lang.String, javax.xml.datatype.XMLGregorianCalendar)} method in {@link AvalaraModule }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-11-11T05:00:21-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class AdjustTaxMessageProcessor
    extends AbstractConnectedProcessor
    implements MessageProcessor, OperationMetaDataEnabled
{

    protected Object adjustmentReason;
    protected int _adjustmentReasonType;
    protected Object adjustmentDescription;
    protected String _adjustmentDescriptionType;
    protected Object companyCode;
    protected String _companyCodeType;
    protected Object docType;
    protected AvalaraDocumentType _docTypeType;
    protected Object docCode;
    protected String _docCodeType;
    protected Object docDate;
    protected XMLGregorianCalendar _docDateType;
    protected Object salespersonCode;
    protected String _salespersonCodeType;
    protected Object customerCode;
    protected String _customerCodeType;
    protected Object customerUsageType;
    protected String _customerUsageTypeType;
    protected Object discount;
    protected String _discountType;
    protected Object purchaseOrderNo;
    protected String _purchaseOrderNoType;
    protected Object exemptionNo;
    protected String _exemptionNoType;
    protected Object originCode;
    protected String _originCodeType;
    protected Object destinationCode;
    protected String _destinationCodeType;
    protected Object baseAddresses;
    protected List<Map<String, Object>> _baseAddressesType;
    protected Object lines;
    protected List<Map<String, Object>> _linesType;
    protected Object detailLevel;
    protected DetailLevelType _detailLevelType;
    protected Object referenceCode;
    protected String _referenceCodeType;
    protected Object locationCode;
    protected String _locationCodeType;
    protected Object commit;
    protected boolean _commitType;
    protected Object batchCode;
    protected String _batchCodeType;
    protected Object taxOverride;
    protected Map<String, Object> _taxOverrideType;
    protected Object currencyCode;
    protected String _currencyCodeType;
    protected Object serviceMode;
    protected ServiceModeType _serviceModeType;
    protected Object paymentDate;
    protected XMLGregorianCalendar _paymentDateType;
    protected Object exchangeRate;
    protected String _exchangeRateType;
    protected Object exchangeRateEffDate;
    protected XMLGregorianCalendar _exchangeRateEffDateType;

    public AdjustTaxMessageProcessor(String operationName) {
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
     * Sets customerUsageType
     * 
     * @param value Value to set
     */
    public void setCustomerUsageType(Object value) {
        this.customerUsageType = value;
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
     * Sets referenceCode
     * 
     * @param value Value to set
     */
    public void setReferenceCode(Object value) {
        this.referenceCode = value;
    }

    /**
     * Sets batchCode
     * 
     * @param value Value to set
     */
    public void setBatchCode(Object value) {
        this.batchCode = value;
    }

    /**
     * Sets taxOverride
     * 
     * @param value Value to set
     */
    public void setTaxOverride(Object value) {
        this.taxOverride = value;
    }

    /**
     * Sets exchangeRate
     * 
     * @param value Value to set
     */
    public void setExchangeRate(Object value) {
        this.exchangeRate = value;
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
     * Sets customerCode
     * 
     * @param value Value to set
     */
    public void setCustomerCode(Object value) {
        this.customerCode = value;
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
     * Sets baseAddresses
     * 
     * @param value Value to set
     */
    public void setBaseAddresses(Object value) {
        this.baseAddresses = value;
    }

    /**
     * Sets paymentDate
     * 
     * @param value Value to set
     */
    public void setPaymentDate(Object value) {
        this.paymentDate = value;
    }

    /**
     * Sets currencyCode
     * 
     * @param value Value to set
     */
    public void setCurrencyCode(Object value) {
        this.currencyCode = value;
    }

    /**
     * Sets serviceMode
     * 
     * @param value Value to set
     */
    public void setServiceMode(Object value) {
        this.serviceMode = value;
    }

    /**
     * Sets adjustmentDescription
     * 
     * @param value Value to set
     */
    public void setAdjustmentDescription(Object value) {
        this.adjustmentDescription = value;
    }

    /**
     * Sets detailLevel
     * 
     * @param value Value to set
     */
    public void setDetailLevel(Object value) {
        this.detailLevel = value;
    }

    /**
     * Sets exemptionNo
     * 
     * @param value Value to set
     */
    public void setExemptionNo(Object value) {
        this.exemptionNo = value;
    }

    /**
     * Sets originCode
     * 
     * @param value Value to set
     */
    public void setOriginCode(Object value) {
        this.originCode = value;
    }

    /**
     * Sets exchangeRateEffDate
     * 
     * @param value Value to set
     */
    public void setExchangeRateEffDate(Object value) {
        this.exchangeRateEffDate = value;
    }

    /**
     * Sets purchaseOrderNo
     * 
     * @param value Value to set
     */
    public void setPurchaseOrderNo(Object value) {
        this.purchaseOrderNo = value;
    }

    /**
     * Sets discount
     * 
     * @param value Value to set
     */
    public void setDiscount(Object value) {
        this.discount = value;
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
     * Sets destinationCode
     * 
     * @param value Value to set
     */
    public void setDestinationCode(Object value) {
        this.destinationCode = value;
    }

    /**
     * Sets locationCode
     * 
     * @param value Value to set
     */
    public void setLocationCode(Object value) {
        this.locationCode = value;
    }

    /**
     * Sets salespersonCode
     * 
     * @param value Value to set
     */
    public void setSalespersonCode(Object value) {
        this.salespersonCode = value;
    }

    /**
     * Sets adjustmentReason
     * 
     * @param value Value to set
     */
    public void setAdjustmentReason(Object value) {
        this.adjustmentReason = value;
    }

    /**
     * Sets lines
     * 
     * @param value Value to set
     */
    public void setLines(Object value) {
        this.lines = value;
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
            final Integer _transformedAdjustmentReason = ((Integer) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_adjustmentReasonType").getGenericType(), null, adjustmentReason));
            final String _transformedAdjustmentDescription = ((String) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_adjustmentDescriptionType").getGenericType(), null, adjustmentDescription));
            final String _transformedCompanyCode = ((String) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_companyCodeType").getGenericType(), null, companyCode));
            final AvalaraDocumentType _transformedDocType = ((AvalaraDocumentType) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_docTypeType").getGenericType(), null, docType));
            final String _transformedDocCode = ((String) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_docCodeType").getGenericType(), null, docCode));
            final XMLGregorianCalendar _transformedDocDate = ((XMLGregorianCalendar) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_docDateType").getGenericType(), null, docDate));
            final String _transformedSalespersonCode = ((String) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_salespersonCodeType").getGenericType(), null, salespersonCode));
            final String _transformedCustomerCode = ((String) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_customerCodeType").getGenericType(), null, customerCode));
            final String _transformedCustomerUsageType = ((String) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_customerUsageTypeType").getGenericType(), null, customerUsageType));
            final String _transformedDiscount = ((String) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_discountType").getGenericType(), null, discount));
            final String _transformedPurchaseOrderNo = ((String) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_purchaseOrderNoType").getGenericType(), null, purchaseOrderNo));
            final String _transformedExemptionNo = ((String) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_exemptionNoType").getGenericType(), null, exemptionNo));
            final String _transformedOriginCode = ((String) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_originCodeType").getGenericType(), null, originCode));
            final String _transformedDestinationCode = ((String) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_destinationCodeType").getGenericType(), null, destinationCode));
            final List<Map<String, Object>> _transformedBaseAddresses = ((List<Map<String, Object>> ) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_baseAddressesType").getGenericType(), null, baseAddresses));
            final List<Map<String, Object>> _transformedLines = ((List<Map<String, Object>> ) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_linesType").getGenericType(), null, lines));
            final DetailLevelType _transformedDetailLevel = ((DetailLevelType) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_detailLevelType").getGenericType(), null, detailLevel));
            final String _transformedReferenceCode = ((String) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_referenceCodeType").getGenericType(), null, referenceCode));
            final String _transformedLocationCode = ((String) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_locationCodeType").getGenericType(), null, locationCode));
            final Boolean _transformedCommit = ((Boolean) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_commitType").getGenericType(), null, commit));
            final String _transformedBatchCode = ((String) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_batchCodeType").getGenericType(), null, batchCode));
            final Map<String, Object> _transformedTaxOverride = ((Map<String, Object> ) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_taxOverrideType").getGenericType(), null, taxOverride));
            final String _transformedCurrencyCode = ((String) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_currencyCodeType").getGenericType(), null, currencyCode));
            final ServiceModeType _transformedServiceMode = ((ServiceModeType) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_serviceModeType").getGenericType(), null, serviceMode));
            final XMLGregorianCalendar _transformedPaymentDate = ((XMLGregorianCalendar) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_paymentDateType").getGenericType(), null, paymentDate));
            final String _transformedExchangeRate = ((String) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_exchangeRateType").getGenericType(), null, exchangeRate));
            final XMLGregorianCalendar _transformedExchangeRateEffDate = ((XMLGregorianCalendar) evaluateAndTransform(getMuleContext(), event, AdjustTaxMessageProcessor.class.getDeclaredField("_exchangeRateEffDateType").getGenericType(), null, exchangeRateEffDate));
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
                    return ((AvalaraModule) object).adjustTax(_transformedAdjustmentReason, _transformedAdjustmentDescription, _transformedCompanyCode, _transformedDocType, _transformedDocCode, _transformedDocDate, _transformedSalespersonCode, _transformedCustomerCode, _transformedCustomerUsageType, _transformedDiscount, _transformedPurchaseOrderNo, _transformedExemptionNo, _transformedOriginCode, _transformedDestinationCode, _transformedBaseAddresses, _transformedLines, _transformedDetailLevel, _transformedReferenceCode, _transformedLocationCode, _transformedCommit, _transformedBatchCode, _transformedTaxOverride, _transformedCurrencyCode, _transformedServiceMode, _transformedPaymentDate, _transformedExchangeRate, _transformedExchangeRateEffDate);
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
        return new DefaultResult<MetaData>(new DefaultMetaData(getPojoOrSimpleModel(AdjustTaxResult.class)));
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
                    return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error processing metadata at AvalaraModule at adjustTax retrieving was successful but result is null");
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
