import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    protected static ArrayList<Client> listClient = new ArrayList<>();
    private final String lastName;
    private final String firstName;
    private final Basket myBasket;

    private Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        myBasket = new Basket();
        listClient.add(this);
    }

    public static Client tryFindClient(String firstName, String lastName) {
        for (Client client : listClient) {
            if (client.firstName.equals(firstName) && client.lastName.equals(lastName)) {
                return client;
            }
        }
        return null;
    }

    public static Client registerClient(Scanner scanner) {
        boolean firstNameEmpty = true;
        String firstName = "";
        while (firstNameEmpty) {
            System.out.println("Veuillez entrez le prenom?");
            firstName = scanner.next();
            if (firstName.equalsIgnoreCase("q")) {
                return null;
            }
            if (!firstName.isEmpty()) {
                firstNameEmpty = false;
            }
        }

        boolean lastNameEmpty = true;
        String lastName = "";
        while (lastNameEmpty) {
            System.out.println("Veuillez entrez le nom?");
            lastName = scanner.next();
            if (lastName.equalsIgnoreCase("q")) {
                return null;
            }
            if (!lastName.isEmpty()) {
                lastNameEmpty = false;
            }
        }

        Client clientAlreadyExist = tryFindClient(firstName, lastName);
        if (clientAlreadyExist == null) {
            System.out.println("Creation d'un nouveau client");
            return new Client(firstName, lastName);
        } else {
            System.out.println("Ce client existe déjà");
            return clientAlreadyExist;
        }
    }

    public void addToBasket(Product product, double quantity) {
        myBasket.addToBasket(product, quantity);
    }

    @Override
    public String toString() {
        String res = "Le panier de " + firstName +
                " " + lastName + "\n----------------\n" +
                myBasket;
        return res;
    }
}
