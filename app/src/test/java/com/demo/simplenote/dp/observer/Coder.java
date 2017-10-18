package com.demo.simplenote.dp.observer;

/**
 * Created by mrsimple on 18/10/17.
 */

import java.util.Observable;
import java.util.Observer;

/**
 * 程序员是观察者
 *
 * @author mrsimple
 */
public class Coder implements Observer {
    public String name ;

    public Coder(String aName) {
        name = aName ;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println( "Hi, " +  name + ", AndroidWeekly更新啦, 内容 : " + arg);
    }

    @Override
    public String toString() {
        return "码农 : " + name;
    }

}
