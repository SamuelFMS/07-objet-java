package fr.fms.entities;

public class Person {
    private final String lastName;
    private final String firstName;
    private int age;
    private String address;
    private City bornCity;

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

    public Double remuneration() {
        return null;
    }

    public boolean checkIfAddressContain(String address) {
        return this.address.contains(address);
    }

    public boolean checkIfBornInCountry(String country){
        return this.bornCity.getCountry().equals(country);
    }

    public String getAddressWithAccronym(){
        if(address == null){
            return "unknown";
        }
        if(address.equalsIgnoreCase("palo alto")){
            return "à " + address;
        }
        return "aux " + address;
    }

    public void display(){
        System.out.print(lastName + ", " + firstName + ", "+ age + "ans, habitant " + address + ", ");
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

