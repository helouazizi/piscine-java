import java.io.*;
import java.io.IOException;
import java.nio.file.Files;

public class Cat {
    public static void cat(String[] args) {
        if (args.length == 0) {
            return; 
        }

        File file = new File(args[0]);
        try {
            String content = new String(Files.readAllBytes(file.toPath()));
            System.out.println(content); 
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
