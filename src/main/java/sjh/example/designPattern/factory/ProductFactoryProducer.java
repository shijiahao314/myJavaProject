package sjh.example.designPattern.factory;

public class ProductFactoryProducer {
    public static AbstractFactory getProductFactory(String type) {
        if (type.equalsIgnoreCase("A")) {
            return new ProductAFactory();
        } else if (type.equalsIgnoreCase("B")) {
            return new ProductBFactory();
        } else {
            return null;
        }
    }
}
