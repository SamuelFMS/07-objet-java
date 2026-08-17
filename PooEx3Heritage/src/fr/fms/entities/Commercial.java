package fr.fms.entities;

public class Commercial extends Person {
    public static final double minimumRemuneration = 0.01;
    public static final double averageTurnover = 50000;
    private String companyName;
    private double remuneration;

    public Commercial(String lastName, String firstName, int age, String address, City bornCity, String companyName, double remuneration) {
        super(lastName, firstName, age, address, bornCity);
        this.companyName = companyName;
        this.setRemuneration(remuneration);
    }

    @Override
    public Double remuneration(){
        return averageTurnover * remuneration / 100;
    }

    public void setRemuneration(double remuneration){
        if(remuneration < minimumRemuneration){
            System.out.println("% du chiffre d'affaire inférieur à " + minimumRemuneration + " impossible");
        }
        this.remuneration = Math.max(remuneration, minimumRemuneration);
    }

    public String toString() {
        return super.toString() + ", Entreprise : " + companyName + ", % CA : " + remuneration;
    }
}
