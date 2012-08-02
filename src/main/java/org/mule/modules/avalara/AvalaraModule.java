/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

/**
 * This file was automatically generated by the Mule Development Kit
 */
package org.mule.modules.avalara;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Module;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.display.Placement;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.avalara.api.AvalaraClient;
import org.mule.modules.avalara.api.DefaultAvalaraClient;
import org.mule.modules.avalara.api.MapBuilder;
import org.mule.modules.avalara.exception.AvalaraRuntimeException;
import org.mule.modules.utils.mom.JaxbMapObjectMappers;

import com.avalara.avatax.services.BaseAddress;
import com.avalara.avatax.services.CancelTaxRequest;
import com.avalara.avatax.services.CancelTaxResult;
import com.avalara.avatax.services.CommitTaxRequest;
import com.avalara.avatax.services.CommitTaxResult;
import com.avalara.avatax.services.GetTaxHistoryRequest;
import com.avalara.avatax.services.GetTaxHistoryResult;
import com.avalara.avatax.services.GetTaxRequest;
import com.avalara.avatax.services.GetTaxResult;
import com.avalara.avatax.services.PingResult;
import com.avalara.avatax.services.PostTaxRequest;
import com.avalara.avatax.services.PostTaxResult;
import com.avalara.avatax.services.ValidateRequest;
import com.avalara.avatax.services.ValidateResult;
import com.zauberlabs.commons.mom.MapObjectMapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Avalara provides automated sales tax solutions to streamline cumbersome, 
 * error-prone tax compliance processes and reduce the risk of loss or penalty 
 * in case of an audit. Their automated solutions automatically perform address 
 * validation, jurisdiction research and rate calculation and allow you to 
 * manage even the most complicated tax issues, such as situs, nexus, tax tiers, 
 * tax holidays, exemptions, certificate management and product taxability rules.
 *
 * @author Gaston Ponti
 */
@Module(name = "avalara", schemaVersion = "2.0")
public class AvalaraModule
{
    /**
     * Tax Webservice endpoint
     */
    @Configurable
    @Optional
    @Default("https://development.avalara.net/Tax/TaxSvc.asmx")
    @Placement(group = "Connection")
    private String taxServiceEndpoint;
    
    /**
     * Address Webservice endpoint
     */
    @Configurable
    @Optional
    @Default("https://development.avalara.net/Address/AddressSvc.asmx")
    @Placement(group = "Connection")
    private String addressServiceEndpoint;
    
    /**
     * Avalara's application client. By default uses DefaultAvalaraClient class.
     */
    private AvalaraClient apiClient;
    
    private final MapObjectMapper mom = JaxbMapObjectMappers.defaultWithPackage("com.avalara.avatax.services").build();
    
    public PingResult ping(String account, String license, String avalaraClient, String message)
    {
        return apiClient.ping(account, license, avalaraClient, message);
    }
    
    /**
     * Get Tax processor.
     * <p>
     * The Get Tax operation calculates tax for one or more invoiced items and 
     * displays details describing the calculation of tax for each line item.
     *
     * {@sample.xml ../../../doc/avalara-connector.xml.sample avalara:get-tax}
     * 
     * @param account Avalara's account
     * @param license Avalara's license
     * @param avalaraClient Avalara's client
     * @param companyCode Client application company reference code
     * @param docType The document type specifies the category of the document and affects
     *                how the document is treated after a tax calculation; see 
     *                {@link AvalaraDocumentType} for more information about the specific 
     *                document types.
     * @param docCode The internal reference code used by the client application.
     * @param docDate Date of invoice, purchase order, etc.
     * @param salespersonCode The client application salesperson reference code.
     * @param customerCode Client application customer reference code 
     * @param customerUsageType Client application customer or usage type.
     *                          CustomerUsageType determines the exempt status of 
     *                          the transaction based on the exemption tax rules for 
     *                          the jurisdictions involved. CustomerUsageType may 
     *                          also be set at the line item level. <p>
     *                          The standard values for the CustomerUsageType (A-L).<br/>
        A Federal Government<br/>
        B State/Local Govt.<br/>
        C Tribal Government<br/>
        D Foreign Diplomat<br/>
        E Charitable Organization<br/>
        F Religious/Education<br/>
        G Resale<br/>
        H Agricultural Production<br/>
        I Industrial Prod/Mfg.<br/>
        J Direct Pay Permit<br/>
        K Direct Mail<br/>
        L - Other
     * @param discount The discount amount to apply to the document. The string
     *                 represents a {@link BigDecimal}.
     * @param purchaseOrderNo Purchase order identifier. PurchaseOrderNo is required 
     *                        for single use exemption certificates to match the 
     *                        order and invoice with the certificate.
     * @param exemptionNo Exemption number used for this transaction
     * @param originCode Code that refers one of the address of the baseAddress collection.
     *                   It has to be the same code of one of the address's addressCode.
     *                   It represents the origin address. 
     * @param destinationCode Code that refers one of the address of the baseAddress collection.
     *                        It has to be the same code of one of the address's addressCode.
     *                        It represents the destination address. 
     * @param baseAddresses Collection of physical addresses that will be referred 
     *                      to as the destination or origination of 1 or more invoice 
     *                      line entries
     * @param lines Collection of invoice lines requiring tax calculation
     * @param detailLevel Specifies the level of tax detail to return
     * @param referenceCode For returns (see {@link AvalaraDocumentType}), refers to the 
     *                      {@link GetTaxRequest#getDocCode} of the original invoice.
     * @param locationCode Location Code value. It is Also referred to as a Store 
     *                     Location, Outlet Id, or Outlet code is a number assigned by 
     *                     the State which identifies a Store location. Some state returns 
     *                     require taxes are broken out separately for Store Locations.
     * @param commit Commit flag. If Commit is set to true, tax for the transaction 
     *               is saved, posted and committed as tax document.
     * @param batchCode The batchCode value.
     * @param taxOverride Indicates to apply tax override to the document.
     * @param currencyCode It is 3 character ISO 4217 currency code.
     * @param serviceMode This is only supported by AvaLocal servers. It provides the 
     *                    ability to controls whether tax is calculated locally or remotely 
     *                    when using an AvaLocal server. The default is Automatic which 
     *                    calculates locally unless remote is necessary for non-local 
     *                    addresses.
     * @param paymentDate The date on which payment was made.
     * @param exchangeRate The exchange rate value. The string represents a 
     *                     {@link BigDecimal}
     * @param exchangeRateEffDate The exchange rate effective date value.
     * @return The {@link GetTaxResult}
     * 
     * @throws AvalaraRuntimeException
     */
    @Processor
    public GetTaxResult getTax(String account, String license, String avalaraClient,
                               String companyCode,
                               AvalaraDocumentType docType,
                               @Optional String docCode,
                               XMLGregorianCalendar docDate,
                               @Optional String salespersonCode,
                               String customerCode,
                               @Optional String customerUsageType,
                               String discount,
                               @Optional String purchaseOrderNo,
                               @Optional String exemptionNo,
                               String originCode,
                               String destinationCode,
                               List<Map<String, Object>> baseAddresses,
                               List<Map<String, Object>> lines,
                               DetailLevelType detailLevel,
                               @Optional String referenceCode,
                               @Optional String locationCode,
                               @Optional @Default("false") boolean commit,
                               @Optional String batchCode,
                               @Optional Map<String, Object> taxOverride,
                               @Optional String currencyCode,
                               @Optional @Default("AUTOMATIC") ServiceModeType serviceMode,
                               XMLGregorianCalendar paymentDate,
                               String exchangeRate,
                               XMLGregorianCalendar exchangeRateEffDate)
    {
        BigDecimal discountDecimal = discount == null ? null :  new BigDecimal(discount);
        BigDecimal exchangeRateDecimal = exchangeRate == null ? null :  new BigDecimal(exchangeRate);
        
        Map<String, Object> addresses = null;
        if (baseAddresses != null && !baseAddresses.isEmpty())
        {
            addresses = new HashMap<String, Object>();
            addresses.put("baseAddress", baseAddresses);
        }
        
        Map<String, Object> mapLines = null;
        if (lines != null && !lines.isEmpty())
        {
            mapLines = new HashMap<String, Object>();
            mapLines.put("line", lines);
        }
        
        return apiClient.sendToAvalara(account, license, avalaraClient, TaxRequestType.GetTax, mom.unmap(            
                new MapBuilder()
                .with("companyCode", companyCode)
                .with("docType", docType.toDocumentType())
                .with("docCode", docCode)
                .with("docDate", docDate)
                .with("salespersonCode", salespersonCode)
                .with("customerCode", customerCode)
                .with("customerUsageType", customerUsageType)
                .with("discount", discountDecimal)
                .with("purchaseOrderNo", purchaseOrderNo)
                .with("exemptionNo", exemptionNo)
                .with("originCode", originCode)
                .with("destinationCode", destinationCode)
                .with("addresses", addresses)
                .with("lines", mapLines)
                .with("detailLevel", detailLevel.toAvalaraDetailLevel())
                .with("referenceCode", referenceCode)
                .with("locationCode", locationCode)
                .with("commit", commit) 
                .with("batchCode", batchCode)
                .with("taxOverride", taxOverride)
                .with("currencyCode", currencyCode)
                .with("serviceMode", serviceMode.toAvalaraServiceMode())
                .with("paymentDate", paymentDate)
                .with("exchangeRate", exchangeRateDecimal)
                .with("exchangeRateEffDate", exchangeRateEffDate)
                .build(), GetTaxRequest.class
            )
        );
    }

    /**
     * Post Tax processor
     *
     * {@sample.xml ../../../doc/avalara-connector.xml.sample avalara:post-tax}
     *
     * @param account Avalara's account
     * @param license Avalara's license
     * @param avalaraClient Avalara's client
     * @param docId The original document's type, such as Sales Invoice or Purchase Invoice.
     * @param companyCode Client application company reference code. If docId is specified, 
     *                    this is not needed.
     * @param docType The document type specifies the category of the document and affects
     *                how the document is treated after a tax calculation; see 
     *                {@link AvalaraDocumentType} for more information about the specific 
     *                document types.
     * @param docCode The internal reference code used by the client application.
     * @param docDate The date on the invoice, purchase order, etc
     * @param totalAmount The total amount (not including tax) for the document.
     *                    This is used for verification and reconciliation. This should 
     *                    be the <b>TotalAmount</b> returned by {@link GetTaxResult} when 
     *                    tax was calculated for this document; otherwise the web service 
     *                    will return an error. The string represents a {@link BigDecimal}
     * @param totalTax The total tax for the document. This is used for verification 
     *                 and reconciliation. This should be the <b>TotalTax</b> returned by
     *                 {@link GetTaxResult} when tax was calculated for this document; 
     *                 otherwise the web service will return an error.
     *                 The string represents a {@link BigDecimal}
     * @param commit The commit value. This has been defaulted to false. If this has 
     *               been set to true AvaTax will commit the document on this call. Seller's 
     *               system who wants to Post and Commit the document on one call should use 
     *               this flag.
     * @param newDocCode The new document code value.
     * @return The {@link PostTaxResult}
     * 
     * @throws AvalaraRuntimeException
     */
    @Processor
    public PostTaxResult postTax(String account, String license, String avalaraClient,
                                 @Optional String docId,
                                 String companyCode,
                                 AvalaraDocumentType docType,
                                 @Optional String docCode,
                                 XMLGregorianCalendar docDate,
                                 String totalAmount,
                                 String totalTax,
                                 @Optional @Default("false") boolean commit,
                                 @Optional String newDocCode)
    {
        BigDecimal totalAmountDecimal = totalAmount == null ? null :  new BigDecimal(totalAmount);
        BigDecimal totalTaxDecimal = totalTax == null ? null :  new BigDecimal(totalTax);
        
        return (PostTaxResult) apiClient.sendToAvalara(
            account, license, avalaraClient, 
            TaxRequestType.PostTax,
            mom.unmap(           
                new MapBuilder()
                .with("docId", docId)
                .with("companyCode", companyCode)
                .with("docType", docType.toDocumentType())
                .with("docCode", docCode)
                .with("docDate", docDate)
                .with("totalAmount", totalAmountDecimal)
                .with("totalTax", totalTaxDecimal)
                .with("commit", commit)
                .with("newDocCode", newDocCode)
                .build(), PostTaxRequest.class
            )
        );
    }
    
    /**
     * Commit Tax processor
     *
     * {@sample.xml ../../../doc/avalara-connector.xml.sample avalara:commit-tax}
     *
     * @param account Avalara's account
     * @param license Avalara's license
     * @param avalaraClient Avalara's client
     * @param docId The original document's type, such as Sales Invoice or Purchase Invoice.
     * @param companyCode Client application company reference code. If docId is specified, 
     *                    this is not needed.
     * @param docType The document type specifies the category of the document and affects
     *                how the document is treated after a tax calculation; see 
     *                {@link AvalaraDocumentType} for more information about the specific 
     *                document types.
     * @param docCode The internal reference code used by the client application.
     * @param newDocCode The new document code value.
     * @return The {@link CommitTaxRequest}
     * 
     * @throws AvalaraRuntimeException
     */
    @Processor
    public CommitTaxResult commitTax(String account, String license, String avalaraClient,
                                     @Optional String docId,
                                     String companyCode,
                                     AvalaraDocumentType docType,
                                     @Optional String docCode,
                                     @Optional String newDocCode)
    {
        return (CommitTaxResult) apiClient.sendToAvalara(
            account, license, avalaraClient, 
            TaxRequestType.CommitTax,
            mom.unmap(            
                new MapBuilder()
                .with("docId", docId)
                .with("companyCode", companyCode)
                .with("docType", docType.toDocumentType())
                .with("docCode", docCode)
                .with("newDocCode", newDocCode)
                .build(), CommitTaxRequest.class
            )
        );
    }
    
    /**
     * Get Tax History processor
     *
     * {@sample.xml ../../../doc/avalara-connector.xml.sample avalara:get-tax-history}
     *
     * @param account Avalara's account
     * @param license Avalara's license
     * @param avalaraClient Avalara's client
     * @param docId The original document's type, such as Sales Invoice or Purchase Invoice.
     * @param companyCode Client application company reference code. If docId is specified, 
     *                    this is not needed.
     * @param docType The document type specifies the category of the document and affects
     *                how the document is treated after a tax calculation; see 
     *                {@link AvalaraDocumentType} for more information about the specific 
     *                document types.
     * @param docCode The internal reference code used by the client application.
     * @param detailLevel Specifies the level of detail to return. See {@link DetailLevelType}.
     * @return The {@link GetTaxHistoryResult}
     * 
     * @throws AvalaraRuntimeException
     */
    @Processor
    public GetTaxHistoryResult getTaxHistory(String account, String license, String avalaraClient,
                                             @Optional String docId,
                                             String companyCode,
                                             AvalaraDocumentType docType,
                                             @Optional String docCode,
                                             DetailLevelType detailLevel)
    {
        return (GetTaxHistoryResult) apiClient.sendToAvalara(
            account, license, avalaraClient, 
            TaxRequestType.GetTaxHistory,
            mom.unmap(       
                new MapBuilder()
                .with("docId", docId)
                .with("companyCode", companyCode)
                .with("docType", docType.toDocumentType())
                .with("docCode", docCode)
                .with("detailLevel", detailLevel.toAvalaraDetailLevel())
                .build(), GetTaxHistoryRequest.class
            )
        );
    }
    
    /**
     * Cancel tax, indicating the document that should be cancelled and the reason
     * for the operation.
     *
     * {@sample.xml ../../../doc/avalara-connector.xml.sample avalara:cancel-tax}
     * 
     * @param account Avalara's account
     * @param license Avalara's license
     * @param avalaraClient Avalara's client
     * @param docId The original document's type, such as Sales Invoice or Purchase Invoice.
     * @param companyCode Client application company reference code. If docId is specified, 
     *                    this is not needed.
     * @param docType The document type specifies the category of the document and affects
     *                how the document is treated after a tax calculation; see 
     *                {@link AvalaraDocumentType} for more information about the specific 
     *                document types.
     * @param docCode The internal reference code used by the client application.
     * @param cancelCode A code indicating the reason the document is getting canceled.
     * @return The {@link CancelTaxResult}
     * 
     * @throws AvalaraRuntimeException
     */
    @Processor
    public CancelTaxResult cancelTax(String account, String license, String avalaraClient,
                                     @Optional String docId,
                                     String companyCode,
                                     AvalaraDocumentType docType,
                                     @Optional String docCode,
                                     CancelCodeType cancelCode)
    {
        return (CancelTaxResult) apiClient.sendToAvalara(
            account, license, avalaraClient, 
            TaxRequestType.CancelTax,
            mom.unmap(           
                new MapBuilder()
                .with("docId", docId)
                .with("companyCode", companyCode)
                .with("docType", docType.toDocumentType())
                .with("docCode", docCode)
                .with("cancelCode", cancelCode.toAvalaraCancelCode())
                .build(), CancelTaxRequest.class
            )
        );
    }
    
    /**
     * Validate Address processor.
     * <p>
     * This operation validates the supplied address, returning canonical form and 
     * additional delivery details if successfully validated.
     *
     * {@sample.xml ../../../doc/avalara-connector.xml.sample avalara:validate-address}
     * 
     * @param account Avalara's account
     * @param license Avalara's license
     * @param avalaraClient Avalara's client
     * @param line1 Address line 1
     * @param line2 Address line 2
     * @param line3 Address line 3
     * @param city City name. Required, when PostalCode is not specified.
     * @param region State or region name. Requirad, when PostalCode is not specified.
     * @param country Country code
     * @param postalCode Postal or ZIP code. Required, when City and Region are not 
     *                   specified
     * @param addressCode the address code.
     * @param taxRegionId The tax region id.
     * @param latitude Latitude. 
     * @param longitude Longitude.
     * @param textCase The casing to apply to the validated address(es).
     * @param coordinates True, if you want in the result a not empty latitud and longitude.
     * @param taxability True, if you want the valid taxRegionId in the result.
     * @param date Date.
     * @return The {@link ValidateResult}
     * 
     * @throws AvalaraRuntimeException
     */
    @Processor
    public ValidateResult validateAddress(String account, String license, String avalaraClient,
                                          String line1,
                                          @Optional String line2,
                                          @Optional String line3, 
                                          @Optional String city,
                                          @Optional String region,
                                          @Optional String country,
                                          @Optional String postalCode,
                                          @Optional String addressCode,
                                          Integer taxRegionId,
                                          @Optional String latitude,
                                          @Optional String longitude,
                                          @Optional @Default("DEFAULT") TextCaseType textCase,
                                          @Optional @Default("false") boolean coordinates,
                                          @Optional @Default("false") boolean taxability,
                                          XMLGregorianCalendar date)
    {
        BaseAddress address = new BaseAddress();
        address.setAddressCode(addressCode);
        address.setCity(city);
        address.setCountry(country);
        address.setLatitude(latitude);
        address.setLine1(line1);
        address.setLine2(line2);
        address.setLine3(line3);
        address.setLongitude(longitude);
        address.setPostalCode(postalCode);
        address.setRegion(region);
        address.setTaxRegionId(taxRegionId);
        
        return apiClient.validateAddress(
            account, license, avalaraClient, 
            (ValidateRequest) mom.unmap(            
                new MapBuilder()
                .with("address", address)
                .with("textCase", textCase.toAvalaraTextCase())
                .with("coordinates", coordinates)
                .with("taxability", taxability)
                .with("date", date)
                .build(), ValidateRequest.class
            )
        );
    }
    /**
     * 
     */
    @PostConstruct
    public void init()
    {
        if (apiClient == null )
        {
            apiClient = new DefaultAvalaraClient(getAddressServiceEndpoint(), getTaxServiceEndpoint());
        }
    }
    
    /**
     * Sets the apiClient. 
     *
     * @param apiClient  with the apiClient.
     */
    
    public void setClient(AvalaraClient client)
    {
        this.apiClient = client;
    }

    public String getTaxServiceEndpoint() {
        return taxServiceEndpoint;
    }

    public void setTaxServiceEndpoint(String taxServiceEndpoint) {
        this.taxServiceEndpoint = taxServiceEndpoint;
    }

    public String getAddressServiceEndpoint() {
        return addressServiceEndpoint;
    }

    public void setAddressServiceEndpoint(String addressServiceEndpoint) {
        this.addressServiceEndpoint = addressServiceEndpoint;
    }
    
}
