package com.xz.service.source.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者的实现类
 */

public class ObserverableImpl implements  Observerable {
    //注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<Observer> list;
    private String message;

    public ObserverableImpl() {
        list = new ArrayList<Observer>();
    }


    public void registerObserver(Observer o) {

        list.add(o);
    }

    public void removeObserver(Observer o) {
        if(!list.isEmpty())
            list.remove(o);
    }

    //遍历
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            Observer oserver = list.get(i);
            oserver.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }

}
