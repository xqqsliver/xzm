package com.xz.service.frame.spring;

import org.springframework.beans.factory.InitializingBean;

public class AfterSetDemo implements InitializingBean {
    public void afterPropertiesSet() throws Exception {
        //该方法在bean初始化的时候调用
    }
}
