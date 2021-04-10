package com.yc.annotation;

import java.lang.annotation.*;


/**
 *@Target：表示这个注解可以加在类的哪个地方
 * @Retention   这个注解在什么时候还保留(源码，字节码，运行)
 *
 *
 * @Target等，这种是元注解，即注解的注解，用来描述一个注解的约束
 */
@Target(value = {ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
//这个注解   保留到什么时候
@Retention(value = RetentionPolicy.RUNTIME)
@Documented         //生成java doc文档中是否保留这个注解
@Inherited          //子类是否可以继承父类的注解
public @interface MyHelloWorld {
    //空注解

}
