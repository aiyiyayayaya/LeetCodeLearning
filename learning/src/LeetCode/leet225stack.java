package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by aiya on 2019/8/30 上午10:33
 * 用队列实现栈:后进先出
 */
public class leet225stack {
    private Queue<Integer> in;
    private Queue<Integer> out;
    /** Initialize your data structure here. */
    public leet225stack() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        //in永远是空的
        in.offer(x);
        while(!out.isEmpty()){
            in.offer(out.poll());
        }
        //change
        Queue<Integer> tmp = in;
        in = out;
        out = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return out.poll();
    }

    /** Get the top element. */
    public int top() {
        return out.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return out.isEmpty();
    }
}
