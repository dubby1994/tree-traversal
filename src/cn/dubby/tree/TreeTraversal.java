package cn.dubby.tree;

import java.util.List;

/**
 * Created by teeyoung on 17/11/10.
 */
public interface TreeTraversal<T> {

    /**
     * 非递归遍历
     * @param treeNode
     * @return
     */
    List<T> travelWithoutRecursion(TreeNode<T> treeNode);

    /**
     * 递归遍历
     * @param treeNode
     * @return
     */
    List<T> travelWithRecursion(TreeNode<T> treeNode);

}
