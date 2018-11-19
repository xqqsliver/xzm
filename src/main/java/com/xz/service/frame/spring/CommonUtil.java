package com.xz.service.frame.spring;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.xml.DocumentDefaultsDefinition;

public class CommonUtil {
    private final DocumentDefaultsDefinition defaults = new DocumentDefaultsDefinition();
    public  int getAutowireMode(String attValue) {
        String att = attValue;
        if (BeanAttribute.DEFAULT_VALUE.equals(att)) {
            att = this.defaults.getAutowire();
        }
        int autowire = AbstractBeanDefinition.AUTOWIRE_NO;
        if (BeanAttribute.AUTOWIRE_BY_NAME_VALUE.equals(att)) {
            autowire = AbstractBeanDefinition.AUTOWIRE_BY_NAME;
        }
        else if (BeanAttribute.AUTOWIRE_BY_TYPE_VALUE.equals(att)) {
            autowire = AbstractBeanDefinition.AUTOWIRE_BY_TYPE;
        }
        else if (BeanAttribute.AUTOWIRE_CONSTRUCTOR_VALUE.equals(att)) {
            autowire = AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR;
        }
        else if (BeanAttribute.AUTOWIRE_AUTODETECT_VALUE.equals(att)) {
            autowire = AbstractBeanDefinition.AUTOWIRE_AUTODETECT;
        }
        // Else leave default value.
        return autowire;
    }

    public int getDependencyCheck(String attValue) {
        String att = attValue;
        if (BeanAttribute.DEFAULT_VALUE.equals(att)) {
            att = this.defaults.getDependencyCheck();
        }
        if (BeanAttribute.DEPENDENCY_CHECK_ALL_ATTRIBUTE_VALUE.equals(att)) {
            return AbstractBeanDefinition.DEPENDENCY_CHECK_ALL;
        }
        else if (BeanAttribute.DEPENDENCY_CHECK_OBJECTS_ATTRIBUTE_VALUE.equals(att)) {
            return AbstractBeanDefinition.DEPENDENCY_CHECK_OBJECTS;
        }
        else if (BeanAttribute.DEPENDENCY_CHECK_SIMPLE_ATTRIBUTE_VALUE.equals(att)) {
            return AbstractBeanDefinition.DEPENDENCY_CHECK_SIMPLE;
        }
        else {
            return AbstractBeanDefinition.DEPENDENCY_CHECK_NONE;
        }
    }
}
