import java.util.*;

public class ShippingService {
    public static void send(List<CartItem> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;

        for (CartItem item : items) {
            Product product = item.getProduct();
            if (product instanceof ShippableItem s) {
                int qty = item.getQuantity();
                double weight = s.getWeight();
                System.out.printf("%dx %s %.0fg \n", qty, s.getName(), weight * 1000);
                totalWeight += qty * weight;
            }
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}