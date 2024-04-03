import java.io.*;
import java.util.Scanner;

public class PerformanceTest {

    public static void main(String[] args) throws IOException {
        final String inputFile = "largeTextFile.txt";
        // Create a large text file
        try (PrintWriter out = new PrintWriter(new FileWriter(inputFile))) {
            for (int i = 0; i < 100000; i++) { // Adjust the number of lines to make the file larger or smaller
                out.println("This is line number " + i + " in a very large text file that is being used to test the performance of BufferedReader and Scanner.");
            }
        }

        // Measure BufferedReader with InputStreamReader
        long startTime = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process the line
            }
        }
        long endTime = System.nanoTime();
        System.out.println("BufferedReader + InputStreamReader: " + (endTime - startTime) + " ns");

        // Measure Scanner
        startTime = System.nanoTime();
        try (Scanner scanner = new Scanner(new File(inputFile))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the line
            }
        }
        endTime = System.nanoTime();
        System.out.println("Scanner: " + (endTime - startTime) + " ns");

        // Optional: Delete the file after the test
        new File(inputFile).delete();
    }
}
