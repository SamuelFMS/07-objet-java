import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public interface InputUser {
    /**
     * Function that return a double between min and max that have been input by user
     *
     * @param scanner
     * @param message
     * @param min
     * @param max
     * @param round
     * @return
     */
    static BigDecimal inputBigDecimalBetween(Scanner scanner, String message, BigDecimal min, BigDecimal max, int round) {
        BigDecimal res = null;
        while (res == null) {
            System.out.println(message);
            String stringInput = scanner.next();
            if (stringInput.equalsIgnoreCase("q")) {
                return null;
            }
            try {
                res = new BigDecimal(stringInput);
                res = res.setScale(round, RoundingMode.HALF_UP);
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrez un nombre valide");
                res = null; // Sécurité si l'exception lève après une assignation partielle
                continue;
            }
            if (res.compareTo(min) < 0 || res.compareTo(max) > 0) {
                System.out.println("Veuillez entrez un nombre entre " + min + " et " + max);
                res = null;
            }
        }
        return res;
    }

    /**
     * Function that return a int between min and max that have been input by user
     *
     * @param scanner
     * @param message
     * @param min
     * @param max
     * @return
     */
    static Integer inputIntegerBetween(Scanner scanner, String message, int min, int max) {
        Integer res = null;
        while (res == null) {
            System.out.println(message);
            String stringInput = scanner.next();
            if (stringInput.equals("q")) {
                return null;
            }
            try {
                res = Integer.valueOf(stringInput);
            } catch (Exception e) {
                System.out.println("Veuillez entrez un nombre valide");
            }
            if (res != null) {
                if (res < min || res > max) {
                    res = null;
                    System.out.println("Veuillez entrez un nombre entre " + min + " et " + max);
                }
            }
        }
        return res;
    }

    static LocalDate inputDate(Scanner scanner, String message) {
        LocalDate inputDateTime =  null;
        while (inputDateTime == null){
            System.out.println(message);
            String inputString = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                inputDateTime = LocalDate.parse(inputString, formatter);
            } catch (Exception e) {
                System.out.println("Veuillez entre une date (jj-mm-aaaa)");
            }
        }
        return inputDateTime;
    }
}
