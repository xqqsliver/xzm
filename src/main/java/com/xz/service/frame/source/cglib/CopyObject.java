package com.xz.service.frame.source.cglib;

import com.alibaba.dubbo.common.json.JSON;
import org.springframework.cglib.beans.BeanCopier;

import java.io.IOException;

public class CopyObject {
    private String value;
    private  String name;
    private String age;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static void main(String args[]){
        BeanCopier copier = BeanCopier.create(CopyObject.class, OtherObject.class, false);//设置为true，则使用converter
        CopyObject myBean = new CopyObject();
        myBean.setValue("Hello cglib");
        OtherObject otherBean = new OtherObject();
        copier.copy(myBean, otherBean, null); //设置为true，则传入converter指明怎么进行转换
        try {
            System.out.println(JSON.json(otherBean));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //assertEquals("Hello cglib", otherBean.getValue());
    }
}
