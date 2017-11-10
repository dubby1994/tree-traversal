package cn.dubby.tree.preorder;

import cn.dubby.tree.TreeNode;
import cn.dubby.tree.TreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by teeyoung on 17/11/10.
 *
 * 先序遍历，根->左->右
 */
public class PreOrder<T> implements TreeTraversal<T> {

    /**
     * 非递归遍历
     *
     * @param tree
     * @return
     */
    public List<T> travelWithoutRecursion(TreeNode<T> tree) {
        List<T> result = new ArrayList<>();
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(tree);

        while (!stack.empty()) {
            TreeNode<T> node = stack.pop();
            result.add(node.getValue());

            if (node.getRight() != null) {
                stack.push(node.getRight());
            }

            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }

        return result;
    }

    /**
     * 递归遍历
     *
     * @param tree
     * @return
     */
    public List<T> travelWithRecursion(TreeNode<T> tree) {
        List<T> result = new ArrayList<>();
        doTravelRecursion(tree, result);
        return result;
    }

    private void doTravelRecursion(TreeNode<T> tree, List<T> result) {
        if (tree == null)
            return;

        result.add(tree.getValue());

        if (tree.getLeft() != null)
            doTravelRecursion(tree.getLeft(), result);

        if (tree.getRight() != null)
            doTravelRecursion(tree.getRight(), result);
    }

}
