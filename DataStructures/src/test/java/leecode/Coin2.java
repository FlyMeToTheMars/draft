package leecode;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/11 10:15
 * @Version 1.0
 **/
public class Coin2 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int count = new Coin2().coinChange(coins, amount);
        System.out.println(count);
    }

    int res = Integer.MAX_VALUE;

    private int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        helper(coins, amount, 0);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    private void helper(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }

        if (amount == 0) {
            res = Math.min(res, count);
        }

        for (int i = 0; i < coins.length; i++) {
            helper(coins, amount - coins[i], count + 1);
        }
    }
}
