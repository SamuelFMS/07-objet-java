import java.time.LocalDate;

public final class DailyRecap {
    private static LocalDate currentDate;
    private static double numberSales;
    private static double numberLost;

    public static void initDay(LocalDate currentDate){
        DailyRecap.currentDate = currentDate;
        numberSales = 0;
        numberLost = 0;
    }

    public static void displayCustomerSummaryOfTheDay() {
        System.out.println("____________________________________________________");
        System.out.println("|                                                  |");
        System.out.println("|  RECAPITULATIF JOURNALIER : CHIFFRE D'AFFAIRES   |");
        System.out.println("|__________________________________________________|");
        System.out.println("|                                                  |");
        System.out.println("|  "+ FormatOrTruncate.padOrTruncate(("Date : " + currentDate), 47) + " |");
        System.out.println("|                                                  |");
        System.out.println("|  " + FormatOrTruncate.padOrTruncate("Ventes Brutes : " + numberSales,47) + " |");
        System.out.println("|  " + FormatOrTruncate.padOrTruncate("Pertes (Fruits expirés) : " + (0-numberLost),47) + " |");
        System.out.println("|                                                  |");
        System.out.println("|  " + FormatOrTruncate.padOrTruncate("Chiffre d'affaires net: "+ (numberSales - numberLost) ,47) + " |");
        System.out.println("|__________________________________________________|");
    }

    /*
        Setter
     */

    public static void setCurrentDate(LocalDate currentDate) {
        DailyRecap.currentDate = currentDate;
    }

    public static void setNumberSales(double numberSales) {
        DailyRecap.numberSales = numberSales;
    }

    public static void setNumberLost(double numberLost) {
        DailyRecap.numberLost = numberLost;
    }
}
