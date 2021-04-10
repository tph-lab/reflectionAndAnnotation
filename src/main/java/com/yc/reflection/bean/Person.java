package com.yc.reflection.bean;

public class Person implements Showable{

    private String name;
    private int age;

    public Person(){
        System.out.println("无参构造方法");
    }


    public Person(String name) {
        this.name = name;
        System.out.println("有参构造方法");
    }

    @Override
    public void show() {
        System.out.println("调用了show方法");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
