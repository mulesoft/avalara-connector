
package org.mule.modules.avalara.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.avalara.processors.PostTaxMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-11-11T05:00:21-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class PostTaxDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(PostTaxDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(PostTaxMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [post-tax] within the connector [avalara] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [post-tax] within the connector [avalara] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("postTax");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "docId", "docId");
        parseProperty(builder, element, "companyCode", "companyCode");
        parseProperty(builder, element, "docType", "docType");
        parseProperty(builder, element, "docCode", "docCode");
        if (hasAttribute(element, "docDate-ref")) {
            if (element.getAttribute("docDate-ref").startsWith("#")) {
                builder.addPropertyValue("docDate", element.getAttribute("docDate-ref"));
            } else {
                builder.addPropertyValue("docDate", (("#[registry:"+ element.getAttribute("docDate-ref"))+"]"));
            }
        }
        parseProperty(builder, element, "totalAmount", "totalAmount");
        parseProperty(builder, element, "totalTax", "totalTax");
        parseProperty(builder, element, "commit", "commit");
        parseProperty(builder, element, "newDocCode", "newDocCode");
        parseProperty(builder, element, "account", "account");
        parseProperty(builder, element, "avalaraClient", "avalaraClient");
        parseProperty(builder, element, "license", "license");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
