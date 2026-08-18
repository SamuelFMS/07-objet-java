public class ProductBasket {
    private final Product product;
    private final double quantity;

    public ProductBasket(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
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
}
