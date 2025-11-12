import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class StreamMap {
    public static Integer sumOfStringLength(Stream<String> s) {
        if (s == null)
            return 0;
        return s.mapToInt(String::length).sum();
    }

    public static List<String> upperCaseAllString(Stream<String> s) {
        if (s == null)
            return Collections.emptyList();
        return s.map(String::toUpperCase)
                .collect(toList());
    }

    public static Set<Integer> uniqIntValuesGreaterThan42(Stream<Double> s) {
        if (s == null)
            return Collections.emptySet();
        return s.filter(d -> d > 42)
                .map(Double::intValue)
                .collect(toSet());
    }
}