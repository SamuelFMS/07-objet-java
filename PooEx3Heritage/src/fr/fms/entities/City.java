package fr.fms.entities;

public class City {
    public static int nbInstances = 0;
    private String cityName;
    private String country;
    private int nbInhabitant;

    public City(String cityName, String country, int nbInhabitant) {
        this.cityName = cityName;
        this.country = country;
        setNbInhabitant(nbInhabitant);
        nbInstances++;
    }

    public City(String cityName, String country) {
        this.cityName = cityName;
        this.country = country;
        nbInstances++;
    }

    public City(String cityName, int nbInhabitant){
        this.cityName = cityName;
        setNbInhabitant(nbInhabitant);
        nbInstances++;
    }

    @Override
    public String toString() {
        //return "[ville: " + cityName + "] [pays : " + (country==null?"unknown":country) + "] [nombre d'habitants : " + nbInhabitant + "]";
        return cityName + ", " + (country==null?"unknown":country) + ", " + nbInhabitant + " d'habitants";
    }

    public void display() {
        System.out.println("Ville de " + getCityName() + " au " + country + (nbInhabitant!=0?" ayant " + nbInhabitant + " d'habitants":""));
    }

    /*
        Getter et Setter
     */
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNbInhabitant() {
        return nbInhabitant;
    }

    public void setNbInhabitant(int nbInhabitant) {
        if(nbInhabitant < 0 ){
            System.out.println("Attention! Le nombre d'habitants ne peux pas etre inferieure a 0");
        }
        this.nbInhabitant = Math.max(nbInhabitant, 0);
    }
}

