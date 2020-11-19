package com.mark.solution.singleton;

public class ReLockSingleton implements Singleton {

    // 防止重排序
    private volatile static Singleton singleton;

    private ReLockSingleton() {
        // 空构造方法，不暴露出去
    }

    /**
     * 执行双重检查是因为，如果多个线程同时了通过了第一次检查
     * 并且其中一个线程首先通过了第二次检查并实例化了对象
     * 那么剩余通过了第一次检查的线程就不会再去实例化对象。
     */
    @Override
    public Singleton getInstance() {
        // 减小加锁颗粒度，解决了性能消耗的问题
        if (singleton == null) {
            synchronized (ReLockSingleton.class) {
                if (singleton == null) {
                    // 正常情况分解成以下三个步骤：分配内存空间，初始化对象，将对象指向刚分配的内存空间
                    // 重排序情况：分配内存空间，将对象指向刚分配的内存空间，初始化对象
                    // 1.重排序造成空指针场景：A线程执行到这步时，分配内存空间且指向了该内存空间，但仍未初始化。
                    // 2.此时B线程开始判断singleton对象已经存在，即刻返回，因此程序拿到的对象就是还没初始化的空对象。
                    singleton = new ReLockSingleton();
                }
            }
        }
        return ReLockSingleton.singleton;
    }
}
