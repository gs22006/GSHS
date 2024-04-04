package hwhw12;

public class Tire {
    public int maxRotation;
    public int accumulatedRotation;
    public String location;

    public Tire(String location, int maxRotation) {
        this.maxRotation = maxRotation;
        this.accumulatedRotation = 0;
        this.location = location;
    }

    public boolean roll() {
        if(this.maxRotation <= this.accumulatedRotation)
            return false;
        
        this.accumulatedRotation++;

        if(this.maxRotation == this.accumulatedRotation) {
            System.out.println(this.location + " ** 타이어 교체 필요 **");
            return false;
        }

        System.out.println(this.location + " - 타이어 남은 수명 : " + (this.maxRotation - this.accumulatedRotation));
        return true;
    }
}