import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    /**
     * List of all the clients
     */
    protected static ArrayList<Client> listClient = new ArrayList<>();
    /**
     * Last name of the client
     */
    private final String lastName;
    /**
     * First name of the client
     */
    private final String firstName;
    /**
     * Basket of the client
     */
    private final Basket myBasket;

    /*
        Constructor
     */
    private Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        myBasket = new Basket();
        listClient.add(this);
    }

    /*
        Public Method
     */

    /**
     * return the client if it exist by is name or return null if didnt find
     * @param firstName
     * @param lastName
     * @return
     */
    public static Client tryFindClient(String firstName, String lastName) {
        for (Client client : listClient) {
            if (client.firstName.equals(firstName) && client.lastName.equals(lastName)) {
                return client;
            }
        }
        return null;
    }

    /**
     * Get a Client and if it doesn't exist creates it
     * @param scanner
     * @return
     */
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

    /**
     * Add a product to the basket with their quantity
     * @param product
     * @param quantity
     */
    public void addToBasket(Product product, double quantity) {
        myBasket.addToBasket(product, quantity);
        product.setStockQuantity(product.getStockQuantity() - quantity);
    }

    @Override
    public String toString() {
        return "VOTRE PANIER ACTUEL\n" +
                myBasket;
    }
}
