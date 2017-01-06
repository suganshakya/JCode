package model;

/**
 * Created by sugan on 1/6/17.
 */
public class Student {
    String name;
    String subject;
    Double mark;

    public Student(String name, String subject, Double mark) {
        this.name = name;
        this.subject = subject;
        this.mark = mark;
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

    @Override
    public String toString() {
        return "Student{name='" + name + '\'' + ", subject='" + subject + '\'' +", mark=" + mark +'}';
    }
}

