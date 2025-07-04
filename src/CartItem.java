public class CartItem {
    Product product;
    int quantity;

    public CartItem(Product p, int q) {
        this.product = p;
        this.quantity = q;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public double getTotalWeight() {
        if (product instanceof ShippableItem s)
            return s.getWeight() * quantity;
        return 0.0;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int qty) {
        this.quantity = qty;
    }

    public void increaseQuantity(int qty) {
        this.quantity += qty;
    }
}