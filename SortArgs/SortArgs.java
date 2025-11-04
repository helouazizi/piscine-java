import java.lang.reflect.Array;
import java.util.Arrays;

public class SortArgs {
    public static void sort(String[] args) {
        // your code here
        Arrays.sort(args, (a,b) -> Integer.compare(Integer.parseInt(a) , Integer.parseInt(b)));

        System.out.println(String.join(" ", args));

    }
}