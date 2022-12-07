package com.example;

import java.util.ArrayList;

public class Assignment5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Student> std = new ArrayList<>();
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(60);
        marks.add(70);
        marks.add(90);
        marks.add(70);
        marks.add(50);
        std.add(new Student(102, marks));

        ArrayList<Integer> marks1 = new ArrayList<>();
        marks1.add(50);
        marks1.add(80);
        marks1.add(50);
        marks1.add(60);
        marks1.add(87);
        std.add(new Student(103, marks1));

        ArrayList<Integer> marks2 = new ArrayList<>();
        marks2.add(54);
        marks2.add(70);
        marks2.add(56);
        marks2.add(68);
        marks2.add(87);
        std.add(new Student(101, marks2));

        ArrayList<Integer> marks3 = new ArrayList<>();
        marks3.add(56);
        marks3.add(74);
        marks3.add(65);
        marks3.add(76);
        marks3.add(65);
        std.add(new Student(105, marks3));

        Student st = new Student();
        st.compareId(std);
        st.sumMarks(std);
        // st.compareMarks(std);
        // Collections.sort(std);
    }

}
