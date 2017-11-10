package cn.dubby.tree.postorder;

import cn.dubby.tree.TreeNode;
import cn.dubby.tree.TreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by teeyoung on 17/11/10.
 * <p>
 * 后序遍历，左->右->根
 */
public class PostOrder<T> implements TreeTraversal<T> {

    @Override
    public List<T> travelWithoutRecursion(TreeNode<T> tree) {
        List<T> result = new ArrayList<>();
        Stack<TreeNode<T>> stack = new Stack<>();

        TreeNode<T> currentNode = tree;
        TreeNode<T> lastNode = null;

        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.getLeft();
        }

        while (!stack.empty()) {
            currentNode = stack.pop();

            //只有“当前节点”没有右孩子或者右孩子已经被访问过了，才可以访问“当前节点”
            if (currentNode.getRight() == null || currentNode.getRight() == lastNode) {
                result.add(currentNode.getValue());
                lastNode = currentNode;
            } else {
                stack.push(currentNode);
                currentNode = currentNode.getRight();
                while (currentNode != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.getLeft();
                }
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

        if (tree.getRight() != null)
            doTravelRecursion(tree.getRight(), result);

        result.add(tree.getValue());
    }
}
