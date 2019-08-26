package LeetCode;

/**
 * Created by aiya on 2019/8/13 下午7:29
 */
public class RemoveDuplicates26 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return len;
        int cur = 0;
        for (int i = 1; i < len; i++){
            if (nums[i] !=nums[cur])
                nums[++cur] = nums[i];
        }
        return cur+1;
    }

    public static void main(String[] args) {
        RemoveDuplicates26 re = new RemoveDuplicates26();
        int[] nums = {1,1};
        re.removeDuplicates(nums);
    }
}
