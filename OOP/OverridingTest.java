public class OverridingTest {
    public OverridingTest() {
        
    }

    public static void main(String[] args) {
        Employee emp = new Employee("Kim min", 25);
        Manager man = new Manager("Lee Joon", 30, "Project Manager");

        emp.print();
        man.print();
    }
}
