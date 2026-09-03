
import java.util.Arrays;

class Solution {

    public int MinimumCoins(int[] coins, int amount) {
        Arrays.sort(coins);

        for (int i = 0, j = coins.length - 1; i < j; i++, j--) {
            int temp = coins[i];
            coins[i] = coins[j];
            coins[j] = temp;
        }

        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int functionalAmount = amount;
            int count = 0;
            for (int j = i; j < coins.length; j++) {

                if (coins[j] > functionalAmount) {
                    continue;
                }
                while (coins[j] <= functionalAmount) {
                    count++;
                    functionalAmount -= coins[j];
                    if (functionalAmount == 0) {
                        minCoins = Math.min(minCoins, count);
                    }
                }
            }
        }
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
}
