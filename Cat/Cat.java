import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }

        File file = new File(args[0]);
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[4096]; 
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                System.out.write(buffer, 0, bytesRead);
            }
            // System.out.println();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
