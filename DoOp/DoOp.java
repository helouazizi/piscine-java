public class DoOp {
    public static String operate(String[] args) {
        // if no arguments, return Error
        if (args.length == 0 || args.length != 3) {
            return "Error";
        }

        int first = Integer.parseInt(args[0]);
        int second = Integer.parseInt(args[2]);

        switch (args[1]) {
            case "+":
                return (first + second) + "";
            case "-":
                return (first - second) + "";
            case "*":
                return (first * second) + "";
            case "/":
                if (second == 0) {
                    return "Error";
                }
                return (first / second) + "";
            case "%":
                if (second == 0) {
                    return "Error";
                }
                return (first % second) + "";
            default:
                return "Error";
        }
    }
}
