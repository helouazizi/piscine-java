import java.io.*;
import java.util.Scanner;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }

        File file = new File(args[0]);
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }
}
