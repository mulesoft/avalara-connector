
package com.avalara.avatax.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.avalara.avatax.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AuditMessage_QNAME = new QName("http://avatax.avalara.com/services", "AuditMessage");
    private final static QName _Profile_QNAME = new QName("http://avatax.avalara.com/services", "Profile");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.avalara.avatax.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BatchProcess }
     * 
     */
    public BatchProcess createBatchProcess() {
        return new BatchProcess();
    }

    /**
     * Create an instance of {@link BatchProcessRequest }
     * 
     */
    public BatchProcessRequest createBatchProcessRequest() {
        return new BatchProcessRequest();
    }

    /**
     * Create an instance of {@link AuditMessage }
     * 
     */
    public AuditMessage createAuditMessage() {
        return new AuditMessage();
    }

    /**
     * Create an instance of {@link IsAuthorized }
     * 
     */
    public IsAuthorized createIsAuthorized() {
        return new IsAuthorized();
    }

    /**
     * Create an instance of {@link BatchDelete }
     * 
     */
    public BatchDelete createBatchDelete() {
        return new BatchDelete();
    }

    /**
     * Create an instance of {@link DeleteRequest }
     * 
     */
    public DeleteRequest createDeleteRequest() {
        return new DeleteRequest();
    }

    /**
     * Create an instance of {@link BatchFileDeleteResponse }
     * 
     */
    public BatchFileDeleteResponse createBatchFileDeleteResponse() {
        return new BatchFileDeleteResponse();
    }

    /**
     * Create an instance of {@link DeleteResult }
     * 
     */
    public DeleteResult createDeleteResult() {
        return new DeleteResult();
    }

    /**
     * Create an instance of {@link BatchProcessResponse }
     * 
     */
    public BatchProcessResponse createBatchProcessResponse() {
        return new BatchProcessResponse();
    }

    /**
     * Create an instance of {@link BatchProcessResult }
     * 
     */
    public BatchProcessResult createBatchProcessResult() {
        return new BatchProcessResult();
    }

    /**
     * Create an instance of {@link BatchFileSave }
     * 
     */
    public BatchFileSave createBatchFileSave() {
        return new BatchFileSave();
    }

    /**
     * Create an instance of {@link BatchFile }
     * 
     */
    public BatchFile createBatchFile() {
        return new BatchFile();
    }

    /**
     * Create an instance of {@link Profile }
     * 
     */
    public Profile createProfile() {
        return new Profile();
    }

    /**
     * Create an instance of {@link BatchSaveResponse }
     * 
     */
    public BatchSaveResponse createBatchSaveResponse() {
        return new BatchSaveResponse();
    }

    /**
     * Create an instance of {@link BatchSaveResult }
     * 
     */
    public BatchSaveResult createBatchSaveResult() {
        return new BatchSaveResult();
    }

    /**
     * Create an instance of {@link BatchFetch }
     * 
     */
    public BatchFetch createBatchFetch() {
        return new BatchFetch();
    }

    /**
     * Create an instance of {@link FetchRequest }
     * 
     */
    public FetchRequest createFetchRequest() {
        return new FetchRequest();
    }

    /**
     * Create an instance of {@link BatchFileFetch }
     * 
     */
    public BatchFileFetch createBatchFileFetch() {
        return new BatchFileFetch();
    }

    /**
     * Create an instance of {@link IsAuthorizedResponse }
     * 
     */
    public IsAuthorizedResponse createIsAuthorizedResponse() {
        return new IsAuthorizedResponse();
    }

    /**
     * Create an instance of {@link IsAuthorizedResult }
     * 
     */
    public IsAuthorizedResult createIsAuthorizedResult() {
        return new IsAuthorizedResult();
    }

    /**
     * Create an instance of {@link BatchFileDelete }
     * 
     */
    public BatchFileDelete createBatchFileDelete() {
        return new BatchFileDelete();
    }

    /**
     * Create an instance of {@link BatchFetchResponse }
     * 
     */
    public BatchFetchResponse createBatchFetchResponse() {
        return new BatchFetchResponse();
    }

    /**
     * Create an instance of {@link BatchFetchResult }
     * 
     */
    public BatchFetchResult createBatchFetchResult() {
        return new BatchFetchResult();
    }

    /**
     * Create an instance of {@link BatchFileFetchResponse }
     * 
     */
    public BatchFileFetchResponse createBatchFileFetchResponse() {
        return new BatchFileFetchResponse();
    }

    /**
     * Create an instance of {@link BatchFileFetchResult }
     * 
     */
    public BatchFileFetchResult createBatchFileFetchResult() {
        return new BatchFileFetchResult();
    }

    /**
     * Create an instance of {@link BatchFileSaveResponse }
     * 
     */
    public BatchFileSaveResponse createBatchFileSaveResponse() {
        return new BatchFileSaveResponse();
    }

    /**
     * Create an instance of {@link BatchFileSaveResult }
     * 
     */
    public BatchFileSaveResult createBatchFileSaveResult() {
        return new BatchFileSaveResult();
    }

    /**
     * Create an instance of {@link BatchDeleteResponse }
     * 
     */
    public BatchDeleteResponse createBatchDeleteResponse() {
        return new BatchDeleteResponse();
    }

    /**
     * Create an instance of {@link Ping }
     * 
     */
    public Ping createPing() {
        return new Ping();
    }

    /**
     * Create an instance of {@link BatchSave }
     * 
     */
    public BatchSave createBatchSave() {
        return new BatchSave();
    }

    /**
     * Create an instance of {@link Batch }
     * 
     */
    public Batch createBatch() {
        return new Batch();
    }

    /**
     * Create an instance of {@link PingResponse }
     * 
     */
    public PingResponse createPingResponse() {
        return new PingResponse();
    }

    /**
     * Create an instance of {@link PingResult }
     * 
     */
    public PingResult createPingResult() {
        return new PingResult();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link FilterResult }
     * 
     */
    public FilterResult createFilterResult() {
        return new FilterResult();
    }

    /**
     * Create an instance of {@link BaseResult }
     * 
     */
    public BaseResult createBaseResult() {
        return new BaseResult();
    }

    /**
     * Create an instance of {@link ArrayOfMessage }
     * 
     */
    public ArrayOfMessage createArrayOfMessage() {
        return new ArrayOfMessage();
    }

    /**
     * Create an instance of {@link ArrayOfBatchFile }
     * 
     */
    public ArrayOfBatchFile createArrayOfBatchFile() {
        return new ArrayOfBatchFile();
    }

    /**
     * Create an instance of {@link ArrayOfBatch }
     * 
     */
    public ArrayOfBatch createArrayOfBatch() {
        return new ArrayOfBatch();
    }

    /**
     * Create an instance of {@link FilterRequest }
     * 
     */
    public FilterRequest createFilterRequest() {
        return new FilterRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuditMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avatax.avalara.com/services", name = "AuditMessage")
    public JAXBElement<AuditMessage> createAuditMessage(AuditMessage value) {
        return new JAXBElement<AuditMessage>(_AuditMessage_QNAME, AuditMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Profile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://avatax.avalara.com/services", name = "Profile")
    public JAXBElement<Profile> createProfile(Profile value) {
        return new JAXBElement<Profile>(_Profile_QNAME, Profile.class, null, value);
    }

}
