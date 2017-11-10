package cn.dubby.tree.postorder;

import cn.dubby.tree.TreeNode;

import java.util.List;

/**
 * Created by teeyoung on 17/11/10.
 */
public class PostOrderTest {

    /**
     *              1
     *        2             3
     *     4     5       6    7
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

        List<String> resultWithRecursion = new PostOrder<String>().travelWithRecursion(root);
        System.out.println(String.join(", ", resultWithRecursion));
        List<String> resultWithoutRecursion = new PostOrder<String>().travelWithoutRecursion(root);
        System.out.println(String.join(", ", resultWithoutRecursion));
    }

}
