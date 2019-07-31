package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aiya on 2019/7/30 下午9:59
 */
public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, "", res);
        return res;
    }
    public void dfs(int left, int right, String s, List<String> res){
        if (left > right)
            return;
        if (left == 0 && right == 0)
            res.add(s);
        else {
            if (left > 0)
                dfs(left - 1, right, s+"(", res);
            if (right > 0)
                dfs(left, right - 1, s+")", res);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses22 g = new GenerateParentheses22();
        g.generateParenthesis(3);
    }
}
