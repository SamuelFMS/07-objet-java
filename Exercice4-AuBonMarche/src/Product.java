import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Product implements Consumable {
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

    public Product(String name, double unitPrice, String unite, double stockQuantity, LocalDate pickingDate, int shelfLifeDays) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.unite = unite;
        this.stockQuantity = stockQuantity;
        this.pickingDate = pickingDate;
        this.shelfLifeDays = shelfLifeDays;
    }

    public abstract LocalDate calculateExpirationDate();

    public void updateStockAfterOrder(double quantity) {
        stockQuantity -= quantity;
    }

    public String priceFormat(){
        String s;
        switch (unite) {
            case "kg":
                s = stockQuantity + " €/kg";
                break;
            case "pcs":
                s = stockQuantity + " €/pièce";
                break;
            default:
                s = unitPrice + " €/"+ unite;
                break;
        }
        return s;
    }

    public String stockFormat(){
        String s;
        switch (unite) {
            case "kg":
                s = stockQuantity + " kg";
                break;
            case "pcs":
                s = stockQuantity + " pièces";
                break;
            default:
                s = stockQuantity + unite;
                break;
        }
        return s;
    }

    public String toString(LocalDate currentDate) {
        return name + " | " + stockFormat() + " | " + priceFormat() + " | " + daysRemainingBeforeExpiration(currentDate) + " Jours";
    }

    @Override
    public boolean isRipe() {
        return false;
    }

    @Override
    public boolean isExpired(LocalDate dateVerification) {
        long daysRemaining = daysRemainingBeforeExpiration(dateVerification);
        return daysRemaining <= 0;
    }

    public LocalDate dateItExpired(){
        return getPickingDate().plusDays(getShelfLifeDays());
    }

    @Override
    public long daysRemainingBeforeExpiration(LocalDate dateVerification) {
        LocalDate dateItExpired = dateItExpired();
        return dateItExpired.compareTo(dateVerification);
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
