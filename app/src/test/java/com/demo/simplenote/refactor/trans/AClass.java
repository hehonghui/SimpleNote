package com.demo.simplenote.refactor.trans;

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

    // 其他函数

}
