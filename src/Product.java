public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String n, double p, int q) {
        this.name = n;
        this.price = p;
        this.quantity = q;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int qty) {
        quantity = qty;
    }

    public void reduceQuantity(int qty) {
        quantity -= qty;
    }

    public boolean isExpired() {
        return false;
    }

    public boolean isShippable() {
        return this instanceof ShippableItem;
    }
}