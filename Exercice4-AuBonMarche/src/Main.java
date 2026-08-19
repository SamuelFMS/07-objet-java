import java.math.BigDecimal;
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
                if(selectedProduct.getStockQuantity().equals(BigDecimal.ZERO)){
                    System.out.println("Le produit ["+selectedProduct.getName()+"] est épuisé (Stock : 0.0 kg). Veuillez choisir un autre article.");
                }
                else {
                    System.out.println(selectedProduct);
                    BigDecimal quantity = InputUser.inputBigDecimalBetween(scanner, "Entrez la quantité souhaitez", BigDecimal.valueOf(0), selectedProduct.getStockQuantity(),2);
                    client.addToBasket(selectedProduct, quantity);
                    DailyRecap.getCurrentRecap().addToGain(selectedProduct, quantity);
                }
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();
        LocalDate currentDate = LocalDate.of(2025, Month.JANUARY, 1);
        new DailyRecap(currentDate);
        boolean ongoing = true;
        while (ongoing) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.FRANCE);
            System.out.println("Nous sommes le " + currentDate.format(dateFormat));
            System.out.println("1- Passez une commande client");
            System.out.println("2- Passez a la prochaine journée");
            System.out.println("3- Voir le bilan d'une journée");
            Integer userChoice = InputUser.inputIntegerBetween(scanner, "Entrez ce que vous souhaitez faire", 1, 3);
            if (userChoice != null) {
                switch (userChoice) {
                    case 1:
                        placeACustomerOrder(scanner, shop, currentDate);
                        break;
                    case 2:
                        currentDate = passNextDate(currentDate, shop, random);
                        break;
                    case 3:
                        DailyRecap.searchDailyRecapAndPrint(InputUser.inputDate(scanner, "Entrez une date pour voir son recape ex: (01-01-2025)"));
                        break;
                    default:
                        break;
                }
            } else {
                ongoing = false;
            }
        }
        scanner.close();
    }

    private static LocalDate passNextDate(LocalDate currentDate, Shop shop, Random random) {
        System.out.println("Passage a la prochaine Journee");
        currentDate = currentDate.plusDays(1);
        shop.updateShop(currentDate, random);
        DailyRecap.getCurrentRecap().displayCustomerSummaryOfTheDay();
        new DailyRecap(currentDate);
        return currentDate;
    }
}