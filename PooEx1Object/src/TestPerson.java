import java.util.ArrayList;
import java.util.List;

public class TestPerson {
    public static void main(String[] args) {
        Person manu = new Person("Macron", "Emmanuel", 43, "L'Elysée à Paris", new City("Amiens", "France"));
        Person poutine = new Person("Poutine", "Vladimir", 68);
        Person biden = new Person("Biden", "joe");
        Person sarkozy = new Person("Sarkozy", "Nicolas", 66, "Paris", new City("Paris", "France", 2000000));
        Person johnson = new Person("Johnson", "Boris", 56, "Downing street à London", new City("New York", "Etats-unis"));
        Person depardieu = new Person("Depardieu", "Gerard", 72, "Moscou", new City("Châteauroux", "France"));
        Person kravitz= new Person("Kravitz", "lenny", 56, "Hotel particulier à Paris", new City("New York", "USA"));
        Person lawrence = new Person("Lawrence", "jennifer", 30, "Louisville aux USA", new City("Indian Hills", "USA"));

        /*System.out.println(manu);
        System.out.println(poutine);
        System.out.println(biden);*/

        ArrayList<Person> celebrities = new ArrayList<>();
        celebrities.add(manu);
        celebrities.add(sarkozy);
        celebrities.add(johnson);
        celebrities.add(depardieu);
        celebrities.add(kravitz);
        celebrities.add(lawrence);
        System.out.println("---------------------------------------");
        System.out.println("Liste des personnalités");
        for(Person celebritie: celebrities){
            celebritie.display();
        }
        System.out.println("---------------------------------------");

    }
}
