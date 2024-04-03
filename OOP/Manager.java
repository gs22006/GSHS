public class Manager extends Employee {
    String jobOfManager;

    public Manager(String name, int age, String job) {
        super(name, age);
        this.jobOfManager = job;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("- 관리자 " + name + "의 직함은 " + jobOfManager + " 입니다.");
    }
}
