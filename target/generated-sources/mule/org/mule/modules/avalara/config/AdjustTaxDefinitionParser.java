
package org.mule.modules.avalara.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.avalara.processors.AdjustTaxMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser.ParseDelegate;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser.ParseDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.5.3", date = "2015-11-11T05:00:21-03:00", comments = "Build UNNAMED.2049.ec39f2b")
public class AdjustTaxDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(AdjustTaxDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(AdjustTaxMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [adjust-tax] within the connector [avalara] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [adjust-tax] within the connector [avalara] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("adjustTax");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "adjustmentReason", "adjustmentReason");
        parseProperty(builder, element, "adjustmentDescription", "adjustmentDescription");
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
        parseProperty(builder, element, "salespersonCode", "salespersonCode");
        parseProperty(builder, element, "customerCode", "customerCode");
        parseProperty(builder, element, "customerUsageType", "customerUsageType");
        parseProperty(builder, element, "discount", "discount");
        parseProperty(builder, element, "purchaseOrderNo", "purchaseOrderNo");
        parseProperty(builder, element, "exemptionNo", "exemptionNo");
        parseProperty(builder, element, "originCode", "originCode");
        parseProperty(builder, element, "destinationCode", "destinationCode");
        parseListAndSetProperty(element, builder, "baseAddresses", "base-addresses", "base-address", new ParseDelegate<Object>() {


            public Object parse(Element element) {
                if (element.hasAttribute("ref")) {
                    if (!isMuleExpression(element.getAttribute("ref"))) {
                        return new RuntimeBeanReference(element.getAttribute("ref"));
                    } else {
                        return element.getAttribute("ref");
                    }
                }
                return parseMap(element, "inner-base-address", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
            }

        }
        );
        parseListAndSetProperty(element, builder, "lines", "lines", "line", new ParseDelegate<Object>() {


            public Object parse(Element element) {
                if (element.hasAttribute("ref")) {
                    if (!isMuleExpression(element.getAttribute("ref"))) {
                        return new RuntimeBeanReference(element.getAttribute("ref"));
                    } else {
                        return element.getAttribute("ref");
                    }
                }
                return parseMap(element, "inner-line", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
            }

        }
        );
        parseProperty(builder, element, "detailLevel", "detailLevel");
        parseProperty(builder, element, "referenceCode", "referenceCode");
        parseProperty(builder, element, "locationCode", "locationCode");
        parseProperty(builder, element, "commit", "commit");
        parseProperty(builder, element, "batchCode", "batchCode");
        parseMapAndSetProperty(element, builder, "taxOverride", "tax-override", "tax-override", new ParseDelegate<String>() {


            public String parse(Element element) {
                return element.getTextContent();
            }

        }
        );
        parseProperty(builder, element, "currencyCode", "currencyCode");
        parseProperty(builder, element, "serviceMode", "serviceMode");
        if (hasAttribute(element, "paymentDate-ref")) {
            if (element.getAttribute("paymentDate-ref").startsWith("#")) {
                builder.addPropertyValue("paymentDate", element.getAttribute("paymentDate-ref"));
            } else {
                builder.addPropertyValue("paymentDate", (("#[registry:"+ element.getAttribute("paymentDate-ref"))+"]"));
            }
        }
        parseProperty(builder, element, "exchangeRate", "exchangeRate");
        if (hasAttribute(element, "exchangeRateEffDate-ref")) {
            if (element.getAttribute("exchangeRateEffDate-ref").startsWith("#")) {
                builder.addPropertyValue("exchangeRateEffDate", element.getAttribute("exchangeRateEffDate-ref"));
            } else {
                builder.addPropertyValue("exchangeRateEffDate", (("#[registry:"+ element.getAttribute("exchangeRateEffDate-ref"))+"]"));
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
