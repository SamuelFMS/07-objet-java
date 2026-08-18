import java.util.ArrayList;

public class Basket {
    private final ArrayList<ProductBasket> myBasket = new ArrayList<>();

    public void addToBasket(Product product, double quantity) {
        myBasket.add(new ProductBasket(product, quantity));
        product.setStockQuantity(product.getStockQuantity() - quantity);
    }

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

    public ArrayList<ProductBasket> getMyBasket() {
        return myBasket;
    }
}
