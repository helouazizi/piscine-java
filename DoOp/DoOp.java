public class DoOp {
    public static String operate(String[] args) {
        if (args.length == 0) {
            return "it depend on the input.";
        }

        int first = Integer.parseInt(args[0]);
        int second = Integer.parseInt(args[2]);

        switch (args[1]) {
            case "+":
                return String.valueOf(first + second);
            case "-":
                return String.valueOf(first - second);
            case "*":
                return String.valueOf(first * second);
            case "/":
                if (second == 0) {
                    return "Error";
                }
                return String.valueOf(first / second);
            case "%":
                if (second == 0) {
                    return "Error";
                }
                return String.valueOf(first % second);
            default:
                return "It depends on the input.";
        }
    }
}
