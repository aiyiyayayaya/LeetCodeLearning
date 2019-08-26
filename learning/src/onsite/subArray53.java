package onsite;

/**
 * Created by aiya on 2019/8/26 下午2:01
 */
public class subArray53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len < 1)
            return 0;
        int sum = nums[0], res = sum;
        for (int i = 1; i < len; i++){
            sum += nums[i];
            if (sum < nums[i]){
                sum = nums[i];
            }
            res = res > sum ? res : sum;
        }
        return res;
    }
}
