public class City {
    private String city;
    private String country;
    private int nbInhabitant;

    public City(String city, String country, int nbInhabitant){
        this.city = city;
        this.country = country;
        this.nbInhabitant = nbInhabitant;
    }

    @Override
    public String toString() {
        return "Ville: " + city + ", Pays: " + country + ", Nombre d'habitants: " + nbInhabitant;
    }
}
