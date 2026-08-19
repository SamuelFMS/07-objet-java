import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductBasket {
    /**
     * Product
     */
    private final Product product;
    /**
     * quantity of the product
     */
    private BigDecimal quantity;

    /*
        Constructor
     */
    public ProductBasket(Product product,  BigDecimal quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Stock format
     * @return
     */
    public String stockFormat() {
        String s;
        switch (product.getUnite()) {
            case "kg":
                s = this.quantity + " kg";
                break;
            case "pcs":
                s = this.quantity + " pièces";
                break;
            default:
                s = this.quantity + product.getUnite();
                break;
        }
        return s;
    }

    /**
     * Get the price of the product basket
     * @return
     */
    public BigDecimal getPrice() {
        return product.realPrice().multiply(quantity).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return product.getName() + " | " + quantity + " | " + getPrice() + "€";
    }

    /*
        Getter and Setter
     */
    public Product getProduct() {
        return product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
