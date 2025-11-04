import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {

    public static void createFile(String fileName, String content) throws IOException {
        File file = new File(fileName);

        if (!file.exists()) {
            file.createNewFile();
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        } catch (IOException e) {
            throw new IOException("Error writing to the file: " + fileName, e);
        }
    }

    public static String getContentFile(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        return String.join("\n", lines);

    }

    public static void deleteFile(String fileName) {
        File file = new File(fileName);

        if (file.exists()) {
            boolean deleted = file.delete();
            if (!deleted) {
                System.out.println("Failed to delete the file " + fileName);
            }
        } else {
            System.out.println("File " + fileName + " does not exist.");
        }
    }
}