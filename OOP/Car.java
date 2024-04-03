public class Car {
    private int speed;
    private int direction;

    public Car(int speed, int direction) {
        this.speed = speed;
        this.direction = direction;
    }

    public Car(int speed) {
        this.speed = speed;
        this.direction = 20;
    }

    public Car() {
        this.speed = 10;
        this.direction = 20;
    }

    public void print1() {
        System.out.print(String.format("%-20s", this.toString()));
        System.out.printf("속도 : %-4d 방향 : %-4d\n", this.speed, this.direction);
    }
}