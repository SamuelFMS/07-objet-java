import java.time.LocalDate;

public class Vegetable extends Product {
    public Vegetable(String name, double unitPrice, String unite, double stockQuantity, LocalDate pickingDate, int shelfLifeDays) {
        super(name, unitPrice, unite, stockQuantity, pickingDate, shelfLifeDays);
    }

    @Override
    public LocalDate calculateExpirationDate() {
        return null;
    }
}
