package com.mark.solution.singleton;

// 饿汉式单例
public class HungrySingleton implements Singleton {

    // 由于静态代码块修饰，它加载时候会随着类加载
    private static final Singleton singleton = new HungrySingleton();

    private HungrySingleton() {
        // 空构造方法，不暴露出去
    }

    @Override
    public Singleton getInstance() {
        return HungrySingleton.singleton;
    }

}
