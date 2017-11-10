package cn.dubby.tree.ignore;

import cn.dubby.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 此类是作者自己不参考原来的代码，自己练习使用，请忽略
 * Created by teeyoung on 17/11/10.
 */
public class MyTest {

    /**
     *          1
     *    2             3
     * 4     5       6    7
     */
    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode<>();
        root.setValue("1");

        TreeNode<String> node1 = new TreeNode<>();
        node1.setValue("2");
        root.setLeft(node1);

        TreeNode<String> node1_1 = new TreeNode<>();
        node1_1.setValue("4");
        node1.setLeft(node1_1);

        TreeNode<String> node1_2 = new TreeNode<>();
        node1_2.setValue("5");
        node1.setRight(node1_2);

        TreeNode<String> node2 = new TreeNode<>();
        node2.setValue("3");
        root.setRight(node2);

        TreeNode<String> node2_1 = new TreeNode<>();
        node2_1.setValue("6");
        node2.setLeft(node2_1);

        TreeNode<String> node2_2 = new TreeNode<>();
        node2_2.setValue("7");
        node2.setRight(node2_2);

        System.out.println("先序遍历\t\t" + String.join(", ", preOrder(root)));
        System.out.println("中序遍历\t\t" + String.join(", ", inOrder(root)));
        System.out.println("后序遍历\t\t" + String.join(", ", postOrder(root)));

    }

    public static List<String> postOrder(TreeNode<String> tree) {
        List<String> result = new ArrayList<>();
        if (tree == null)
            return result;

        Stack<TreeNode<String>> stack = new Stack<>();
        TreeNode<String> currentNode = tree;
        TreeNode<String> lastNode = tree;

        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.getLeft();
        }

        while (!stack.empty()) {
            currentNode = stack.pop();
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

    public static List<String> inOrder(TreeNode<String> tree) {
        List<String> result = new ArrayList<>();
        if (tree == null)
            return result;

        Stack<TreeNode<String>> stack = new Stack<>();
        TreeNode<String> node = tree;

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

    public static List<String> preOrder(TreeNode<String> tree) {
        List<String> result = new ArrayList<>();
        if (tree == null)
            return result;

        Stack<TreeNode<String>> stack = new Stack<>();
        stack.push(tree);

        while (!stack.empty()) {
            TreeNode<String> node = stack.pop();
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


}
