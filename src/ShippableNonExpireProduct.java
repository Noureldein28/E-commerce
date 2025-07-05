public class ShippableNonExpireProduct extends NonExpireProduct  implements Shippable {

    private double weight;

    public ShippableNonExpireProduct(String name, float price, int quantity ,double weight) {
        super(name, price, quantity);
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
