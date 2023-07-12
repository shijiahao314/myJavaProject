package sjh.example.designPattern.factory;

public class SimpleFactory {
    /*
    违反开闭原则：对拓展开放，对修改关闭
    原因：假设增加了产品，则需要修改 produce 方法
     */
    public static Product produce(String type) {
        if (type.equals("A")) {
            return new ProductA();
        } else if (type.equals("B")) {
            return new ProductB();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Product product1 = SimpleFactory.produce("A");
        if (product1 != null) {
            product1.print();
        }
        Product product2 = SimpleFactory.produce("B");
        if (product2 != null) {
            product2.print();
        }
        Product product3 = SimpleFactory.produce("C");
        if (product3 != null) {
            product3.print();
        }
    }

}
