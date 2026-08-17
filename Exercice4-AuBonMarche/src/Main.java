import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Fruit clementine = new Fruit("Clémentine", 2.9, "kg", 6, LocalDate.now(), 10);
        Fruit datte = new Fruit("Datte", 7, "kg", 4, LocalDate.now(), 10);
        Fruit grenade = new Fruit("Grenade", 3.5, "kg", 3, LocalDate.now(), 10);
        Fruit kaki = new Fruit("Kaki", 4.5, "kg", 3, LocalDate.now(), 10);
        Fruit kiwi = new Fruit("Kiwi", 3.5, "kg", 5, LocalDate.now(), 10);
        Fruit mandarine = new Fruit("Mandarine", 2.8, "kg", 6, LocalDate.now(), 10);
        Fruit orange = new Fruit("Orange", 1.5, "kg", 8, LocalDate.now(), 10);
        Fruit pamplemousse = new Fruit("Pamplemousse", 2, "pcs", 8, LocalDate.now(), 10);
        Fruit poire = new Fruit("Poire", 2.5, "kg", 5, LocalDate.now(), 10);
        Fruit pomme = new Fruit("Pomme", 1.5, "kg", 8, LocalDate.now(), 10);

        Vegetable carrote = new Vegetable("Carotte", 1.3, "kg", 7, LocalDate.now(), 10);
        Vegetable chouxDeBruxelles = new Vegetable("Choux de bruxelles", 4, "kg", 4, LocalDate.now(), 10);
        Vegetable chouVert = new Vegetable("Chou vert", 2.5, "pcs", 12, LocalDate.now(), 10);
        Vegetable courgeButternut = new Vegetable("Courge butternut", 2.5, "pcs", 6, LocalDate.now(), 10);
        Vegetable endive = new Vegetable("Endive", 2.5, "kg", 5, LocalDate.now(), 10);
        Vegetable epinard = new Vegetable("Épinard", 2.6, "kg", 4, LocalDate.now(), 10);
        Vegetable poireau = new Vegetable("Poireau", 1.2, "kg", 5, LocalDate.now(), 10);
        Vegetable potiron = new Vegetable("Potiron", 2.5, "pcs", 6, LocalDate.now(), 10);
        Vegetable radisNoir = new Vegetable("Radis noir", 5, "pcs", 10, LocalDate.now(), 10);
        Vegetable salsifis = new Vegetable("Salsifis", 2.5, "kg", 3, LocalDate.now(), 10);
    }
}