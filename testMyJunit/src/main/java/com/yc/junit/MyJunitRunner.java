package com.yc.junit;



import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class MyJunitRunner {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, MalformedURLException {
        //因为没有idea插件，只能先做class加载

//        MyCaculatorTest cal=new MyCaculatorTest();
//        String name=cal.getClass().getName();
//        System.out.println(cal.getClass().getName());



//        Class cls=Class.forName("com.yc.junit.MyCaculatorTest");




//C:\Users\Lenovo\Desktop\reflectionAndAnnotation\testMyJunit\target\test-classes\com\yc\junit
        String basePath=System.getProperty("user.dir")+"/testMyJunit/target/test-classes/";
        System.out.println(basePath);
        URL url=new URL("file",null,basePath);
        URL[] urls=new URL[]{url};
        //指定加载器扫描的地址/kaw
        URLClassLoader ucl=new URLClassLoader(urls);
        //加载字节码文件kaw/HelloServlet
        //一定要保证取名（类名和请求的xxx.action）一致
        //ucl.loadClass要是一个全类名

        Class cls=ucl.loadClass("MyCaculatorTest2");
        // if(cls.getSuperclass().getName().equals("HttpServlet"))
        //serletName:HelloServlet




        //TODO:升级：....按照maven约定的目录要求扫描test/java下的单元测试类
        //1.获取这类中所有方法
        Method[] ms=cls.getDeclaredMethods();
        List<Method> testMethods=new ArrayList<>();
        Method beforeMethod=null;
        Method afterMethod=null;
        Method beforeClassMethod=null;
        Method afterClassMethod=null;

        //2.循环这些方法，判断上面加了哪个注解
        for(Method m:ms){
            //3.将这些方法分别存好@Test对应的方法有多个，存到一个集合中，其他注解对应的方法只有一个人，直接存
            if(m.isAnnotationPresent(MyTest.class)){
                //添加到集合中
                testMethods.add(m);
            }
            if(m.isAnnotationPresent(MyBefore.class)){
                beforeMethod=m;
            }
            if(m.isAnnotationPresent(MyAfter.class)){
               afterMethod=m;
            }
            if(m.isAnnotationPresent(MyBeforeClass.class)){
                beforeClassMethod=m;
            }
            if(m.isAnnotationPresent(MyAfterClass.class)){
                afterClassMethod=m;
            }
        }
        //4.按junit的运行的生命周期来调用
        if(testMethods==null||testMethods.size()<=0){
            throw new RuntimeException("没有要测试的方法");
        }
        //实例化测试类
        Object o=cls.newInstance();
        beforeClassMethod.invoke(o,null);
        for (Method m:testMethods){
            if (beforeMethod!=null){
                beforeMethod.invoke(o,null);
            }
            m.invoke(o,null);
            if(afterMethod!=null){
                afterMethod.invoke(o,null);
            }
        }
        afterClassMethod.invoke(o,null);

    }
}
