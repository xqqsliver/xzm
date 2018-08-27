package com.xz.service.frame.source;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.Document;

/**
 * 1解析xml
 * 2 封装成beandefinition
 * 3 注册到容器
 * 4 实例化bean
 * 5 初始化bean
 */
public class SpringSourceOne  implements  SpringInterface{


    public Document getDocument(String filePath) {
        DefaultBeanDefinitionDocumentReader reader=new DefaultBeanDefinitionDocumentReader();

        ClassPathXmlApplicationContext xx=new ClassPathXmlApplicationContext("cc");
        return null;
    }

}
