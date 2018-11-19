package com.xz.service.frame.spring;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.util.Assert;

public class ParseBeanModelHolder {
    private final ParseBeanModel parseBeanModel;

    private final String beanName;

    private final String[] aliases;
    public ParseBeanModelHolder(ParseBeanModel parseBeanModel, String beanName, String[] aliases) {
        Assert.notNull(parseBeanModel, "parseBeanModel must not be null");
        Assert.notNull(beanName, "Bean name must not be null");
        this.parseBeanModel = parseBeanModel;
        this.beanName = beanName;
        this.aliases = aliases;
    }
}
