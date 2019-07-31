package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by aiya on 2019/7/30 下午4:56
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while (size != 0) {
                TreeNode out = queue.poll();
                --size;
                tmp.add(out.val);
                if (out.left != null)
                    queue.add(out.left);
                if (out.right != null)
                    queue.add(out.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
