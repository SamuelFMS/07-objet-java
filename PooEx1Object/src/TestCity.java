//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestCity {
    public static void main(String[] args) {
        City toulouse = new City("Toulouse", "France", 450000);
        City bayonne = new City("Bayonne", "France", 54000);
        City paris = new City("Paris", "France", 2100000);
        City dublin = new City("Dublin", "Ireland", 592000);
        toulouse.setNbInhabitant(-100);
        System.out.println(toulouse);
        System.out.println(bayonne);
        System.out.println("Toulouse a eu 20 000 nouveau arrivants");
        toulouse.setNbInhabitant(toulouse.getNbInhabitant() + 20000);
        System.out.println(toulouse);
        System.out.println("Toulouse a 470 000 habitant mais on retire 100 000");
        toulouse.setNbInhabitant(470000);
        toulouse.setNbInhabitant(toulouse.getNbInhabitant() - 100000);
        System.out.println(toulouse);
        City rabat = new City("Rabat", 577000);
        System.out.println(rabat);
        rabat.setCountry("Maroc");
        System.out.println(rabat);
        toulouse.display();
        System.out.println("Il y'a " + City.nbInstances + " de villes");
    }
}