package fr.fms.entities;

public class Capital extends City {
    private String monument;

    public Capital(String cityName, String country, int nbInhabitant, String monument) {
        super(cityName, country, nbInhabitant);
        this.monument = monument;
    }

    public Capital(String cityName, String country, String monument) {
        super(cityName, country);
        this.monument = monument;
    }

    public Capital(String cityName, int nbInhabitant, String monument) {
        super(cityName, nbInhabitant);
        this.monument = monument;
    }
}
