package com.mark.solution.singleton;

// 加锁懒加载单例
public class LockLazySingleton implements Singleton {

    private static Singleton singleton;

    private LockLazySingleton() {
        // 空构造方法，不暴露出去
    }

    // 串行加锁，效率变慢
    @Override
    public synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new LockLazySingleton();
        }
        return LockLazySingleton.singleton;
    }
}
