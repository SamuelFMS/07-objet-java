import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Product implements Consumable {
    /**
     * Name of the fruit or vegetable
     */
    private final String name;
    /**
     * Price per kg or per piece
     */
    private BigDecimal unitPrice;
    /**
     * The unit of sale ("kg" or "piece")
     */
    private String unite;
    /**
     * Current stock (in kg or number of units)
     */
    private BigDecimal stockQuantity;
    /**
     * The date the product was harvested
     */
    private LocalDate pickingDate;
    /**
     * The maximum shelf life in days (a general attribute
     * for the product type).
     */
    private int shelfLifeDays;

    /*
        Constructor
    */
    public Product(String name, double unitPrice, String unite,  double stockQuantity, LocalDate pickingDate, int shelfLifeDays) {
        this.name = name;
        this.unitPrice = BigDecimal.valueOf(unitPrice);
        this.unite = unite;
        this.stockQuantity = BigDecimal.valueOf(stockQuantity);
        this.pickingDate = pickingDate;
        this.shelfLifeDays = shelfLifeDays;
    }

    /*
        Public method
     */
    public abstract LocalDate calculateExpirationDate();

    /**
     * Update a stock after an order
     *
     * @param quantity
     */
    public void updateStockAfterOrder(BigDecimal quantity) {
        stockQuantity = stockQuantity.subtract(quantity);
    }

    /**
     * Return the price in the good format
     *
     * @return
     */
    public String priceFormat() {
        String s;
        switch (unite) {
            case "kg":
                s = unitPrice + " €/kg";
                break;
            case "pcs":
                s = unitPrice + " €/pièce";
                break;
            default:
                s = unitPrice + " €/" + unite;
                break;
        }
        return s;
    }

    /**
     * Return the stock in the good format
     *
     * @return
     */
    public String stockFormat() {
        if(stockQuantity.equals(BigDecimal.ZERO)){
            return "[EPUISE]";
        }
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
    public String toString() {
        return name + " | " + stockFormat() + " | " + priceFormat();
    }

    /**
     * A faire
     */
    public BigDecimal realPrice() {
        return unitPrice;
    }

    /**
     * is good
     *
     * @return
     */
    @Override
    public boolean isRipe() {
        return false;
    }

    /**
     * Is expired
     *
     * @param dateVerification
     * @return
     */
    @Override
    public boolean isExpired(LocalDate dateVerification) {
        long daysRemaining = daysRemainingBeforeExpiration(dateVerification);
        return daysRemaining <= 0;
    }

    /**
     * Date when it expired
     *
     * @return
     */
    public LocalDate dateItExpired() {
        return getPickingDate().plusDays(getShelfLifeDays());
    }

    /**
     * Number of days before it expired
     *
     * @param dateVerification
     * @return
     */
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public BigDecimal getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(BigDecimal stockQuantity) {
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
