package cn.dubby.tree.inorder;

import cn.dubby.tree.TreeNode;
import cn.dubby.tree.TreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by teeyoung on 17/11/10.
 * <p>
 * 中序遍历，左->根->右
 */
public class InOrder<T> implements TreeTraversal<T> {

    @Override
    public List<T> travelWithoutRecursion(TreeNode<T> tree) {
        List<T> result = new ArrayList<>();
        Stack<TreeNode<T>> stack = new Stack<>();

        TreeNode<T> node = tree;

        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }

            if (!stack.empty()) {
                node = stack.pop();
                result.add(node.getValue());
                node = node.getRight();
            }
        }

        return result;
    }

    @Override
    public List<T> travelWithRecursion(TreeNode<T> tree) {
        List<T> result = new ArrayList<>();
        doTravelRecursion(tree, result);
        return result;
    }

    private void doTravelRecursion(TreeNode<T> tree, List<T> result) {
        if (tree == null)
            return;

        if (tree.getLeft() != null)
            doTravelRecursion(tree.getLeft(), result);

        result.add(tree.getValue());

        if (tree.getRight() != null)
            doTravelRecursion(tree.getRight(), result);

    }
}
