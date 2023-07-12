package sjh.example.designPattern.factory;

public class ProductFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory abstractFactory1 = ProductFactoryProducer.getProductFactory("A");
        if (abstractFactory1 != null) {
            Product product = abstractFactory1.produce();
            product.print();
        }

        AbstractFactory abstractFactory2 = ProductFactoryProducer.getProductFactory("B");
        if (abstractFactory2 != null) {
            Product product = abstractFactory2.produce();
            product.print();
        }

    }
}
