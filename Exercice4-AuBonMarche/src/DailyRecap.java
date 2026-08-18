import java.time.LocalDate;

public final class DailyRecap {
    /**
     * Date of the recap
     */
    private static LocalDate currentDate;
    /**
     * All the sales of the day
     */
    private static Basket sales;
    /**
     * All the lost of the day
     */
    private static Basket lost;
    /**
     * All the delivery of the day
     */
    private static Basket delivery;

    /*
        Public Method
     */

    /**
     * Init a day to start over a brand new day
     *
     * @param currentDate
     */
    public static void initDay(LocalDate currentDate) {
        DailyRecap.currentDate = currentDate;
        sales = new Basket();
        lost = new Basket();
        delivery = new Basket();
    }

    /**
     * Display the summary of the day
     */
    public static void displayCustomerSummaryOfTheDay() {
        System.out.println("____________________________________________________");
        System.out.println("|                                                  |");
        System.out.println("|  RECAPITULATIF JOURNALIER : CHIFFRE D'AFFAIRES   |");
        System.out.println("|__________________________________________________|");
        System.out.println("|  " + TextFormatter.formatSize(("Date : " + currentDate), 47) + " |");
        System.out.println("|__________________________________________________|");

        if (!delivery.getMyBasket().isEmpty()) {
            DessinAscii.displayTruck(delivery);
            System.out.println("|__________________________________________________|");
        } else {
            System.out.println("|                                                  |");
        }

        System.out.println("|  " + TextFormatter.formatSize("Ventes Brutes : " + sales.getPriceTotalBasket() + " €", 47) + " |");
        for (ProductBasket salesProduct : sales.getMyBasket()) {
            System.out.println("|  " + TextFormatter.formatSize("• [" + salesProduct.getProduct().getName() + "]  ->  " + salesProduct.getQuantity() * salesProduct.getProduct().realPrice() + " €", 47) + " |");
        }
        System.out.println("|  " + TextFormatter.formatSize("Pertes (Fruits expirés) : " + (0 - lost.getPriceTotalBasket()) + " €", 47) + " |");
        for (ProductBasket lostProduct : lost.getMyBasket()) {
            System.out.println("|  " + TextFormatter.formatSize("• [" + lostProduct.getProduct().getName() + "]  ->  -" + lostProduct.getQuantity() * lostProduct.getProduct().realPrice() + " €", 47) + " |");
        }
        System.out.println("|                                                  |");
        System.out.println("|  " + TextFormatter.formatSize("Chiffre d'affaires net: " + (sales.getPriceTotalBasket() - lost.getPriceTotalBasket()) + " €", 47) + " |");
        System.out.println("|__________________________________________________|");
    }

    /*
        Setter
     */
    public static void addToLost(Product product, double quantity) {
        lost.addToBasket(product, quantity);
    }

    public static void addToGain(Product product, double quantity) {
        sales.addToBasket(product, quantity);
    }

    public static void addToDelivery(Product product, double quantity) {
        delivery.addToBasket(product, quantity);
    }

    public static void setCurrentDate(LocalDate currentDate) {
        DailyRecap.currentDate = currentDate;
    }
}
