//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestCity {
    public static void main(String[] args) {
        City toulouse = new City("Toulouse", "France", 450000);
        City bayonne = new City("Bayonne", "France", 54000);
        City paris = new City("Paris", "France",  2100000);
        City dublin = new City("Dublin", "Ireland",  592000);
        System.out.println(toulouse);
        System.out.println(bayonne);
        toulouse.setNbInhabitant(toulouse.getNbInhabitant() + 20000);
        System.out.println(toulouse);
    }
}