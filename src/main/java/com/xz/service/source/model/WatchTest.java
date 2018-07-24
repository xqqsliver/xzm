package com.xz.service.source.model;

/**
 * 观察者模式
 * 观察者接口和实现类
 * 被观察者接口和实现类
 * 在被观察者的参数变更的时候，调用对应的方法，更新观察者里面的参数
 */
public class WatchTest {
    public static void main(String args[]){


        ObserverableImpl server = new ObserverableImpl();

        Observer userZhang = new ObserverImpl("ZhangSan");
        Observer userLi = new ObserverImpl("LiSi");
        Observer userWang = new ObserverImpl("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        server.removeObserver(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");


    }
}
