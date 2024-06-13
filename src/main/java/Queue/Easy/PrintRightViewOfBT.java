package Queue.Easy;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
check level by level and print the last element of each level
 */
public class PrintRightViewOfBT {

    public void getRightView(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {

                TreeNode currNode = q.poll();
                //last node of current level
                if (i == level-1) {
                    System.out.println(currNode.data);
                }

                if(currNode.left!=null) {
                    q.add(currNode.left);
                }
                if(currNode.right!=null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {

        PrintRightViewOfBT p = new PrintRightViewOfBT();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        // Print the right view of the binary tree
        System.out.println("Right view of the binary tree: ");
        p.getRightView(root);

    }
}

class TreeNode {
    public int data;
    public TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
