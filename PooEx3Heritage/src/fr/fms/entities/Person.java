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

    public boolean checkIfAddressContain(String address) {
        return this.address.contains(address);
    }

    public boolean checkIfBornInCountry(String country){
        return this.bornCity.getCountry().equals(country);
    }

    public void display(){
        System.out.print(lastName + ", " + firstName + ", "+ age + "ans, habitant " + address + ", ");
        bornCity.display();
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + ", " + age + " ans" + ", habitant " + (address==null?"unknown":address) + ", Ville de naissance: " + bornCity;
    }
}

