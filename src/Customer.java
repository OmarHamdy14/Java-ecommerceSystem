import java.util.List;

public class Customer {
    private Cart cart = new Cart();
    private double balance;

    public Customer(double b) {
        this.balance = b;
    }

    public void addToCart(Product p, int qty) {
        cart.addItem(p, qty);
    }

    public void removeFromCart(Product p) {
        cart.removeItem(p);
    }

    public void updateCartQuantity(Product p, int newQty) {
        cart.updateItemQuantity(p, newQty);
    }

    public void checkout() {
        if (cart.isEmpty()) {
            throw new RuntimeException("Failed ... Cart is empty");
        }

        for (CartItem item : cart.getItems()) {
            if (item.product.isExpired()) {
                throw new RuntimeException("Failed .. " + item.product.getName() + " is expired.");
            }
            if (item.quantity > item.product.getQuantity()) {
                throw new RuntimeException("Failed .. " + item.product.getName() + " is out of stock.");
            }
        }

        double subtotal = cart.getSubtotal();
        List<CartItem> shippables = cart.getShippableCartItems();
        double shippingFee = shippables.stream().mapToDouble(CartItem::getTotalWeight).sum() * 10;
        double total = subtotal + shippingFee;

        if (balance < total) {
            throw new RuntimeException("Failed ... Insufficient balance.");
        }

        balance -= total;

        for (CartItem item : cart.getItems()) {
            item.product.reduceQuantity(item.quantity);
        }

        ShippingService.send(shippables);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.product.getName() + " " + (int) item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + (int)subtotal);
        System.out.println("Shipping " + (int)shippingFee);
        System.out.println("Amount " + (int)total);
    }
}