package BinaryTree;

public class BTNode {

    int data;
    BTNode left;
    BTNode right;
    BTNode parent;

    BTNode(int data) {
        this.data = data;
        left = null;
        right = null;
        parent = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

    public void setParent(BTNode parent) {
        this.parent = parent;
    }

    public int getData() {
        return data;
    }

    public BTNode getLeft() {
        return left;
    }

    public BTNode getRight() {
        return right;
    }

    public BTNode getParent() {
        return parent;
    }

}
