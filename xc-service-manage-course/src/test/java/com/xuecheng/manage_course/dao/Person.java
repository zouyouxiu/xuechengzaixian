package com.xuecheng.manage_course.dao;

public class Person {
    String name;
    Integer id;

    public Person(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
