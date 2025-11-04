import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length < 2)
            return;

        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    lines.add(""); // empty lines
                    continue;
                }

                StringBuilder sb = new StringBuilder();
                boolean capitalizeNext = true;

                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (Character.isWhitespace(c)) {
                        if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                            sb.append(' ');
                        }
                        capitalizeNext = true;
                    } else {
                        sb.append(capitalizeNext ? Character.toUpperCase(c) : Character.toLowerCase(c));
                        capitalizeNext = false;
                    }
                }

                lines.add(sb.toString());
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (int i = 0; i < lines.size(); i++) {
                writer.write(lines.get(i));
                if (i < lines.size() - 1) {
                    writer.newLine(); 
                }
            }
        }
    }
}
