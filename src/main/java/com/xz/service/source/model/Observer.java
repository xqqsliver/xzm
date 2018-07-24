package com.xz.service.source.model;

/**
 * 观察者接口，在得到被观察者有更新的时候，做相应的改变
 */
public interface Observer {
    public void update(String message);
}
}
