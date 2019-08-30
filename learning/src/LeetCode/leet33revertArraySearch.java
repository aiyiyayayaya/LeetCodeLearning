package LeetCode;

/**
 * Created by aiya on 2019/8/29 上午10:22
 * 4567012
 */
public class leet33revertArraySearch {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while (start <= end){
            int mid = (start + end)/2;
            if (nums[mid] == target)
                return mid;
            //从mid往后是完整正序
            if (nums[mid] < nums[end]){
                //target正好在正序中
                if (nums[mid] < target && nums[end] >= target)
                    start = mid + 1;
                else
                    end = mid -1;
            }else {
                //从mid往前是完整正序
                if (nums[mid] > target && nums[start] <= target)
                    end = mid-1;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }
}
