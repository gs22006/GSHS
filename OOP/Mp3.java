public class Mp3 {
    private String comp;
    private String size;

    public Mp3(String comp, String size) {
        this.comp = comp;
        this.size = size;
    }

    public Mp3(String comp) {
        this.comp = comp;
        this.size = new String("2GB");
    }

    public Mp3() {
        this.comp = new String("아이팟");
        this.size = new String("2GB");
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void print() {
        System.out.printf("제조회사명 : %-15s 메모리용량 : %s\n", this.comp, this.size);
    }
}