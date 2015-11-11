
package org.mule.modules.avalara.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/avalara</code>.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-11-11T05:00:21-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class AvalaraNamespaceHandler
    extends NamespaceHandlerSupport
{

    private static Logger logger = LoggerFactory.getLogger(AvalaraNamespaceHandler.class);

    private void handleException(String beanName, String beanScope, NoClassDefFoundError noClassDefFoundError) {
        String muleVersion = "";
        try {
            muleVersion = MuleManifest.getProductVersion();
        } catch (Exception _x) {
            logger.error("Problem while reading mule version");
        }
        logger.error(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [avalara] is not supported in mule ")+ muleVersion));
        throw new FatalBeanException(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [avalara] is not supported in mule ")+ muleVersion), noClassDefFoundError);
    }

    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        try {
            this.registerBeanDefinitionParser("config", new AvalaraModuleConfigDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("config", "@Config", ex);
        }
        try {
            this.registerBeanDefinitionParser("ping", new PingDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("ping", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("ping-with-credentials", new PingWithCredentialsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("ping-with-credentials", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-tax", new GetTaxDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-tax", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("adjust-tax", new AdjustTaxDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("adjust-tax", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("post-tax", new PostTaxDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("post-tax", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("commit-tax", new CommitTaxDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("commit-tax", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-tax-history", new GetTaxHistoryDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-tax-history", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("cancel-tax", new CancelTaxDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("cancel-tax", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("validate-address", new ValidateAddressDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("validate-address", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("fetch-batch-file", new FetchBatchFileDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("fetch-batch-file", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("is-batch-finished", new IsBatchFinishedDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("is-batch-finished", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("save-batch", new SaveBatchDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("save-batch", "@Processor", ex);
        }
    }

}
