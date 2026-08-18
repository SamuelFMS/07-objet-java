package fr.fms.entities;

public class Person {
    /**
     * Last Name of the person
     */
    private final String lastName;
    /**
     * First name of the person
     */
    private final String firstName;
    /**
     * How old is the person
     */
    private int age;
    /**
     * Address of the Person
     */
    private String address;
    /**
     * The city of the Person
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

    /**
     * remuneration of the person doesnt have a salary so null
     *
     * @return
     */
    public Double remuneration() {
        return null;
    }

    /**
     * Check if thewordToCheck is in address
     *
     * @param wordToCheck
     * @return
     */
    public boolean checkIfAddressContain(String wordToCheck) {
        return this.address.contains(wordToCheck);
    }

    /**
     * Check if the Person in born in the country
     *
     * @param country
     * @return
     */
    public boolean checkIfBornInCountry(String country) {
        return this.bornCity.getCountry().equals(country);
    }

    /**
     * Give the address with the accronym
     *
     * @return
     */
    public String getAddressWithAccronym() {
        if (address == null) {
            return "unknown";
        }
        if (address.equalsIgnoreCase("palo alto")) {
            return "à " + address;
        }
        return "aux " + address;
    }

    /**
     * Other way to display
     */
    public void display() {
        System.out.print(lastName + ", " + firstName + ", " + age + "ans, habitant " + address + ", ");
        bornCity.display();
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + ", " + age + " ans" + ", habitant " + getAddressWithAccronym() + ", Ville de naissance: " + bornCity;
    }

    /*
        Getter and Setter
     */

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getBornCity() {
        return bornCity;
    }

    public void setBornCity(City bornCity) {
        this.bornCity = bornCity;
    }
}

