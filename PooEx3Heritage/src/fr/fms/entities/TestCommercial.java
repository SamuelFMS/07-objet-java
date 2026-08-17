package fr.fms.entities;

public class TestCommercial {
    public static void main(String[] args) {
        Commercial dupont = new Commercial("Dupont", "robert", 50, "rue des rosiers à Toulouse", new City("Limoges", "France", 133000), "brico", 5);
        System.out.println(dupont);
    }
}
