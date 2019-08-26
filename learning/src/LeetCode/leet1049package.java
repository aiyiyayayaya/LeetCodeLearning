package LeetCode;

/**
 * Created by aiya on 2019/8/26 下午3:42
 * 两堆石头重量最接近sum/2时碰撞后留下的重量最小
 * 转化为weight = sum/2的背包中 value即重量，使value最大
 * 跟416很像啊
 */
public class leet1049package {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++)
            sum += stones[i];
        int target = (sum+1) >> 1;
        //int max = 0;
        int[][] dp = new int[stones.length][target+1];
        for(int j = stones[0]; j <= target; j++){
            dp[0][j] =stones[0];
        }
        for (int i = 1; i< stones.length; i++){
            for (int j = 0; j <= target; j++){
                if (stones[i] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stones[i]] + stones[i]);
            }
            //max = Math.max(max, dp[i][target]);
        }
        return Math.abs(sum - 2 * dp[stones.length-1][target]);
    }

    public int lastStoneWeightII2(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++)
            sum += stones[i];
        int target = sum >> 1;
        int[] dp = new int[target+1];
        for (int num : stones){
            for (int j = target; j >= num; j--)
                dp[j] = Math.max(dp[j], dp[j-num]+num);
        }
        return sum - 2*dp[target];
    }
    public static void main(String[] args) {
        leet1049package leet = new leet1049package();
        int[] nums = {28,33,34,40,31,7,27};
        System.out.println(leet.lastStoneWeightII(nums));
    }
}
