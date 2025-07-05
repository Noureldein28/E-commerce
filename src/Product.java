public abstract class Product {

    protected  int Quantity;
    protected  float Price;
    protected  String Name;

    public Product() {}

    public Product(String name, float price, int quantity) {
        Name = name;
        Price = price;
        Quantity = quantity;
    }



    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public abstract boolean isExpired();
    public abstract boolean canShipping();
}
