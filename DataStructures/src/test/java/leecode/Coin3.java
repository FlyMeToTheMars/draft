package leecode;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/11 10:29
 * @Version 1.0
 **/
public class Coin3 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int count = new Coin3().coinChange(coins, amount);
        System.out.println(count);
    }

    int res = Integer.MAX_VALUE;
    int cnt = 0;

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        helper(coins, amount);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    private void helper(int[] coins, int amount) {
        if (amount < 0) {
            return;
        }

        if (amount == 0) {
            res = Math.min(res, cnt);
        }

        for (int i = 0; i < coins.length; i++) {
            cnt ++;
            helper(coins, amount - coins[i]);
        }
    }


}
