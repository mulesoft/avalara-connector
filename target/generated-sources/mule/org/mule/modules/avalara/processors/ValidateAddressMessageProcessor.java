
package org.mule.modules.avalara.processors;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.datatype.XMLGregorianCalendar;
import com.avalara.avatax.services.ValidateResult;
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
import org.mule.modules.avalara.TextCaseType;
import org.mule.modules.avalara.connectivity.AvalaraModuleConnectionManager;
import org.mule.modules.avalara.exception.AvalaraAuthenticationException;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * ValidateAddressMessageProcessor invokes the {@link org.mule.modules.avalara.AvalaraModule#validateAddress(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, org.mule.modules.avalara.TextCaseType, boolean, boolean, javax.xml.datatype.XMLGregorianCalendar)} method in {@link AvalaraModule }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-11-11T05:00:21-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class ValidateAddressMessageProcessor
    extends AbstractConnectedProcessor
    implements MessageProcessor, OperationMetaDataEnabled
{

    protected Object line1;
    protected String _line1Type;
    protected Object line2;
    protected String _line2Type;
    protected Object line3;
    protected String _line3Type;
    protected Object city;
    protected String _cityType;
    protected Object region;
    protected String _regionType;
    protected Object country;
    protected String _countryType;
    protected Object postalCode;
    protected String _postalCodeType;
    protected Object addressCode;
    protected String _addressCodeType;
    protected Object taxRegionId;
    protected Integer _taxRegionIdType;
    protected Object latitude;
    protected String _latitudeType;
    protected Object longitude;
    protected String _longitudeType;
    protected Object textCase;
    protected TextCaseType _textCaseType;
    protected Object coordinates;
    protected boolean _coordinatesType;
    protected Object taxability;
    protected boolean _taxabilityType;
    protected Object date;
    protected XMLGregorianCalendar _dateType;

    public ValidateAddressMessageProcessor(String operationName) {
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
     * Sets region
     * 
     * @param value Value to set
     */
    public void setRegion(Object value) {
        this.region = value;
    }

    /**
     * Sets textCase
     * 
     * @param value Value to set
     */
    public void setTextCase(Object value) {
        this.textCase = value;
    }

    /**
     * Sets date
     * 
     * @param value Value to set
     */
    public void setDate(Object value) {
        this.date = value;
    }

    /**
     * Sets city
     * 
     * @param value Value to set
     */
    public void setCity(Object value) {
        this.city = value;
    }

    /**
     * Sets country
     * 
     * @param value Value to set
     */
    public void setCountry(Object value) {
        this.country = value;
    }

    /**
     * Sets taxability
     * 
     * @param value Value to set
     */
    public void setTaxability(Object value) {
        this.taxability = value;
    }

    /**
     * Sets postalCode
     * 
     * @param value Value to set
     */
    public void setPostalCode(Object value) {
        this.postalCode = value;
    }

    /**
     * Sets addressCode
     * 
     * @param value Value to set
     */
    public void setAddressCode(Object value) {
        this.addressCode = value;
    }

    /**
     * Sets longitude
     * 
     * @param value Value to set
     */
    public void setLongitude(Object value) {
        this.longitude = value;
    }

    /**
     * Sets latitude
     * 
     * @param value Value to set
     */
    public void setLatitude(Object value) {
        this.latitude = value;
    }

    /**
     * Sets line1
     * 
     * @param value Value to set
     */
    public void setLine1(Object value) {
        this.line1 = value;
    }

    /**
     * Sets taxRegionId
     * 
     * @param value Value to set
     */
    public void setTaxRegionId(Object value) {
        this.taxRegionId = value;
    }

    /**
     * Sets coordinates
     * 
     * @param value Value to set
     */
    public void setCoordinates(Object value) {
        this.coordinates = value;
    }

    /**
     * Sets line3
     * 
     * @param value Value to set
     */
    public void setLine3(Object value) {
        this.line3 = value;
    }

    /**
     * Sets line2
     * 
     * @param value Value to set
     */
    public void setLine2(Object value) {
        this.line2 = value;
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
            final String _transformedLine1 = ((String) evaluateAndTransform(getMuleContext(), event, ValidateAddressMessageProcessor.class.getDeclaredField("_line1Type").getGenericType(), null, line1));
            final String _transformedLine2 = ((String) evaluateAndTransform(getMuleContext(), event, ValidateAddressMessageProcessor.class.getDeclaredField("_line2Type").getGenericType(), null, line2));
            final String _transformedLine3 = ((String) evaluateAndTransform(getMuleContext(), event, ValidateAddressMessageProcessor.class.getDeclaredField("_line3Type").getGenericType(), null, line3));
            final String _transformedCity = ((String) evaluateAndTransform(getMuleContext(), event, ValidateAddressMessageProcessor.class.getDeclaredField("_cityType").getGenericType(), null, city));
            final String _transformedRegion = ((String) evaluateAndTransform(getMuleContext(), event, ValidateAddressMessageProcessor.class.getDeclaredField("_regionType").getGenericType(), null, region));
            final String _transformedCountry = ((String) evaluateAndTransform(getMuleContext(), event, ValidateAddressMessageProcessor.class.getDeclaredField("_countryType").getGenericType(), null, country));
            final String _transformedPostalCode = ((String) evaluateAndTransform(getMuleContext(), event, ValidateAddressMessageProcessor.class.getDeclaredField("_postalCodeType").getGenericType(), null, postalCode));
            final String _transformedAddressCode = ((String) evaluateAndTransform(getMuleContext(), event, ValidateAddressMessageProcessor.class.getDeclaredField("_addressCodeType").getGenericType(), null, addressCode));
            final Integer _transformedTaxRegionId = ((Integer) evaluateAndTransform(getMuleContext(), event, ValidateAddressMessageProcessor.class.getDeclaredField("_taxRegionIdType").getGenericType(), null, taxRegionId));
            final String _transformedLatitude = ((String) evaluateAndTransform(getMuleContext(), event, ValidateAddressMessageProcessor.class.getDeclaredField("_latitudeType").getGenericType(), null, latitude));
            final String _transformedLongitude = ((String) evaluateAndTransform(getMuleContext(), event, ValidateAddressMessageProcessor.class.getDeclaredField("_longitudeType").getGenericType(), null, longitude));
            final TextCaseType _transformedTextCase = ((TextCaseType) evaluateAndTransform(getMuleContext(), event, ValidateAddressMessageProcessor.class.getDeclaredField("_textCaseType").getGenericType(), null, textCase));
            final Boolean _transformedCoordinates = ((Boolean) evaluateAndTransform(getMuleContext(), event, ValidateAddressMessageProcessor.class.getDeclaredField("_coordinatesType").getGenericType(), null, coordinates));
            final Boolean _transformedTaxability = ((Boolean) evaluateAndTransform(getMuleContext(), event, ValidateAddressMessageProcessor.class.getDeclaredField("_taxabilityType").getGenericType(), null, taxability));
            final XMLGregorianCalendar _transformedDate = ((XMLGregorianCalendar) evaluateAndTransform(getMuleContext(), event, ValidateAddressMessageProcessor.class.getDeclaredField("_dateType").getGenericType(), null, date));
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
                    return ((AvalaraModule) object).validateAddress(_transformedLine1, _transformedLine2, _transformedLine3, _transformedCity, _transformedRegion, _transformedCountry, _transformedPostalCode, _transformedAddressCode, _transformedTaxRegionId, _transformedLatitude, _transformedLongitude, _transformedTextCase, _transformedCoordinates, _transformedTaxability, _transformedDate);
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
        return new DefaultResult<MetaData>(new DefaultMetaData(getPojoOrSimpleModel(ValidateResult.class)));
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
                    return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error processing metadata at AvalaraModule at validateAddress retrieving was successful but result is null");
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
