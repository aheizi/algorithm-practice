package com.aheizi.tree;

import com.aheizi.tree.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangquan1 on 2019-08-31.
 * <p>
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeInorderTraversal {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public void helper(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                helper(root.right, result);
            }
        }
    }

    /**
     * 基于栈的遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // 到达最左节点
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 左节点全部遍历完毕
            current = stack.pop();
            result.add(current.val);

            // 开始右节点
            current = current.right;
        }

        return result;
    }

    /**
     * 莫里斯遍历
     * <p>
     * 非递归且不用额外空间不用栈遍历二叉树
     * https://stackoverflow.com/questions/5502916/explain-morris-inorder-tree-traversal-without-using-stacks-or-recursion
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            } else {
                // find the rightmost
                TreeNode rightmost = current.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                rightmost.right = current;

                TreeNode temp = current;
                current = current.left;
                temp.left = null;
            }
        }

        return result;
    }


}
