package fr.fms.entities;

public class Employee extends Person {
    public static final double minimumSalary = 1;
    private String companyName;
    private double salary;

    public Employee(String lastName, String firstName, int age, String address, City bornCity, String companyName, double salary) {
        super(lastName, firstName, age, address, bornCity);
        this.companyName = companyName;
        this.setSalary(salary);
    }

    public Employee(String lastName, String firstName, int age, String address, String companyName, double salary) {
        super(lastName, firstName, age, address);
        this.companyName = companyName;
        this.setSalary(salary);
    }

    public Employee(String lastName, String firstName, int age, String companyName, double salary) {
        super(lastName, firstName, age);
        this.companyName = companyName;
        this.setSalary(salary);
    }

    public Employee(String lastName, String firstName, String companyName, double salary) {
        super(lastName, firstName);
        this.companyName = companyName;
        this.setSalary(salary);
    }

    public void setSalary(double salary){
        if(salary < minimumSalary){
            System.out.println("Salaire inferieur à " + minimumSalary + " impossible");
        }
        this.salary = Math.max(salary, minimumSalary);
    }

    @Override
    public String toString() {
        return super.toString() + ", Entreprise : " + companyName + ", Salaire: " + salary;
    }
}
