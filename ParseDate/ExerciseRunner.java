public class ExerciseRunner {
    public static void main(String[] args) {
        System.out.println(ParseDate.parseIsoFormat("2022-04-25T20:51:28.709039322"));
        System.out.println(ParseDate.parseFullTextFormat(null));
        System.out.println(ParseDate.parseTimeFormat("09 hours in the evening, 07 minutes and 23 seconds"));
    }
}
