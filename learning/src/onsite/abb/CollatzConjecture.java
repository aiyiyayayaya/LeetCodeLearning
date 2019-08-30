package onsite.abb;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aiya on 2019/8/28 下午8:43
 * 定义如下序列：以任意正整数n开始
 * 1. 如果nums[i-1]是偶数：则nums[i] = nums[i-1]/2
 * 2. 奇数:nums[i] = nums[i-1] * 3 + 1;
 * 猜想：无论n的值是多少，序列最终都=1
 * 给一个数num，算出1-num 中 最大的步长
 */
public class CollatzConjecture {
    private Map<Integer, Integer> map = new HashMap<>();
    public int findStep(int num){
        if (num <= 1)
            return 1;
        if (map.containsKey(num))
            return map.get(num);
        //奇数
        if ((num & 1) == 1){
            return 1 + findStep(num * 3 + 1);
        }else {
            return 1 + findStep(num >> 1);
        }
    }

    public int findLongestStep(int num){
        if (num < 1)
            return 0;
        int res = 0;
        for (int i = 1; i <= num; i++){
            int tmp = findStep(i);
            map.put(i, tmp);
            res = Math.max(res, tmp);
        }
        return res;
    }
}
