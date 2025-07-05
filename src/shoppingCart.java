import java.util.ArrayList;
import java.util.List;

public class shoppingCart {

    private List<CartItem> items;

    public shoppingCart() {
        this.items = new ArrayList<>();
    }

    public void add(Product product, int quantity) throws IllegalArgumentException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Requested quantity exceeds available stock");
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() { return new ArrayList<>(items); }
    public boolean isEmpty() { return items.isEmpty(); }
    public void clear() { items.clear(); }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
}



