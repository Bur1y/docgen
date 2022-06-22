package com.nrtk.bur1y.docgen.Data;

import java.util.List;

public class Group {

    public List<Student> studentList;
    public String name;

    public Group(String name){
        this.name = name;
    }

    public Group(List<Student> studentList, String name) {
        this.studentList = studentList;
        this.name = name;
    }


    @Override
    public String toString(){

        return name;
    }
}
