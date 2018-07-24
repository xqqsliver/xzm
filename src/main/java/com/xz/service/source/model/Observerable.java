package com.xz.service.source.model;

/**
 * 抽象的被观察者
 */

public interface Observerable {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);

    /**
     * 改变通知给观察者
     */
    public void notifyObserver();
}
