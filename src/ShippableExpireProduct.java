import java.time.LocalDate;

public class ShippableExpireProduct extends expirableProduct implements Shippable {

    private double weight;

    public ShippableExpireProduct(String name, float price, int quantity, LocalDate expireDate ,double weight) {
        super(name, price, quantity, expireDate);
        this.weight = weight;
    }

    @Override
    public boolean canShipping() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() { return this.Name; }
}
