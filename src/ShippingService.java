import java.util.List;

public class ShippingService {
    public void ship(List<Shippable> items) {
        if (items.isEmpty()) return;

        System.out.println("** Shipment notice **");
        double totalWeight = 0;

        for (Shippable item : items) {
            System.out.printf("1x %s %.0fg%n", item.getName(), item.getWeight() * 1000);
            totalWeight += item.getWeight();
        }

        System.out.printf("Total weight %.1fkg%n", totalWeight);
    }


}
