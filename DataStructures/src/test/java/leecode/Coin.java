package leecode;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/10 15:01
 * @Version 1.0
 **/
public class Coin {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        int count = new Coin().coinChange(coins, amount);
        System.out.println(count);
    }

    public int coinChange(int[] coins, int amount) {
        // DP-Table
        int[] dp = new int[amount + 1];

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) { //将逆序遍历改为正序遍历
                if (i == coin) {
                    dp[i] = 1;
                } else if (dp[i] == 0 && dp[i - coin] != 0) {
                    dp[i] = dp[i - coin] + 1;

                } else if (dp[i - coin] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
