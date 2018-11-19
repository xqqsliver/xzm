package com.xz.service.frame.spring;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;

public interface ProgressService {
    /**
     * 获取document
     * @param path
     * @return
     * @throws ParserConfigurationException
     * @throws FileNotFoundException
     */
     Document getDocument(String path) throws ParserConfigurationException, FileNotFoundException;

    /**
     * 注册bean
     * @param root
     */
     void doRegisterBeanDefinitions(Element root);
    /**
     * 解析xml
     */
    void parseBeanDefinitions(Element root);
}
