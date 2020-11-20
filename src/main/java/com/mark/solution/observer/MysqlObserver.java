package com.mark.solution.observer;

public class MysqlObserver<T> implements Observer<T> {

    // 初始化时自动加载到观察者列表中
    public MysqlObserver() {
        Subject.addObserver(this);
    }

    // 业务逻辑
    @Override
    public void operate(T t) {
        System.out.println("operating the Database...");
    }
}
