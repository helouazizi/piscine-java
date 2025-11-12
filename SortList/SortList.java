import java.util.ArrayList;
import java.util.List;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
        // your code here
        if (list == null) {
            return null;
        }
        List<Integer> copy = new ArrayList<>(list);
        copy.sort((a, b) -> a.compareTo(b));
        return copy;
    }

    public static List<Integer> sortReverse(List<Integer> list) {
        // your code here
        if (list == null) {
            return null;
        }
        List<Integer> copy = new ArrayList<>(list);
        copy.sort((a, b) -> -1*a.compareTo(b));
        return copy;
    }
}
