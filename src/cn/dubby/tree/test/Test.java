package cn.dubby.tree.test;

import cn.dubby.tree.TreeNode;
import cn.dubby.tree.inorder.InOrder;
import cn.dubby.tree.postorder.PostOrder;
import cn.dubby.tree.preorder.PreOrder;

/**
 * Created by teeyoung on 17/11/10.
 */
public class Test {


    public static void main(String[] args) {
        TreeNode<String> root = prepareData();

        PreOrder<String> preOrder = new PreOrder<>();
        InOrder<String> inOrder = new InOrder<>();
        PostOrder<String> postOrder = new PostOrder<>();

        System.out.println("先序遍历\t\t" + String.join(", ", preOrder.travelWithoutRecursion(root)));
        System.out.println("先序遍历\t\t" + String.join(", ", preOrder.travelWithRecursion(root)));
        System.out.println();

        System.out.println("中序遍历\t\t" + String.join(", ", inOrder.travelWithoutRecursion(root)));
        System.out.println("中序遍历\t\t" + String.join(", ", inOrder.travelWithRecursion(root)));
        System.out.println();

        System.out.println("后序遍历\t\t" + String.join(", ", postOrder.travelWithoutRecursion(root)));
        System.out.println("后序遍历\t\t" + String.join(", ", postOrder.travelWithRecursion(root)));
        System.out.println();

    }

    /**
     *          1
     *    2             3
     * 4     5       6    7
     */
    private static TreeNode<String> prepareData() {
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

        return root;
    }

}
