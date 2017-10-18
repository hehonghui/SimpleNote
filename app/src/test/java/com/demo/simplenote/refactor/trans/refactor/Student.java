package com.demo.simplenote.refactor.trans.refactor;

/**
 * Created by mrsimple on 18/10/17.
 */
public class Student {
    public String id;
    public String name;

    public Student(String sId, String sName) {
        this.id = sId;
        this.name = sName;
    }


    @Override
    public String toString() {
        return "Student [ id=" + id + ", name=" + name + " ]";
    }

}
