import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class KeepTheChange {

    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        int[] dp = new int[amount + 1];
        int[] lastCoin = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            lastCoin[i] = -1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    if (dp[i] > dp[i - coin] + 1) {
                        dp[i] = dp[i - coin] + 1;
                        lastCoin[i] = coin;
                    }
                }
            }
        }

        if (lastCoin[amount] == -1) {
        }

        List<Integer> result = new ArrayList<>();
        int current = amount;

        while (current > 0) {
            int coin = lastCoin[current];
            result.add(coin);
            current -= coin;
        }


        Collections.reverse(result);

        return result;
    }
}
