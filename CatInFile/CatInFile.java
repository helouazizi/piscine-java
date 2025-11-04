import java.io.*;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }

        File outputFile = new File(args[0]);

        try (InputStream in = System.in;
             FileOutputStream out = new FileOutputStream(outputFile)) {

            byte[] buffer = new byte[4096]; 
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
