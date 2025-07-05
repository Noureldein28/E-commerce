import java.time.LocalDate;
import java.util.*;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        try {

            Product cheese = new ShippableExpireProduct("Cheese", 70, 5,LocalDate.now().plusDays(5), 0.5);
            Product tv = new ShippableNonExpireProduct ("TV", 1000, 10, 5);
            Product scratchCard = new NonShippableNonExpireProduct("Mobile Scratch Card", 100, 20);
            Product biscuits = new ShippableExpireProduct("Biscuits", 20, 8,LocalDate.now().plusDays(10), 0.7);


            Customer customer = new Customer("Noureldein", 10000);


            shoppingCart cart = new shoppingCart();
            cart.add(cheese, 1);
            cart.add(tv, 1);
            cart.add(scratchCard, 1);
            cart.add(biscuits, 1);


            EcommerceSystem system = new EcommerceSystem();
            system.checkout(customer, cart);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}