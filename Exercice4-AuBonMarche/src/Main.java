import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void placeACustomerOrder(Scanner scanner, Shop shop, LocalDate currentDate) {
        Client client = Client.registerClient(scanner);
        if (client == null) {
            return;
        }
        boolean isLookingAtShop = true;
        while (isLookingAtShop) {
            System.out.println(shop.toString(currentDate));
            System.out.println(client);
            Integer indexShop = InputUser.inputIntegerBetween(scanner, "Quel article souhaitez vous ajoutez (l'index)", 1, shop.sizeShop());
            if (indexShop == null) {
                isLookingAtShop = false;
            } else {
                Product selectedProduct = shop.getItemShop(indexShop - 1);
                System.out.println(selectedProduct);
                Double quantity = InputUser.inputDoubleBetween(scanner, "Entrez la quantité souhaitez", 0, selectedProduct.getStockQuantity());
                client.addToBasket(selectedProduct, quantity);
                DailyRecap.addToGain(selectedProduct, quantity);
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();
        LocalDate currentDate = LocalDate.of(2025, Month.JANUARY, 1);
        DailyRecap.initDay(currentDate);
        boolean ongoing = true;
        while (ongoing) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.FRANCE);
            System.out.println("Nous sommes le " + currentDate.format(dateFormat));
            System.out.println("1- Passez une commande client");
            System.out.println("2- Passez a la prochaine journée");
            Integer userChoice = InputUser.inputIntegerBetween(scanner, "Entrez ce que vous souhaitez faire", 1, 2);
            if (userChoice != null) {
                switch (userChoice) {
                    case 1:
                        placeACustomerOrder(scanner, shop, currentDate);
                        break;
                    case 2:
                        currentDate = passNextDate(currentDate, shop, random);
                        break;
                    default:
                        break;
                }
            } else {
                ongoing = false;
            }
        }
    }

    private static LocalDate passNextDate(LocalDate currentDate, Shop shop, Random random) {
        System.out.println("Passage a la prochaine Journee");
        currentDate = currentDate.plusDays(1);
        shop.updateShop(currentDate, random);
        DailyRecap.displayCustomerSummaryOfTheDay();
        DailyRecap.initDay(currentDate);
        return currentDate;
    }
}