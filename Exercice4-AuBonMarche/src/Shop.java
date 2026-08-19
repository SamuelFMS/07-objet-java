import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Shop {
    /**
     * Products of the shop
     */
    private final ArrayList<Product> myProducts;

    public Shop() {
        LocalDate firstOFJanuaryTwoThousandsAndTwentyFive = LocalDate.of(2025, 01, 01);

        Fruit clementine = new Fruit("Clémentine", 2.9, "kg", 6, firstOFJanuaryTwoThousandsAndTwentyFive, 14);
        Fruit date = new Fruit("Datte", 7, "kg", 4, firstOFJanuaryTwoThousandsAndTwentyFive, 14);
        Fruit grenade = new Fruit("Grenade", 3.5, "kg", 3, firstOFJanuaryTwoThousandsAndTwentyFive, 30);
        Fruit persimmon = new Fruit("Kaki", 4.5, "kg", 3, firstOFJanuaryTwoThousandsAndTwentyFive, 21);
        Fruit kiwi = new Fruit("Kiwi", 3.5, "kg", 5, firstOFJanuaryTwoThousandsAndTwentyFive, 30);
        Fruit mandarinOrange = new Fruit("Mandarine", 2.8, "kg", 6, firstOFJanuaryTwoThousandsAndTwentyFive, 14);
        Fruit orange = new Fruit("Orange", 1.5, "kg", 8, firstOFJanuaryTwoThousandsAndTwentyFive, 21);
        Fruit grapefruit = new Fruit("Pamplemousse", 2, "pcs", 8, firstOFJanuaryTwoThousandsAndTwentyFive, 21);
        Fruit pear = new Fruit("Poire", 2.5, "kg", 5, firstOFJanuaryTwoThousandsAndTwentyFive, 14);
        Fruit apple = new Fruit("Pomme", 1.5, "kg", 8, firstOFJanuaryTwoThousandsAndTwentyFive, 60);

        Vegetable carrot = new Vegetable("Carotte", 1.3, "kg", 7, firstOFJanuaryTwoThousandsAndTwentyFive, 30);
        Vegetable brusselsSprouts = new Vegetable("Choux de bruxelles", 4, "kg", 4, firstOFJanuaryTwoThousandsAndTwentyFive, 7);
        Vegetable greenCabbage = new Vegetable("Chou vert", 2.5, "pcs", 12, firstOFJanuaryTwoThousandsAndTwentyFive, 14);
        Vegetable butternutSquash = new Vegetable("Courge butternut", 2.5, "pcs", 6, firstOFJanuaryTwoThousandsAndTwentyFive, 90);
        Vegetable endive = new Vegetable("Endive", 2.5, "kg", 5, firstOFJanuaryTwoThousandsAndTwentyFive, 14);
        Vegetable spinach = new Vegetable("Épinard", 2.6, "kg", 4, firstOFJanuaryTwoThousandsAndTwentyFive, 10);
        Vegetable leek = new Vegetable("Poireau", 1.2, "kg", 5, firstOFJanuaryTwoThousandsAndTwentyFive, 14);
        Vegetable pumpkin = new Vegetable("Potiron", 2.5, "pcs", 6, firstOFJanuaryTwoThousandsAndTwentyFive, 90);
        Vegetable blackRadish = new Vegetable("Radis noir", 5, "pcs", 10, firstOFJanuaryTwoThousandsAndTwentyFive, 30);
        Vegetable salsify = new Vegetable("Salsifis", 2.5, "kg", 3, firstOFJanuaryTwoThousandsAndTwentyFive, 7);

        myProducts = new ArrayList<>();
        myProducts.add(clementine);
        myProducts.add(date);
        myProducts.add(grenade);
        myProducts.add(persimmon);
        myProducts.add(kiwi);
        myProducts.add(mandarinOrange);
        myProducts.add(orange);
        myProducts.add(grapefruit);
        myProducts.add(pear);
        myProducts.add(apple);

        myProducts.add(carrot);
        myProducts.add(brusselsSprouts);
        myProducts.add(greenCabbage);
        myProducts.add(butternutSquash);
        myProducts.add(endive);
        myProducts.add(spinach);
        myProducts.add(leek);
        myProducts.add(pumpkin);
        myProducts.add(blackRadish);
        myProducts.add(salsify);
    }

    /**
     * Get the number of Product in the shop
     *
     * @return
     */
    public int sizeShop() {
        return myProducts.size();
    }

    /**
     * Return the product in the shop
     *
     * @param index
     * @return
     */
    public Product getItemShop(int index) {
        return myProducts.get(index);
    }

    /**
     * Update the shop after a day
     *
     * @param currentDate
     * @param random
     */
    public void updateShop(LocalDate currentDate, Random random) {
        ArrayList<Product> expiredProduct = new ArrayList<>();
        ArrayList<Product> deliveredProduct = new ArrayList<>();
        for (Product product : myProducts) {
            if (product.getStockQuantity().compareTo(BigDecimal.ONE) < 0) {
                deliveredProduct.add(product);
            } else {
                if (product.isExpired(currentDate)) {
                    expiredProduct.add(product);
                }
            }
        }
        if (!expiredProduct.isEmpty()) {
            for (Product expire : expiredProduct) {
                DailyRecap.getCurrentRecap().addToLost(expire, expire.getStockQuantity());
                expire.setStockQuantity(BigDecimal.valueOf(0));
            }
        }
        if (!deliveredProduct.isEmpty()) {
            for (Product product : deliveredProduct) {
                int randomQuantity = random.nextInt(10) + 1;
                product.setStockQuantity(BigDecimal.valueOf(randomQuantity));
                DailyRecap.getCurrentRecap().addToDelivery(product, BigDecimal.valueOf(randomQuantity));
                product.setPickingDate(currentDate);
            }
        }
    }

    public ArrayList<Fruit> getAllFruits() {
        ArrayList<Fruit> maListe = new ArrayList<>();
        for(Product product : myProducts){
            if(product instanceof Fruit){
                maListe.add((Fruit) product);
            }
        }
        return maListe;
    }

    public ArrayList<Vegetable> getAllVegetables() {
        ArrayList<Vegetable> maListe = new ArrayList<>();
        for(Product product : myProducts){
            if(product instanceof Vegetable){
                maListe.add((Vegetable) product);
            }
        }
        return maListe;
    }

    public String toString(LocalDate currentDate) {
        Table displayShopTable = new Table();
        displayShopTable.addLine("ID", "Fruit", "Stock", "Prix", "Périme dans (J)", "ID", "Légumes", "Stock", "Prix", "Périme dans (J)");
        ArrayList<Fruit> myFruits = getAllFruits();
        ArrayList<Vegetable> myVegetables = getAllVegetables();
        for(int i = 0; i < Math.max(myFruits.size(), myVegetables.size()); i++){
            String[] result = new String[10];
            if(i < myFruits.size()){
                result[0] = String.valueOf(i+1);
                result[1] = myFruits.get(i).getName();
                result[2] = myFruits.get(i).stockFormat();
                result[3] = myFruits.get(i).priceFormat();
                result[4] = myFruits.get(i).daysRemainingBeforeExpiration(currentDate) + " Jours";
            }
            else {
                result[0] = "";
                result[1] = "";
                result[2] = "";
                result[3] = "";
                result[4] = "";
            }
            if(i < myVegetables.size()) {
                result[5] = String.valueOf(i+myFruits.size()+1);
                result[6] = myVegetables.get(i).getName();
                result[7] = myVegetables.get(i).stockFormat();
                result[8] = myVegetables.get(i).priceFormat();
                result[9] = myVegetables.get(i).daysRemainingBeforeExpiration(currentDate) + " Jours";
            }
            else {
                result[5] = "";
                result[6] = "";
                result[7] = "";
                result[8] = "";
                result[9] = "";
            }
            displayShopTable.addLine(result);
        }
        return displayShopTable.toString();
    }
}
