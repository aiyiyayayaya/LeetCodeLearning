package LeetCode;

/**
 * Created by aiya on 2019/7/17 上午9:17
 * 从未排序的数组中找到第K个最大元素
 */
public class KthMax_215 {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length-1;
        while (true){
            int pos = sort(nums, left, right);
            if (pos == k-1)
                return nums[pos];
            else if (pos > k-1)
                right = pos - 1;
            else
                left = pos + 1;
        }
    }
    //
    public int sort(int[] nums, int left, int right){
        int guard = nums[left], l = left+1, r = right;
        while (l <= r){
            if (nums[l] < guard && nums[r] > guard ){
                int tmp = nums[l];
                nums[l++] = nums[r];
                nums[r--] = tmp;
            }
            if (nums[l] >= guard)
                ++l;
            if (nums[r] <= guard)
                --r;
        }
        int tmp = nums[left];
        nums[left] = nums[r];
        nums[r] = tmp;
        return r;
    }
}
