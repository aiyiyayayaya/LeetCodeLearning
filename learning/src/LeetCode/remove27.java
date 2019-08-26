package LeetCode;

/**
 * Created by aiya on 2019/8/19 下午8:04
 * 原地移除数值等于val的元素，返回数组的新长度
 */
public class remove27 {
    public int removeElement(int[] nums, int val){
        int cur = 0;
        for(int i = 0; i< nums.length; i++){
            if (nums[i] != val){
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }
}
