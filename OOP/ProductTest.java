public class ProductTest {

    public ProductTest() {

    }

    public static void main(String[] args) {
        Product p1 = new Product("웰치스", 700);
        Product p2 = new Product("커피");
        Product p3 = new Product(500);
        Product p4 = new Product();

        System.out.println(p1.getName() + ", " + p1.getPrice());
        System.out.println(p2.getName() + ", " + p2.getPrice());
        System.out.println(p3.getName() + ", " + p3.getPrice());
        System.out.println(p4.getName() + ", " + p4.getPrice());
    }
}