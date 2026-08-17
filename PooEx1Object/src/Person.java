public class Person {
    private final String lastName;
    private final String firstName;
    private int age;
    private String address;

    public Person(String lastName, String firstName, int age, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    public Person(String lastName, String firstName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String lastName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "[lastName=" + lastName + ", firstName=" + firstName + ", age=" + age + ", address=" + (address==null?"unknown":address) + "]";
    }
}
