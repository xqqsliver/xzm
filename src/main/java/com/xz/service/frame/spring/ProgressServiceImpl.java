package com.xz.service.frame.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.DocumentDefaultsDefinition;
import org.springframework.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProgressServiceImpl implements ProgressService {
    private final Map<String, ParseBeanModel> beanDefinitionMap = new ConcurrentHashMap<String, ParseBeanModel>(256);

    private final DocumentDefaultsDefinition defaults = new DocumentDefaultsDefinition();
    public Document getDocument(String path){
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder= null;
        Document doc=null;
        try {
            builder = factory.newDocumentBuilder();
            InputStream inputStream= null;
            inputStream = new FileInputStream("applicationContext.xml");
            doc=builder.parse(inputStream);
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return doc;
    }

    public void doRegisterBeanDefinitions(Element root) {

    }

    public void parseBeanDefinitions(Element root) {
        ParseBeanModel model=new ParseBeanModel();
        NodeList nl = root.getChildNodes();
        for(int i=0;i<nl.getLength();i++){
            Node node = nl.item(i);
            if(node instanceof Element){
                Element ele=(Element) node;
                String id = ele.getAttribute(BeanAttribute.ID_ATTRIBUTE);
                String nameAttr = ele.getAttribute(BeanAttribute.NAME_ATTRIBUTE);
                String beanName = id;

                List<String> aliases = new ArrayList<String>();
                if (StringUtils.hasLength(nameAttr)) {
                    String[] nameArr = StringUtils.tokenizeToStringArray(nameAttr, BeanAttribute.MULTI_VALUE_ATTRIBUTE_DELIMITERS);
                    aliases.addAll(Arrays.asList(nameArr));
                }
                if (!StringUtils.hasText(beanName) && !aliases.isEmpty()) {
                    beanName = aliases.remove(0);
                    //if (logger.isDebugEnabled()) {
                        //logger.debug("No XML 'id' specified - using '" + beanName +
                               // "' as bean name and " + aliases + " as aliases");
                    //}
                }
                if (ele.hasAttribute(BeanAttribute.PARENT_ATTRIBUTE)) {
                    model.setParent(ele.getAttribute(BeanAttribute.PARENT_ATTRIBUTE));
                }
                if (ele.hasAttribute(BeanAttribute.CLASS_ATTRIBUTE)) {
                    model.setClassName(ele.getAttribute(BeanAttribute.CLASS_ATTRIBUTE).trim());
                }
                if (ele.hasAttribute(BeanAttribute.ABSTRACT_ATTRIBUTE)) {
                    model.setAbstract(BeanAttribute.TRUE_VALUE.equals(ele.getAttribute(BeanAttribute.ABSTRACT_ATTRIBUTE)));
                }
                String lazyInit = ele.getAttribute(BeanAttribute.LAZY_INIT_ATTRIBUTE);
                if (BeanAttribute.DEFAULT_VALUE.equals(lazyInit)) {
                    lazyInit = this.defaults.getLazyInit();
                }
                model.setLazyInit(BeanAttribute.TRUE_VALUE.equals(lazyInit));

                String autowire = ele.getAttribute(BeanAttribute.AUTOWIRE_ATTRIBUTE);
                CommonUtil commonUtil=new CommonUtil();
                model.setAutowireMode(commonUtil.getAutowireMode(autowire));
                String dependencyCheck = ele.getAttribute(BeanAttribute.DEPENDENCY_CHECK_ATTRIBUTE);
                model.setDependencyCheck(commonUtil.getDependencyCheck(dependencyCheck));
                if (ele.hasAttribute(BeanAttribute.DEPENDS_ON_ATTRIBUTE)) {
                    String dependsOn = ele.getAttribute(BeanAttribute.DEPENDS_ON_ATTRIBUTE);
                    model.setDependsOn(StringUtils.tokenizeToStringArray(dependsOn, BeanAttribute.MULTI_VALUE_ATTRIBUTE_DELIMITERS));
                }
                if (ele.hasAttribute(BeanAttribute.FACTORY_METHOD_ATTRIBUTE)) {
                    model.setFactoryMethodName(ele.getAttribute(BeanAttribute.FACTORY_METHOD_ATTRIBUTE));
                }
                if (ele.hasAttribute(BeanAttribute.FACTORY_BEAN_ATTRIBUTE)) {
                    model.setFactoryBeanName(ele.getAttribute(BeanAttribute.FACTORY_BEAN_ATTRIBUTE));
                }
                String[] aliasesArray = StringUtils.toStringArray(aliases);
                //new ParseBeanModelHolder(model,beanName,aliasesArray);
                ParseBeanModel oldBeanDefinition;
                oldBeanDefinition = this.beanDefinitionMap.get(beanName);
                if(oldBeanDefinition!=null){
                    System.out.print("bean 重复");
                }else{
                    this.beanDefinitionMap.put(beanName,model);
                }
            }

        }

    }
}
