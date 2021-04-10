import com.yc.junit.*;
import com.yc.testjunit.Caculator;



public class MyCaculatorTest2 {

    //可以使用导入的包
    private Caculator cal;
    @MyBefore
    public void setUp() throws Exception {
        cal=new Caculator();
        System.out.println("before");
    }

    @MyAfter
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @MyTest
    public void add() {
        System.out.println("add测试");
    }

    @MyTest
    public void sub() {
        System.out.println("sub测试");
    }


    @MyAfterClass
    public static void afterClass() throws Exception {
        System.out.println("AfterClass");

    }

    @MyBeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("BeforeClass");
    }
}