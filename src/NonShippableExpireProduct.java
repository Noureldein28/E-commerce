import java.time.LocalDate;

public class NonShippableExpireProduct extends expirableProduct{
    public NonShippableExpireProduct(String name, float price, int quantity, LocalDate expireDate) {
        super(name, price, quantity, expireDate);
    }

    @Override
    public boolean canShipping() {
        return false;
    }
}
