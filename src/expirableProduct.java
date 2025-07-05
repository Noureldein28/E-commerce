import java.time.LocalDate;

public abstract class expirableProduct extends Product {
    protected LocalDate expireDate;

    public expirableProduct(String name, float price, int quantity, LocalDate expireDate)  {
        super(name,price,quantity);
        this.expireDate = expireDate;
    }
    public LocalDate getExpiryDate() {
        return expireDate;
    }
    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expireDate);
    }

}