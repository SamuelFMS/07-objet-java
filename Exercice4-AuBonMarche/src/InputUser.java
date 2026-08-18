import java.util.Scanner;

public interface InputUser {
    /**
     * Function that return a double between min and max that have been input by user
     *
     * @param scanner
     * @param message
     * @param min
     * @param max
     * @return
     */
    static Double inputDoubleBetween(Scanner scanner, String message, double min, double max) {
        Double res = null;
        while (res == null) {
            System.out.println(message);
            String stringInput = scanner.next();
            if (stringInput.equals("q")) {
                return null;
            }
            try {
                res = Double.valueOf(stringInput);
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
}
