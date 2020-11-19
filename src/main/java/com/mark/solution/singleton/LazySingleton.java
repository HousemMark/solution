package com.mark.solution.singleton;

// 懒汉式单例：需要时再加载
public class LazySingleton implements Singleton{
    private static Singleton singleton;

    private LazySingleton(){
        // 空构造方法，不暴露出去
    }

    // 没加锁，会有并发问题
    @Override
    public Singleton getInstance(){
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return LazySingleton.singleton;
    }
}
