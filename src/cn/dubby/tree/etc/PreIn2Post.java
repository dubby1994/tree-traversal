package cn.dubby.tree.etc;

import cn.dubby.tree.TreeNode;
import cn.dubby.tree.postorder.PostOrder;

import java.util.List;

/**
 * Created by teeyoung on 17/11/14.
 * 根据前序遍历，中序遍历，确定后序遍历
 */
public class PreIn2Post {


    public static void main(String[] args) {
        //前序遍历
        final String[] preOrder = {"G", "D", "A", "F", "E", "M", "H", "Z"};
        System.out.println("前序遍历:" + String.join(", ", preOrder));
        //中序遍历
        final String[] inOrder = {"A", "D", "E", "F", "G", "H", "M", "Z"};
        System.out.println("中序遍历:" + String.join(", ", inOrder));

        System.out.println("后序遍历:" + String.join(", ", getPostOrder1(preOrder, inOrder)));
    }

    /**
     * 算法2：算出树的结构
     *
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static String[] getPostOrder1(String[] preOrder, String[] inOrder) {
        currentPreLeft = 0;
        TreeNode<String> root = generateTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
        List<String> temp = new PostOrder<String>().travelWithRecursion(root);

        String[] result = new String[preOrder.length];
        return temp.toArray(result);
    }

    private static int currentPreLeft = 0;

    private static TreeNode<String> generateTree(String[] preOrder, int preLeft, int preRight, String[] inOrder, int inLeft, int inRight) {
        TreeNode<String> root = new TreeNode<>();
        root.setValue(preOrder[preLeft]);
        currentPreLeft++;

        int rootIndex = indexAt(inOrder, root.getValue());

        if (rootIndex > inLeft && rootIndex < inRight) {
            //根节点有左右子节点
            root.setLeft(generateTree(preOrder, currentPreLeft, preRight, inOrder, inLeft, rootIndex - 1));

            root.setRight(generateTree(preOrder, currentPreLeft, preRight, inOrder, rootIndex + 1, inRight));
        } else if (rootIndex > inLeft) {
            //根节点只有左子节点
            root.setLeft(generateTree(preOrder, currentPreLeft, preRight, inOrder, inLeft, rootIndex - 1));
        } else if (rootIndex < inRight) {
            //根节点只有右子节点
            root.setRight(generateTree(preOrder, currentPreLeft, preRight, inOrder, rootIndex + 1, inRight));
        }

        return root;
    }

    private static int indexAt(String[] strings, String str) {
        for (int i = 0; i < strings.length; ++i) {
            if (strings[i].equals(str))
                return i;
        }
        return -1;
    }


    /**
     * 算法2：不需要算树，直接输出后序遍历
     *
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static String[] getPostOrder2(String[] preOrder, String[] inOrder) {
        currentPreLeft = 0;
        String[] postOrder = new String[preOrder.length];
        postIndex = postOrder.length - 1;
        fillPostOrder(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, postOrder, postIndex);
        return postOrder;
    }

    private static int postIndex;

    private static void fillPostOrder(String[] preOrder, int preLeft, int preRight, String[] inOrder, int inLeft, int inRight, String[] postOrder, int postIndex) {
        postOrder[postIndex] = preOrder[preLeft];

        currentPreLeft++;
        postIndex--;

        int rootIndex = indexAt(inOrder, preOrder[preLeft]);

        if (rootIndex > inLeft && rootIndex < inRight) {
            //根节点有左右子节点
            fillPostOrder(preOrder, currentPreLeft, preRight, inOrder, inLeft, rootIndex - 1, postOrder, postIndex);
            fillPostOrder(preOrder, currentPreLeft, preRight, inOrder, rootIndex + 1, inRight, postOrder, postIndex);
        } else if (rootIndex > inLeft) {
            //根节点只有左子节点
            fillPostOrder(preOrder, currentPreLeft, preRight, inOrder, inLeft, rootIndex - 1, postOrder, postIndex);
        } else if (rootIndex < inRight) {
            //根节点只有右子节点
            fillPostOrder(preOrder, currentPreLeft, preRight, inOrder, rootIndex + 1, inRight, postOrder, postIndex);
        }

    }
}
