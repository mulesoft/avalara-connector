
package org.mule.modules.avalara.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.avalara.processors.ValidateAddressMessageProcessor;
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
public class ValidateAddressDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(ValidateAddressDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(ValidateAddressMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [validate-address] within the connector [avalara] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [validate-address] within the connector [avalara] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("validateAddress");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "line1", "line1");
        parseProperty(builder, element, "line2", "line2");
        parseProperty(builder, element, "line3", "line3");
        parseProperty(builder, element, "city", "city");
        parseProperty(builder, element, "region", "region");
        parseProperty(builder, element, "country", "country");
        parseProperty(builder, element, "postalCode", "postalCode");
        parseProperty(builder, element, "addressCode", "addressCode");
        parseProperty(builder, element, "taxRegionId", "taxRegionId");
        parseProperty(builder, element, "latitude", "latitude");
        parseProperty(builder, element, "longitude", "longitude");
        parseProperty(builder, element, "textCase", "textCase");
        parseProperty(builder, element, "coordinates", "coordinates");
        parseProperty(builder, element, "taxability", "taxability");
        if (hasAttribute(element, "date-ref")) {
            if (element.getAttribute("date-ref").startsWith("#")) {
                builder.addPropertyValue("date", element.getAttribute("date-ref"));
            } else {
                builder.addPropertyValue("date", (("#[registry:"+ element.getAttribute("date-ref"))+"]"));
            }
        }
        parseProperty(builder, element, "account", "account");
        parseProperty(builder, element, "avalaraClient", "avalaraClient");
        parseProperty(builder, element, "license", "license");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
