import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Shop {
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

    public int sizeShop() {
        return myProducts.size();
    }

    public Product getItemShop(int index) {
        return myProducts.get(index);
    }

    public String toString(LocalDate currentDate) {
        StringBuilder res = new StringBuilder();
        res.append("Index | ").append("Fruit / Légume | ").append("Stock | ").append("Prix(au kg ou a l'unité) | ").append("Nombre de jours restants avant péremption").append("\n");
        int index = 1;
        for (Product product : myProducts) {
            res.append(index).append(" | ").append(product.toString(currentDate)).append("\n");
            index++;
        }
        return res.toString();
    }

    public void updateShop(LocalDate currentDate, Random random) {
        ArrayList<Product> expiredProduct = new ArrayList<>();
        ArrayList<Product> deliveredProduct = new ArrayList<>();
        for(Product product : myProducts){
            if(product.getStockQuantity() < 1) {
                deliveredProduct.add(product);
            }
            else {
                if(product.isExpired(currentDate)) {
                    expiredProduct.add(product);
                }
            }
        }
        if(!expiredProduct.isEmpty()) {
            DessinAscii.displayBin();
            for (Product expire : expiredProduct){
                DailyRecap.addToLost(expire, expire.getStockQuantity());
                expire.setStockQuantity(0);
                System.out.println(expire.getName() + " a expiré");
            }
        }
        if(!deliveredProduct.isEmpty()) {
            DessinAscii.displayTruck();
            for (Product product: deliveredProduct){
                System.out.println(product.getName() + " a été livré");
                product.setStockQuantity(random.nextInt(10)+1);
                product.setPickingDate(currentDate);
            }
        }
    }
}
