import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /**
     * Function that return a double between min and max that have been input by user
     *
     * @param scanner
     * @param message
     * @param min
     * @param max
     * @return
     */
    public static Double inputDoubleBetween(Scanner scanner, String message, double min, double max) {
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
    public static Integer inputIntegerBetween(Scanner scanner, String message, int min, int max) {
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

    public static void placeACustomerOrder(Scanner scanner, Shop shop, LocalDate currentDate) {
        Client client = Client.registerClient(scanner);
        if (client == null) {
            return;
        }
        boolean isLookingAtShop = true;
        while (isLookingAtShop) {
            System.out.println(shop.toString(currentDate));
            System.out.println(client);
            Integer indexShop = inputIntegerBetween(scanner, "Quel article souhaitez vous ajoutez (l'index)", 1, shop.sizeShop());
            if (indexShop == null) {
                isLookingAtShop = false;
            } else {
                Product selectedProduct = shop.getItemShop(indexShop - 1);
                System.out.println(selectedProduct);
                Double quantity = inputDoubleBetween(scanner, "Entrez la quantité souhaitez", 0, selectedProduct.getStockQuantity());
                client.addToBasket(selectedProduct, quantity);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();
        LocalDate currentDate = LocalDate.of(2025, Month.JANUARY, 1);
        boolean ongoing = true;
        while (ongoing) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.FRANCE);
            System.out.println("Nous sommes le " + currentDate.format(dateFormat));
            System.out.println("1- Passez une commande client");
            System.out.println("2- Passez a la prochaine journée");
            Integer userChoice = inputIntegerBetween(scanner, "Entrez ce que vous souhaitez faire", 1, 2);
            if (userChoice != null) {
                switch (userChoice) {
                    case 1:
                        placeACustomerOrder(scanner, shop, currentDate);
                        break;
                    case 2:
                        currentDate = passNextDate(currentDate);
                        break;
                    default:
                        break;
                }
            } else {
                ongoing = false;
            }
        }
    }

    private static LocalDate passNextDate(LocalDate currentDate) {
        System.out.println("Passage a la prochaine Journee");
        currentDate = currentDate.plusDays(1);
        return currentDate;
    }
}