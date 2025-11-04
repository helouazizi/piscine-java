import java.io.File;

public class FileSearch {
    public static String searchFile(String fileName) {
        File directory = new File("documents");
        return searchInDirectory(directory, fileName);
    }

    private static String searchInDirectory(File directory, String fileName) {
        if (directory == null || !directory.exists() || !directory.isDirectory()) {
            return null;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            return null;
        }

        for (File file : files) {
            if (file.isFile() && file.getName().equals(fileName)) {
                return getRelativePath( file);
            }

            if (file.isDirectory()) {
                String result = searchInDirectory(file, fileName);
                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }

    private static String getRelativePath(File file) {
        String filePath = file.getAbsolutePath();

        String basePath = new File("documents").getAbsolutePath();

        if (filePath.startsWith(basePath)) {
            return filePath.substring(basePath.length() + 1);
        }

        return null;
    }
}
