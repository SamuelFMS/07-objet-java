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
    public void addToBasket(Product product, double quantity) {
        boolean trouver = false;
        for (ProductBasket productBasket : myBasket) {
            if (productBasket.getProduct() == product) {
                productBasket.setQuantity(productBasket.getQuantity() + quantity);
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
    public double getPriceTotalBasket() {
        double total = 0;
        for (ProductBasket productBasket : myBasket) {
            total += productBasket.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        if (myBasket.isEmpty()) {
            res.append("Mon panier de basket est vide");
        } else {
            for (ProductBasket productBasket : myBasket) {
                res.append(productBasket).append("\n");
            }
            res.append("Total: ").append(getPriceTotalBasket()).append("€");
        }
        return res.toString();
    }

    /*
        Getter and Setter
     */
    public ArrayList<ProductBasket> getMyBasket() {
        return myBasket;
    }
}
