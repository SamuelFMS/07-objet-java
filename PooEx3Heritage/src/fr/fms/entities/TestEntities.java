package fr.fms.entities;

import java.util.ArrayList;

public class TestEntities {
    public static void main(String[] args) {
        ArrayList<Person> myEmployeesAndCommercials = new ArrayList<Person>();
        Employee billGate = new Employee("Gate", "Bill", 65, "USA", new Capital("Washington", "USA", "W-M"),"Fondation B&M", 100000);
        Employee musk = new Employee("Musk", "Elon", 49, "palo alto", new City("Pretoria", "Affrique du Sud", 800000), "Tesla", 150000);
        Commercial dupont = new Commercial("Dupont", "robert", 50, "rue des rosiers à Toulouse", new City("Limoges", "France", 133000), "brico", 5);
        myEmployeesAndCommercials.add(billGate);
        myEmployeesAndCommercials.add(musk);
        myEmployeesAndCommercials.add(dupont);
        for(Person employeeOrCommercial: myEmployeesAndCommercials) {
            System.out.println(employeeOrCommercial);
        }
        for(Person employeeOrCommercial: myEmployeesAndCommercials) {
            System.out.println("Salaire mensuel de " + employeeOrCommercial.getFirstName() + " " + employeeOrCommercial.getLastName() +" : "  + employeeOrCommercial.remuneration());
        }
    }
}
