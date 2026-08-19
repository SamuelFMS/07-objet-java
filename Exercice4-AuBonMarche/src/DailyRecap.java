import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class DailyRecap {

    private static DailyRecap currentRecap;

    private static ArrayList<DailyRecap> listOfAllRecap = new ArrayList<>();
    /**
     * Date of the recap
     */
    private final LocalDate currentDate;
    /**
     * All the sales of the day
     */
    private Basket sales;
    /**
     * All the lost of the day
     */
    private Basket lost;
    /**
     * All the delivery of the day
     */
    private Basket delivery;

    /*
        Public Method
     */
    public DailyRecap(LocalDate currentDate){
        this.currentDate = currentDate;
        currentRecap = this;
        sales = new Basket();
        lost = new Basket();
        delivery = new Basket();
        listOfAllRecap.add(this);
    }

    /**
     * Display the summary of the day
     */
    public void displayCustomerSummaryOfTheDay() {
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
            System.out.println("|  " + TextFormatter.formatSize("• [" + salesProduct.getProduct().getName() + "]  ->  " + salesProduct.getPrice()  + " €", 47) + " |");
        }
        System.out.println("|  " + TextFormatter.formatSize("Pertes (Fruits expirés) : " + (BigDecimal.ZERO.subtract(lost.getPriceTotalBasket())) + " €", 47) + " |");
        for (ProductBasket lostProduct : lost.getMyBasket()) {
            System.out.println("|  " + TextFormatter.formatSize("• [" + lostProduct.getProduct().getName() + "]  ->  -" + lostProduct.getPrice() + " €", 47) + " |");
        }
        System.out.println("|                                                  |");
        System.out.println("|  " + TextFormatter.formatSize("Chiffre d'affaires net: " + (sales.getPriceTotalBasket().subtract(lost.getPriceTotalBasket())) + " €", 47) + " |");
        System.out.println("|__________________________________________________|");
    }

    public static void searchDailyRecapAndPrint(LocalDate date) {
        boolean trouver = false;
        for (DailyRecap dailyRecap : DailyRecap.listOfAllRecap) {
            if(dailyRecap.currentDate.equals(date)) {
                dailyRecap.displayCustomerSummaryOfTheDay();
                trouver = true;
            }
        }
        if(!trouver) {
            System.out.println("Nous n'avons pas trouver le recap pour ce jour");
        }
    }

    /*
        Setter
     */
    public void addToLost(Product product, BigDecimal quantity) {
        lost.addToBasket(product, quantity);
    }

    public void addToGain(Product product, BigDecimal quantity) {
        sales.addToBasket(product, quantity);
    }

    public void addToDelivery(Product product, BigDecimal quantity) {
        delivery.addToBasket(product, quantity);
    }

    public static DailyRecap getCurrentRecap() {
        return currentRecap;
    }
}
