package com.xz.service.frame.spring;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletListenerDemo implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        //web容器初始化的时候调用

    }

    public void contextDestroyed(ServletContextEvent sce) {
        //web容器关闭的时候调用
    }
}
