package cn.dubby.tree;

/**
 * Created by teeyoung on 17/11/10.
 */
public class TreeNode<T> {

    public TreeNode() {
    }

    public TreeNode(T value) {
        this.value = value;
    }

    private T value;

    private TreeNode<T> left;

    private TreeNode<T> right;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
