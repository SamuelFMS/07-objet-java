package fr.fms.entities;

public class TestEmployee {
    public static void main(String[] args) {
        Employee billGate = new Employee("Gate", "Bill", 65, "USA", new Capital("Washington", "USA",7600000, "W-M"),"Fondation B&M", 100000);
        System.out.println(billGate);
    }
}
