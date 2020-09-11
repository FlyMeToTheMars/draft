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

        int i = new Coin().coinChange1(coins, amount);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        // DP-Table 表示找index元需要的最少硬币数
        int[] dp = new int[amount + 1];

        // 遍历所有硬币种类
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

    public int coinChange1(int[] coins, int amount) {
        if (amount==0) return 0;
        int[] dp =new int[amount+1];  //dp[i]表示达到i用的最少硬币数  默认=初始化全为0
        for (int i = 1; i <= amount; i++) {  //目标为0 的不用计算
            dp[i]=999999;   //此处不能用int的最大值，最大值+1 会溢出变为最小值
            for (int coin :coins) {
                if (i-coin>=0) dp[i] =Math.min(dp[i-coin]+1,dp[i]);
            }
        }
        return dp[amount]==999999?-1:dp[amount];
    }
}
