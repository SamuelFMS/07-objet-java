package fr.fms.entities;

public class TestEntities {
    public static void main(String[] args) {
        Employee billGate = new Employee("Gate", "Bill", 65, "USA", new Capital("Washington", "USA", "W-M"),"Fondation B&M", 100000);
        Employee musk = new Employee("Musk", "Elon", 49, "palo alto", new City("Pretoria", "Affrique du Sud", 800000), "Tesla", 150000);
        Commercial dupont = new Commercial("Dupont", "robert", 50, "rue des rosiers à Toulouse", new City("Limoges", "France", 133000), "brico", 5);
        System.out.println(dupont);
    }
}
