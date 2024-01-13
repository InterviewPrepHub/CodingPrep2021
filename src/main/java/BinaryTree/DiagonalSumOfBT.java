package BinaryTree;

import java.util.*;

/*
We can easily solve this problem with the help of hashing. The idea is to create an empty map where each key in the map
represents a diagonal in the binary tree, and its value maintains the sum of all nodes present in the diagonal. Then
perform a preorder traversal on the tree and update the map. For each node, recur for its left subtree by increasing the
diagonal by one and recur for the right subtree with the same diagonal.

 */
public class DiagonalSumOfBT {

    public static void diagonalSum (BTNode root) {

        //create a map
        Map<Integer, Integer> map = new HashMap<>();

        diagonalSum(root, 0, map);
        System.out.println(map.values());
    }
    
    public static void diagonalSum(BTNode node, int diagonal, Map<Integer, Integer> map) {

        if (node == null) return ;

        map.put(diagonal, map.getOrDefault(diagonal,0)+node.data);

        diagonalSum(node.left, diagonal+1, map);

        diagonalSum(node.right, diagonal, map);
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.right.left = new BTNode(5);
        root.right.right = new BTNode(6);
        root.right.left.left = new BTNode(7);
        root.right.left.right = new BTNode(8);
        diagonalSum(root);
    }
}
