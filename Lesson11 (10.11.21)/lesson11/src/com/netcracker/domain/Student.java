package com.netcracker.domain;

public class Student {
    private int age;
    private String name;
    private int id;
    private Faculty faculty;

    public Student(int age, String name, Faculty faculty) {
        this.age = age;
        this.name = name;
        this.faculty = faculty;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public static String alternativeValueForOptional() {
        return "Меня нету!";
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", faculty=" + faculty +
                '}';
    }
}
