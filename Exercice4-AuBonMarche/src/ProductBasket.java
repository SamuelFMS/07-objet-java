public class ProductBasket {
    /**
     * Product
     */
    private final Product product;
    /**
     * quantity of the product
     */
    private double quantity;

    /*
        Constructor
     */
    public ProductBasket(Product product, double quantity) {
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
    public double getPrice() {
        return product.realPrice() * quantity;
    }

    @Override
    public String toString() {
        return product.getName() + " | " + quantity + " | " + product.realPrice() * quantity + "€";
    }

    /*
        Getter and Setter
     */
    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
