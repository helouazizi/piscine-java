public class ComputeArray {
    public static int[] computeArray(int[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int remainder = num % 3;

            if (remainder == 0) {
                result[i] = num * 5;
            } else if (remainder == 1 || remainder == -2) {
                result[i] = num + 7;
            } else {
                result[i] = num;
            }
        }

        return result;
    }
}
