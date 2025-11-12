import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class StreamCollect {

    public static Map<Character, List<String>> mapByFirstLetter(Stream<String> s) {
        if (s == null) return Collections.emptyMap();

        return s.collect(
            groupingBy(
                str -> Character.toUpperCase(str.charAt(0)), 
                LinkedHashMap::new, 
                toList()
            )
        );
    }

    public static Map<Integer, Optional<Integer>> getMaxByModulo4(Stream<Integer> s) {
        if (s == null) return Collections.emptyMap();

        return s.collect(
            groupingBy(
                i -> i % 4,
                TreeMap::new, 
                maxBy(Integer::compareTo)
            )
        );
    }

    public static String orderAndConcatWithSharp(Stream<String> s) {
        if (s == null) return "{}";

        String joined = s
            .sorted()
            .collect(Collectors.joining(" # "));

        return "{" + joined + "}";
    }
}
