public class City {
    private String city;
    private String country;
    private int nbInhabitant;

    public City(String city, String country, int nbInhabitant) {
        this.city = city;
        this.country = country;
        this.nbInhabitant = nbInhabitant;
    }

    @Override
    public String toString() {
        return "Ville: " + city + ", Pays: " + country + ", Nombre d'habitants: " + nbInhabitant;
    }

    /*
        Getter et Setter
     */
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
        this.nbInhabitant = nbInhabitant;
    }
}
