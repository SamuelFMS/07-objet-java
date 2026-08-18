public class Person {
    /**
     * Last name of the Person
     */
    private final String lastName;
    /**
     * First name of the Person
     */
    private final String firstName;
    /**
     * Age pf the person
     */
    private int age;
    /**
     * Address of the person
     */
    private String address;
    /**
     * City of the person
     */
    private City bornCity;

    /*
        Constructor
     */
    public Person(String lastName, String firstName, int age, String address, City bornCity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.bornCity = bornCity;
    }

    public Person(String lastName, String firstName, int age, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    public Person(String lastName, String firstName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String lastName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /*
        Public method
     */

    /**
     * Check if an address contain the word wordToCheck in address
     *
     * @param wordToCheck
     * @return
     */
    public boolean checkIfAddressContain(String wordToCheck) {
        return this.address.contains(wordToCheck);
    }

    /**
     * Check if the country is the country in param
     *
     * @param country
     * @return
     */
    public boolean checkIfBornInCountry(String country) {
        return this.bornCity.getCountry().equals(country);
    }

    /**
     * Another way to display the Person
     */
    public void display() {
        System.out.print(lastName + ", " + firstName + ", " + age + "ans, habitant " + address + ", ");
        bornCity.display();
    }

    @Override
    public String toString() {
        return "[lastName=" + lastName + ", firstName=" + firstName + ", age=" + age + ", address=" + (address == null ? "unknown" : address) + ", Ville=" + bornCity + "]";
    }
}
