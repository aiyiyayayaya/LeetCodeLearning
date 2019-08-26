package LeetCode;

/**
 * Created by aiya on 2019/8/21 下午6:14
 * 被除数和除数，将两数相除 不使用乘除和mod，返回商
 * 位运算？？？
 */
public class divide29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        long m = Math.abs((long)dividend), n = Math.abs((long)divisor), res = 0;
        int sign = (dividend < 0) ^(divisor < 0) ? -1 : 1;
        while (m >= n){
            long t = n, p = 1;
            while (m >= (t << 1)){
                t <<= 1;
                p <<= 1;
            }
            res += p;
            m -= t;
        }
        return sign == 1 ? (int)res : (int)-res;
    }
}
