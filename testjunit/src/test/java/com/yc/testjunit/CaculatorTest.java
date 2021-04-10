package com.yc.testjunit;

import com.yc.testjunit.Caculator;
import org.junit.*;



public class CaculatorTest {

    private Caculator cal;
    @Before
    public void setUp() throws Exception {
        cal=new Caculator();
        System.out.println("before");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @Test
    public void add() {
        System.out.println("add测试");
        Assert.assertEquals(3,cal.add(1,2));
    }

    @Test
    public void sub() {
        System.out.println("sub测试");
        Assert.assertEquals(1,cal.sub(2,1));
    }


    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("AfterClass");

    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("BeforeClass");
    }
}