import java.time.LocalDate;

public class Cheese extends ExpirableProduct implements ShippableItem {
    private double weightKg;

    public Cheese(String n, double p, int q, double w) {
        this(n, p, q, w, LocalDate.now().plusDays(7));
    }

    public Cheese(String n, double p, int q, double w, LocalDate eDate) {
        super(n, p, q, eDate);
        this.weightKg = w;
    }

    @Override
    public double getWeight() {
        return weightKg;
    }

    @Override
    public String getName() {
        return name;
    }
}