package LeetCode;

/**
 * Created by aiya on 2019/8/20 上午9:02
 * 实现在字符串A中找出字符串B出现的第一个位置   kmp算法
 * 如果不存在返回-1
 */
public class strStr28 {
    public int strStr(String haystack, String needle) {
        int len = haystack.length();
        int[] next = getNext(needle);
        int i = 0, j = 0;
        while(i<haystack.length() && j < needle.length()){
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if (j == needle.length())
            return i - j;
        else
            return -1;
    }
    public int[] getNext(String needle){
        int len = needle.length();
        int[] next = new int[len+1];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < len){
            if (j == -1 || needle.charAt(i) == needle.charAt(j)){
                ++i;
                ++j;
                next[i] = j;
            }else {
                j = next[j];
            }
        }
        return next;
    }
}
