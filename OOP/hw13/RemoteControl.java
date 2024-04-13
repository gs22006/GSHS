package hw13;

public interface RemoteControl {
    public static final int MAX_VOLUME = 100;
    public static final int MIN_VOLUME = 0;

    void turnOn();
    void turnOff();
    void setVolume(int volume);

    default void setMute(boolean mute) {
        if(mute == true)
            System.out.println("무음 처리 합니다.");
        else
            System.out.println("무음 해제 합니다.");
    }

    static void changeBattery() {
        System.out.println("배터리 교환합니다.");
    }
}