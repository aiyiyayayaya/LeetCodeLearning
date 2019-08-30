package LeetCode;

/**
 * Created by aiya on 2019/8/27 上午8:55
 * 不同面额的硬币coins, 总金额amount
 * 求凑成总金额所需的最少硬币个数
 */
public class leet322coinChange {
    public int coinChange(int[] coins, int amount) {
        //dp[i]表示凑成金额i所需的最少的硬币个数
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++)
            dp[i] = amount + 1;
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
        if (dp[amount] <= amount)
            return dp[amount];
        return -1;
    }
}
