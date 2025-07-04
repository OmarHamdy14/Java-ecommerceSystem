import java.util.*;

public class Cart {
    private Map<Product, CartItem> items = new LinkedHashMap<>();

    public void addItem(Product p, int qty) {
        if (items.containsKey(p)) {
            items.get(p).increaseQuantity(qty);
        } else {
            items.put(p, new CartItem(p, qty));
        }
    }

    public void removeItem(Product p) {
        items.remove(p);
    }

    public void updateItemQuantity(Product p, int newQty) {
        if (items.containsKey(p)) {
            items.get(p).setQuantity(newQty);
        }
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items.values());
    }

    public double getSubtotal() {
        return items.values().stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<CartItem> getShippableCartItems() {
        List<CartItem> shippables = new ArrayList<>();
        for (CartItem item : items.values()) {
            if (item.getProduct() instanceof ShippableItem) {
                shippables.add(item);
            }
        }
        return shippables;
    }
}