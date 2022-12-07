package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Student {

    private int std_no;

    private int totalMarks;

    private ArrayList<Integer> std_marks;

    public int getStd_no() {
        return std_no;
    }

    public void setStd_no(int std_no) {
        this.std_no = std_no;
    }

    public ArrayList<Integer> getStd_marks() {
        return std_marks;
    }

    public void setStd_marks(ArrayList<Integer> std_marks) {
        this.std_marks = std_marks;
    }

    @Override
    public String toString() {
        return "Student [std_no=" + std_no + ", std_marks=" + std_marks + "]";
    }

    public Student(int std_no, ArrayList<Integer> std_marks) {
        super();
        this.std_no = std_no;
        this.std_marks = std_marks;
    }

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void compareId(ArrayList<Student> std) {
        std.stream().sorted(Comparator.comparing(Student::getStd_no)).collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public void sumMarks(ArrayList<Student> std) {
        Iterator itr = std.iterator();
        while (itr.hasNext()) {
            Student stda = (Student) itr.next();
            System.out.println(stda.std_marks);
            // for (Integer mark : stda.std_marks) {
            // totalMarks += mark;
            // }
            // System.out.println("totalmarks" + totalMarks);
            // ArrayList<Integer> asumlist = stda.std_marks;
            // totalMarks = asumlist.stream().mapToInt(i -> i).sum();
            // System.out.println("totalmarks" + totalMarks);

        }

    }
}
