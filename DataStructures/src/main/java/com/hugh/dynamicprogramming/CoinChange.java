package com.hugh.dynamicprogramming;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/10 11:08 上午
 * @Version 1.0
 **/
public class CoinChange {
    public static void main(String[] args) {

        final int[] conis = {1, 2, 5};
        int amount = 11;

        final int num = new CoinChange().coinChange(conis, amount);
        System.out.println(num);

    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount ,new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;

        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }

        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;

        return count[rem - 1];
    }
}