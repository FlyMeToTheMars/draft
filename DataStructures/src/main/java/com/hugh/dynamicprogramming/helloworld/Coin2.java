package com.hugh.dynamicprogramming.helloworld;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/11 11:26
 * @Version 1.0
 **/
public class Coin2 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 1000;

        System.out.println(System.currentTimeMillis());
        int count = new Coin2().coinChange(coins, amount);
        System.out.println(System.currentTimeMillis());
        System.out.println(count);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return helper(coins, amount, new int[amount]);
    }

    public int helper(int[] coins, int amount, int[] res) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) return 0;

        if (res[amount - 1] != 0) {
            return res[amount - 1];
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int ress = helper(coins, amount - coins[i], res);
            if (ress >= 0 && ress < min) {
                min = ress + 1;
            }
        }

        res[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println("index = " + (amount-1) + "的时候，值是"+ res[amount - 1] );

        return res[amount - 1];
    }
}
