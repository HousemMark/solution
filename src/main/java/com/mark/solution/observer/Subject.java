package com.mark.solution.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject<T> {

    private static List<Observer> observerList = new ArrayList<>();

    public Subject(T t) {
        notified(t);
    }

    public static void addObserver(Observer observer) {
        observerList.add(observer);
    }

    private void notified(T t) {
        for (Observer observer : observerList) {
            observer.operate(t);
        }
    }
}
