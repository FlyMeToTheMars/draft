package com.hugh.dynamicprogramming.helloworld;

import java.util.Arrays;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/11 14:37
 * @Version 1.0
 **/
public class Coin3 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int count = new Coin3().coinChange(coins, amount);
        System.out.println(count);
    }

    public int coinChange(int[] coins, int amount) {
        //  对于题意，对于任意给出的数来说，需要的硬币数量 > 这个数本身必定是最大值
        int max = amount + 1;
        //  dp的函含义是     对于每个index为amount的钱，value总是其需要的最小硬币数量、
        int[] dp = new int[amount + 1];
        //  对dp的每个值进行填充
        Arrays.fill(dp, max);
        //  0元需要0个硬币来兑换
        dp[0] = 0;
        //  外层是 amount的遍历，从1开始
        for (int i = 1; i <= amount; i++) {
            // 内层遍历的是 硬币的种类
            for (int j = 0; j < coins.length; j++) {
                /** 这个判断要思考一下，比如说  i = 1的时候，
                 *  coins[j] 前后分别是 1，2，5
                 *  如果coins <= j 的时候也就是说，当硬币面额小于余额的时候才会判断。
                 *  这个时候读取了 dp[0]的值，dp[1] = dp[0] + 1
                 *
                 *  当数组比较大(大于最大值的硬币)的时候，这个判断有点类似于没用了，
                 *  后面进行的的判断，会把dp[i]中每个硬币的组合都判断一遍。同时更新到了数组里面，取最小值
                 * */
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        //  最后返回了数组。
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
