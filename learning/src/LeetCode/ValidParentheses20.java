package LeetCode;

import java.util.Stack;

/**
 * Created by aiya on 2019/7/30 下午5:26
 */
public class ValidParentheses20 {
    public boolean isValid(String s) {
        int len = s.length();
        if (len == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++){
            char tmp = s.charAt(i);
            if (tmp == '(' || tmp == '[' || tmp == '{')
                stack.push(tmp);
            else if (tmp == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            }else if (tmp == ']'){
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            }else{//}
                if (!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
