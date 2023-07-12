package sjh.example.designPattern.singleton;

public class Singleton1 {
    // 单例模式，适用于无状态
    /*
    饿汉式
     */
    private static Singleton1 singleton1 = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return singleton1;
    }

}
