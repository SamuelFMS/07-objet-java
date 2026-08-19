import java.math.BigDecimal;
import java.util.ArrayList;

public class Basket {
    /**
     * Basket contain all the product with their quantity
     */
    private final ArrayList<ProductBasket> myBasket = new ArrayList<>();

    /**
     * Add a product to the basket with their quantity
     *
     * @param product
     * @param quantity
     */
    public void addToBasket(Product product, BigDecimal quantity) {
        boolean trouver = false;
        for (ProductBasket productBasket : myBasket) {
            if (productBasket.getProduct() == product) {
                productBasket.setQuantity(productBasket.getQuantity().add(quantity));
                trouver = true;
            }
        }
        if (!trouver) {
            myBasket.add(new ProductBasket(product, quantity));
        }
    }

    /**
     * Get the total price of a basket
     *
     * @return
     */
    public BigDecimal getPriceTotalBasket() {
        BigDecimal total = BigDecimal.ZERO;
        for (ProductBasket productBasket : myBasket) {
            total = total.add(productBasket.getPrice());
        }
        return total;
    }

    @Override
    public String toString() {
        int size = 50;
        StringBuilder res = new StringBuilder();
        res.append(TextFormatter.repeat("-",size)).append("\n");
        if (myBasket.isEmpty()) {
            res.append("Mon panier de basket est vide \n");
        } else {
            for (ProductBasket productBasket : myBasket) {
                StringBuilder line = new StringBuilder();
                StringBuilder price = new StringBuilder();
                line.append("• ");
                line.append(productBasket.getProduct().getName());
                line.append(" x ");
                line.append(productBasket.stockFormat()).append(" ");
                price.append(productBasket.getPrice()).append(" €");
                res.append(TextFormatter.formatSize(line.toString(),size-price.length(), "."));
                res.append(price);
                res.append("\n");
            }
        }
        res.append(TextFormatter.repeat("-",size)).append("\n");
        res.append("TOTAL TEMPORAIRE : ").append(getPriceTotalBasket()).append("€");
        return res.toString();
    }

    /*
        Getter and Setter
     */
    public ArrayList<ProductBasket> getMyBasket() {
        return myBasket;
    }
}
