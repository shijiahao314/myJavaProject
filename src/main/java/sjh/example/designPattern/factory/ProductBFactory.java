package sjh.example.designPattern.factory;

public class ProductBFactory extends AbstractFactory {
    @Override
    public Product produce() {
        return new ProductB();
    }
}
