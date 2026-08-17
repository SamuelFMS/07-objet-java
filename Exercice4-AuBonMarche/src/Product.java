import java.time.LocalDate;

public abstract class Product {
    /**
     * Name of the fruit or vegetable
     */
    private String name;
    /**
     * Price per kg or per piece
     */
    private double unitPrice;
    /**
     * The unit of sale ("kg" or "piece")
     */
    private String unite;
    /**
     * Current stock (in kg or number of units)
     */
    private double stockQuantity;
    /**
     * The date the product was harvested
     */
    private LocalDate pickingDate;
    /**
     * The maximum shelf life in days (a general attribute
     * for the product type).
     */
    private int shelfLifeDays;

    public abstract LocalDate calculateExpirationDate();

    public void updateStockAfterOrder(double quantity) {
        stockQuantity -= quantity;
    }

    /*
     * Getter et Setter
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public double getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(double stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public LocalDate getPickingDate() {
        return pickingDate;
    }

    public void setPickingDate(LocalDate pickingDate) {
        this.pickingDate = pickingDate;
    }

    public int getShelfLifeDays() {
        return shelfLifeDays;
    }

    public void setShelfLifeDays(int shelfLifeDays) {
        this.shelfLifeDays = shelfLifeDays;
    }
}
