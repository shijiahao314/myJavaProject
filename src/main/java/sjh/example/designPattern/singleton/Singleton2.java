package sjh.example.designPattern.singleton;

public class Singleton2 {
    /*
    懒汉式
     */

    /*
    使用双重检查锁方式，要加关键字 volatile
    singleton = new Singleton() 可以拆解为3步：
    1、分配内存，
    2、初始化对象，
    3、指向刚分配的地址，若发生重排序，假设 A 线程执行了1和3，还没有执行2，B线程来到判断 NULL，
    B线程就会直接返回还没初始化的instance了。volatile 可以避免重排序。
     */
    private volatile static Singleton2 singleton2;

    private Singleton2() {
    }

//    public synchronized static Singleton2 getInstance() {
//        if (singleton2 == null) {
//            singleton2 = new Singleton2();
//        }
//        return singleton2;
//    }

    public static Singleton2 getInstance() {
        // 双重检查锁
        if (singleton2 == null) {
            synchronized (Singleton2.class) {
                if (singleton2 == null) {
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }

}
