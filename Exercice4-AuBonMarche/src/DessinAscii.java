public interface DessinAscii {
    static void displayTruck(Basket deliveryBasket){


        System.out.println("|   ___________________________________            |");
        System.out.println("|  |           LIVRAISON               |           |");
        int number = 0;
        for(ProductBasket productBasket : deliveryBasket.getMyBasket()) {
            if(number != deliveryBasket.getMyBasket().size()-1){
                System.out.println("|  |  "+TextFormatter.formatSize(productBasket.getProduct().getName() + " ->  " + productBasket.stockFormat(),33)+"|           |");
            } else {
                System.out.println("|  |  "+TextFormatter.formatSize(productBasket.getProduct().getName() + " ->  " + productBasket.stockFormat(),33)+"| ___       |");
            }
            number++;
        }
        System.out.println("|  |                                   | |  \\      |");
        System.out.println("|  |___________________________________|_|___\\     |");
        System.out.println("|  `---(o)(o)-----------------------------(o)-     |");
    }
}
