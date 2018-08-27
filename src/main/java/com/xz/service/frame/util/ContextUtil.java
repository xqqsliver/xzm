package com.xz.service.frame.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ContextUtil implements ApplicationContextAware {
    private static  ApplicationContext applicationContext;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ContextUtil.applicationContext=applicationContext;
    }
    public static ApplicationContext getApplicationContext() {
        //checkApplicationContext();
        return applicationContext;
    }


}
