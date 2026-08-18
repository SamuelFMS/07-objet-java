public class ProductBasket {
    private final Product product;
    private double quantity;

    public ProductBasket(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

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

    public double getPrice() {
        return product.realPrice() * quantity;
    }

    @Override
    public String toString() {
        return product.getName() + " | " + quantity + " | " + product.realPrice() * quantity + "€";
    }

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
