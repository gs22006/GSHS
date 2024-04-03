public class Mp3Test {

    public static void main(String[] args) {
        Mp3 mp1 = new Mp3("아이리버", "4GB");
        Mp3 mp2 = new Mp3("삼성 yepp", "2GB");
        Mp3 mp3 = new Mp3("아이팟", "2GB");

        mp1.print();
        mp2.print();
        mp3.print();
    }
}