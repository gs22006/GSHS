public class Employee {
    public String name;
    public int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print() {
        System.out.println("* 사원의 이름은 " + name + "이고, 나이는 " + age + " 입니다.");
    }
}
