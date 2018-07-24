package com.xz.service.source.model;

/**
 * 观察者实现类
 */
public class ObserverImpl  implements Observer{
    private String name;
    private String message;

    public ObserverImpl(String name) {
        this.name = name;
    }
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }


}
