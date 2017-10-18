package com.demo.simplenote.refactor.trans;

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


    // 判断一个学生是否属于某个班级
    public boolean isBelongTo(AClass aClass) {
        for (Student stu : aClass.students) {
            if (stu.id.equals(this.id)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Student [ id=" + id + ", name=" + name + " ]";
    }

}
