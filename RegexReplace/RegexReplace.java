
public class RegexReplace {

    public static String removeUnits(String s) {
        return s.replaceAll("(\\d+)(cm|€)(?= |$)", "$1");
    }


    public static String obfuscateEmail(String s) {

        String[] parts = s.split("@");
        String username = parts[0];
        String domain = parts[1];


        if (username.matches(".*[._-].*")) {

            int idx = username.indexOf('.');
            int dash = username.indexOf('-');
            int under = username.indexOf('_');

            if (dash != -1 && (idx == -1 || dash < idx)) idx = dash;
            if (under != -1 && (idx == -1 || under < idx)) idx = under;

            String prefix = username.substring(0, idx + 1);

            String mask = username.substring(idx + 1).replaceAll(".", "*");

            username = prefix + mask;

        } else {
            if (username.length() > 3) {
                username = username.substring(0, 3)
                        + username.substring(3).replaceAll(".", "*");
            }
        }


        String[] labels = domain.split("\\.");

        if (labels.length == 3) {
            labels[0] = labels[0].replaceAll(".", "*"); 
            labels[2] = labels[2].replaceAll(".", "*"); 
        } else {
          
            labels[0] = labels[0].replaceAll(".", "*"); 
            if (!labels[1].matches("com|org|net")) {
                labels[1] = labels[1].replaceAll(".", "*"); 
            }
        }

        StringBuilder newDomain = new StringBuilder();
        for (int i = 0; i < labels.length; i++) {
            newDomain.append(labels[i]);
            if (i < labels.length - 1) newDomain.append(".");
        }

        return username + "@" + newDomain.toString();
    }
}
