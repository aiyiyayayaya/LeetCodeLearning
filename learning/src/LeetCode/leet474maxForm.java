package LeetCode;

/**
 * Created by aiya on 2019/8/26 下午7:31
 */
public class leet474maxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示有i个0和j个1时能组成最多字符串的个数
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs){
            //统计出0 1 的个数
            int zero = 0, one = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '0')
                    ++zero;
                else
                    ++one;
            }
            for (int i = m; i >= zero; i--)
                for (int j = n; j>= one; j--)
                    dp[i][j] = Math.max(dp[i][j], dp[i-zero][j-one] + 1);
        }
        return dp[m][n];
    }
}
