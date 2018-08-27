package com.xz.service.frame.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    //@Resource
    //private ContextUtil contextUtil;
    public  static void main(String args[]){

        ApplicationContext cl= ContextUtil.getApplicationContext();
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        String clee="ll";


    }
}
