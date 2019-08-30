package LeetCode;

/**
 * Created by aiya on 2019/8/30 下午8:48
 */
public class leet11water {
    public int maxArea(int[] height) {
        int left = 0, right = height.length;
        int res = 0;
        while (left < right){
            int water = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, water);
            if (height[left] < height[right]) {
                left++;
            }
            else right--;
        }
        return res;
    }
}
