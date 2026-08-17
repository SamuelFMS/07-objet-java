package fr.fms.entities;

public class Commercial extends Person {
    private String companyName;
    private double remuneration;

    public Commercial(String lastName, String firstName, int age, String address, City bornCity, String companyName, double remuneration) {
        super(lastName, firstName, age, address, bornCity);
        this.companyName = companyName;
        this.remuneration = remuneration;
    }
}
