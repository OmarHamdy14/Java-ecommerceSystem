import java.time.LocalDate;

public class Biscuits extends ExpirableProduct implements ShippableItem {
    private double weightKg;

    public Biscuits(String n, double p, int q, double w) {
        this(n, p, q, w, LocalDate.now().plusDays(14));
    }

    public Biscuits(String n, double p, int q, double w, LocalDate eDate) {
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