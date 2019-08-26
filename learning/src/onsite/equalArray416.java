package onsite;

/**
 * Created by aiya on 2019/8/26 下午2:28
 *
 *
 */
public class equalArray416 {
    public boolean canPartition(int[] nums) {
        //先加一遍 如果是奇数 则不能被分割
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if ((sum & 1) == 1)
            return false;
        //转化为重量为sum/2的背包问题
        int target = sum >> 1;
        int[][] dp = new int[nums.length][target+1];
        for (int j = nums[0]; j <= target; j++){
            dp[0][j] = nums[0];
        }
        //外层遍历物品，第i 件
        for (int i = 1; i < nums.length; i++){
            //内层遍历重量，weight
            for (int j = 0; j <= target; j++){
                if (nums[i] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]] + nums[i]);
            }
        }
        if (dp[nums.length-1][target] == target)
            return true;
        return false;
    }
    public boolean canPartition2(int[] nums) {
        //前面是一样的
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if ((sum & 1) == 1)
            return false;
        int target = sum >> 1;
        //dp[j]表示原数组是否可以取出若干个数字，使得和为j
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        //遍历数组
        for (int i = 0; i < nums.length; i++)
            //dp[nums[i]]和dp[j-nums[i]]都能凑出来，更新dp[j]
            for (int j = target; j >= nums[i]; j--)
                dp[j] = dp[j] || dp[j-nums[i]];
        //终极目标：dp[target]
        return dp[target];
    }
}
