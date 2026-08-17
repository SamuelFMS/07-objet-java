public class City {
    private String cityName;
    private String country;
    private int nbInhabitant;

    public City(String cityName, String country, int nbInhabitant) {
        this.cityName = cityName;
        this.country = country;
        setNbInhabitant(nbInhabitant);
    }

    @Override
    public String toString() {
        return "Ville: " + cityName + ", Pays: " + country + ", Nombre d'habitants: " + nbInhabitant;
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
