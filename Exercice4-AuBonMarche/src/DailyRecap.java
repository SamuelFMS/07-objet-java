import java.time.LocalDate;

public final class DailyRecap {
    private static LocalDate currentDate;
    private static Basket sales;
    private static Basket lost;
    private static Basket delivery;

    public static void initDay(LocalDate currentDate){
        DailyRecap.currentDate = currentDate;
        sales = new Basket();
        lost = new Basket();
        delivery = new Basket();
    }

    public static void displayCustomerSummaryOfTheDay() {
        System.out.println("____________________________________________________");
        System.out.println("|                                                  |");
        System.out.println("|  RECAPITULATIF JOURNALIER : CHIFFRE D'AFFAIRES   |");
        System.out.println("|__________________________________________________|");
        System.out.println("|  "+ TextFormatter.formatSize(("Date : " + currentDate), 47) + " |");
        System.out.println("|__________________________________________________|");

        if(!delivery.getMyBasket().isEmpty()){
            DessinAscii.displayTruck(delivery);
            System.out.println("|__________________________________________________|");
        } else {
            System.out.println("|                                                  |");
        }

        System.out.println("|  " + TextFormatter.formatSize("Ventes Brutes : " + sales.getPriceTotalBasket() + " €",47) + " |");
        for(ProductBasket salesProduct : sales.getMyBasket()) {
            System.out.println("|  " + TextFormatter.formatSize("• ["+salesProduct.getProduct().getName()+"]  ->  "+salesProduct.getQuantity()*salesProduct.getProduct().realPrice()+" €",47) + " |");
        }
        System.out.println("|  " + TextFormatter.formatSize("Pertes (Fruits expirés) : " + (0-lost.getPriceTotalBasket()) + " €",47) + " |");
        for(ProductBasket lostProduct : lost.getMyBasket()) {
            System.out.println("|  " + TextFormatter.formatSize("• ["+lostProduct.getProduct().getName()+"]  ->  -"+lostProduct.getQuantity()*lostProduct.getProduct().realPrice()+" €",47) + " |");
        }
        System.out.println("|                                                  |");
        System.out.println("|  " + TextFormatter.formatSize("Chiffre d'affaires net: "+ (sales.getPriceTotalBasket() - lost.getPriceTotalBasket())+ " €" ,47) + " |");
        System.out.println("|__________________________________________________|");
    }

    public static void addToLost(Product product, double quantity) {
        lost.addToBasket(product, quantity);
    }

    public static void addToGain(Product product, double quantity) {
        sales.addToBasket(product, quantity);
    }

    public static void addToDelivery(Product product, double quantity) {
        delivery.addToBasket(product, quantity);
    }

    /*
        Setter
     */
    public static void setCurrentDate(LocalDate currentDate) {
        DailyRecap.currentDate = currentDate;
    }
}
