package com.mark.solution;

import com.mark.solution.builder.SimpleBean;
import com.mark.solution.observer.ElasticSearchObserver;
import com.mark.solution.observer.Event;
import com.mark.solution.observer.MysqlObserver;
import com.mark.solution.observer.Subject;

/**
 * @description:
 * @author: mazhonghao
 * @create: 2020-11-7 23:01
 **/
public class Main {

    // testing cases are in the test package
    public static void main(String[] args) {
        System.out.println("application is running...");

        MysqlObserver<Event> mysqlObserver = new MysqlObserver<>();
        ElasticSearchObserver<Event> elasticSearchObserver = new ElasticSearchObserver<>();
        Subject<Event> subject = new Subject<>(new Event());
    }
}
