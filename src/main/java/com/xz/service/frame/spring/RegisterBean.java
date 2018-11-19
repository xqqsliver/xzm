package com.xz.service.frame.spring;

import org.w3c.dom.Document;

public class RegisterBean {
    public void register(){
        ProgressServiceImpl service=new ProgressServiceImpl();
        Document doc= service.getDocument("applicationContext.xml");
        service.parseBeanDefinitions(doc.getDocumentElement());




    }
}
