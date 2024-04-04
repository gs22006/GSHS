package hwhw12;

public class Car {
    Tire frontLeftTire;
    Tire frontRightTire;
    Tire backLeftTire;
    Tire backRightTire;

    public Car() {
        this.frontLeftTire = new Tire("Front-Left-Tire", 6);
        this.frontRightTire = new Tire("Front-Right-Tire", 2);
        this.backLeftTire = new Tire("Back-Left-Tire", 3);
        this.backRightTire = new Tire("Back-Right-Tire", 4);
    }

    int run() {
        System.out.println("자동차 주행중");

        if(this.frontLeftTire.roll() == false) {
            stop(0);
            this.frontRightTire.accumulatedRotation++;
            this.backLeftTire.accumulatedRotation++;
            this.backRightTire.accumulatedRotation++;
        }

        else if(this.frontRightTire.roll() == false) {
            stop(1);
            this.backLeftTire.accumulatedRotation++;
            this.backRightTire.accumulatedRotation++;
        }

        else if(this.backLeftTire.roll() == false) {
            stop(2);
            this.backRightTire.accumulatedRotation++;
        }

        else if(this.backRightTire.roll() == false) {
            stop(3);
        }

        System.out.println("++++++++++++++++++++++++");
        return 0;
    }

    void stop(int typ) {
        System.out.println("자동차 멈춤");

        if(typ == 0) {
            System.out.println("앞 왼쪽 A tire 교체");
            this.frontLeftTire = new ATire("Front-Left-Tire", 13);
        }

        else if(typ == 1) {
            System.out.println("앞 오른쪽 B tire 교체");
            this.frontRightTire = new BTire("Front-Right-Tire", 13);
        }

        else if(typ == 2) {
            System.out.println("뒤 왼쪽 A tire 교체");
            this.backLeftTire = new ATire("Back-Left-Tire", 13);
        }

        else if(typ == 3) {
            System.out.println("뒤 오른쪽 B tire 교체");
            this.backRightTire = new BTire("Back-Right-Tire", 13);
        }
    }
}