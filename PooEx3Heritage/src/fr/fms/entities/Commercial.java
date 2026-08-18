package fr.fms.entities;

public class Commercial extends Person {
    /**
     * minimum remuneration valid
     */
    public static final double minimumRemuneration = 0.01;
    /**
     * average number of the company making
     */
    public static final double averageTurnover = 50000;
    /**
     * Name of the company working for
     */
    private final String companyName;
    /**
     * % of the company turnover
     */
    private double remuneration;

    /*
        Constructor
     */
    public Commercial(String lastName, String firstName, int age, String address, City bornCity, String companyName, double remuneration) {
        super(lastName, firstName, age, address, bornCity);
        this.companyName = companyName;
        this.setRemuneration(remuneration);
    }

    /*
        Public method
     */

    /**
     * math of the remuneration
     *
     * @return
     */
    @Override
    public Double remuneration() {
        return averageTurnover * remuneration / 100;
    }

    /*
        Getter and Setter
     */
    public void setRemuneration(double remuneration) {
        if (remuneration < minimumRemuneration) {
            System.out.println("% du chiffre d'affaire inférieur à " + minimumRemuneration + " impossible");
        }
        this.remuneration = Math.max(remuneration, minimumRemuneration);
    }

    public String toString() {
        return super.toString() + ", Entreprise : " + companyName + ", % CA : " + remuneration;
    }
}
