package com.demo.simplenote.refactor.trans.refactor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrsimple on 18/10/17.
 */

public class AClass {

    public List<Student> students = new ArrayList<Student>();

    public void add(Student student) {
        students.add(student);
    }

    // 班里是否有某个学生
    public boolean has(Student student) {
        for (Student stu : students) {
            if (stu.id.equals(student.id)) {
                return true;
            }
        }
        return false;
    }

    // 其他函数

}
