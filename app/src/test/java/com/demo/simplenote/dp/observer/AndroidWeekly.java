package com.demo.simplenote.dp.observer;

/**
 * Created by mrsimple on 18/10/17.
 */

import java.util.Observable;

/**
 * AndroidWeekly这个网站是被观察者,它有更新所有的观察者 (这里是程序员) 都会接到相应的通知.
 *
 * @author mrsimple
 */
public class AndroidWeekly extends Observable {

    public void postNewPublication(String content) {
        // 标识状态或者内容发生改变
        setChanged();
        // 通知所有观察者
        notifyObservers(content);
    }

    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        // 被观察的角色
        AndroidWeekly androidWeekly = new AndroidWeekly();

        // 将观察者注册到可观察对象的观察者列表中
        androidWeekly.addObserver(new Coder("mr.simple"));
        androidWeekly.addObserver(new Coder("任玉刚"));
        androidWeekly.addObserver(new Coder("朝辉"));

        // 发布消息
        androidWeekly.postNewPublication("新的一期AndroidWeekly来啦!");
    }
}