public class NonShippableNonExpireProduct extends NonExpireProduct {
    public NonShippableNonExpireProduct(String name, float price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean canShipping() {
        return false;
    }

}
