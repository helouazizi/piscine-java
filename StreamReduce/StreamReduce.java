import java.util.stream.Stream;

public class StreamReduce {

    public static Integer sumAll(Stream<Integer> s) {
        if (s == null) return 0;
        return s.reduce(0, Integer::sum);
    }

    public static Integer divideAndAddElements(Stream<Integer> s, int divider) {
        if (s == null || divider == 0) return 0;

        return s.reduce(0, (acc, i) -> acc + (i / divider));
    }
}
