package fr.fms.entities;

public class TestEmployee {
    public static void main(String[] args) {
        Employee billGate = new Employee("Gate", "Bill", 65, "USA", new Capital("Washington", "USA", "W-M"),"Fondation B&M", 100000);
        Employee musk = new Employee("Musk", "Elon", 49, "palo alto", new City("Pretoria", "Affrique du Sud", 800000), "Tesla", 150000);
        System.out.println(billGate);
        System.out.println(musk);

    }
}
