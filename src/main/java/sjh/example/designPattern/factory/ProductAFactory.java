package sjh.example.designPattern.factory;

public class ProductAFactory extends AbstractFactory {
    @Override
    public ProductA produce() {
        return new ProductA();
    }
}
