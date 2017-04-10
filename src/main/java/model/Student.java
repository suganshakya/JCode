package model;

import java.util.Calendar;

/**
 * Created by sugan on 1/6/17.
 */
public class Student {
    String name;
    String subject;
    Double mark;

    Calendar enrollDate;

    public Student(String name, String subject, Double mark) {
        this.name = name;
        this.subject = subject;
        this.mark = mark;
    }

    public Student(String name, String subject, Double mark, Calendar enrollDate) {
        this.name = name;
        this.subject = subject;
        this.mark = mark;
        this.enrollDate = enrollDate;
    }

    public String getSubject() {

        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public Calendar getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Calendar enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", mark=" + mark +
                ", enrollDate=" +
                (enrollDate == null ? "-" :
                (enrollDate.get(Calendar.YEAR) + "-" + (enrollDate.get(Calendar.MONTH) + 1) + "-" +
                enrollDate.get(Calendar.DAY_OF_MONTH))) +
                '}';
    }
}

