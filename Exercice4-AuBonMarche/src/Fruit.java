import java.math.BigDecimal;
import java.time.LocalDate;

public class Fruit extends Product {
    /*
        Constructor
     */
    public Fruit(String name, double unitPrice, String unite, double stockQuantity, LocalDate pickingDate, int shelfLifeDays) {
        super(name, unitPrice, unite, stockQuantity, pickingDate, shelfLifeDays);
    }

    @Override
    public LocalDate calculateExpirationDate() {
        return null;
    }
}
