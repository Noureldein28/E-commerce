import java.util.ArrayList;
import java.util.List;

public class EcommerceSystem {

    class CheckoutException extends Exception {
        public CheckoutException(String message) {
            super(message);
        }
    }

    private ShippingService shippingService;
    private static final double SHIPPING_RATE = 30.0;

    public EcommerceSystem() {
        this.shippingService = new ShippingService();
    }

    public void checkout(Customer customer, shoppingCart cart) throws CheckoutException {
        // Validate cart is not empty
        if (cart.isEmpty()) {
            throw new CheckoutException("Cart is empty");
        }

        // Validate products availability and expiry
        List<Shippable> shippableItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getItem();


            if (product.isExpired()) {
                throw new CheckoutException("Product " + product.getName() + " is expired");
            }


            if (item.getQuantity() > product.getQuantity()) {
                throw new CheckoutException("Product " + product.getName() + " is out of stock");
            }


            if (product.canShipping() && product instanceof Shippable) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippableItems.add((Shippable) product);
                }
            }
        }
        double subtotal = cart.getSubtotal();
        double shippingFee = shippableItems.isEmpty() ? 0 : SHIPPING_RATE;
        double totalAmount = subtotal + shippingFee;


        if (customer.getBalance() < totalAmount) {
            throw new CheckoutException("Insufficient balance");
        }


        for (CartItem item : cart.getItems()) {
            Product product = item.getItem();
            product.setQuantity(product.getQuantity() - item.getQuantity());
        }

        customer.deductBalance(totalAmount);

        if (!shippableItems.isEmpty()) {
            shippingService.ship(shippableItems);
        }
        System.out.println("-------------------------------");
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.0f%n",
                    item.getQuantity(),
                    item.getItem().getName(),
                    item.getTotalPrice());
        }
        System.out.println("-------------------------------");
        System.out.printf("Subtotal %.0f%n", subtotal);
        System.out.printf("Shipping %.0f%n", shippingFee);
        System.out.printf("Amount %.0f%n", totalAmount);
        System.out.printf("Customer balance after payment: %.2f%n", customer.getBalance());
        System.out.println("END.");

        cart.clear();
    }
}
