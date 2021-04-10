package com.yc.annotation;

@MyHelloWorld
public class Teacher {

    @MyHelloWorld
    private String name;

    @MyHelloWorld
    public String show(@MyHelloWorld String s){
        return "show";
    }
}
