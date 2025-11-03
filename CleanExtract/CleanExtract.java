public class CleanExtract {
    public static String extract(String s) {
        String res = "";
        var parst = s.split("\\|");
        for (String part : parst) {
            int first = part.indexOf(".");
            int last = part.lastIndexOf(".");
            if (first >= 0 && last >= 0 && last > first) {
                res += part.substring(first + 1, last);
            } else if (first == last) {
                res += part.substring(first + 1);
            } else if (first == -1 && last == -1 && !part.isEmpty()) {
                res += part;
            }
            res += " ";

        }
        return res.replaceAll("\\s+", " ").trim();
    }
}
