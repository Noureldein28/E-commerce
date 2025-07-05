import java.time.LocalDate;

public abstract class NonExpireProduct extends Product {

    public NonExpireProduct(String name, float price, int quantity) {
        super(name, price, quantity);
    }
    @Override
    public boolean isExpired() {
        return false;
    }
}
