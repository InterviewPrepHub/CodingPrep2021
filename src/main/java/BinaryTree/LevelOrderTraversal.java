package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        BTNode node = new BTNode(10);
        node.left = new BTNode(11);
        node.right = new BTNode(12);

        List<List<Integer>> res = gatherLevel(node);
        System.out.println(res);  // Output: [[10], [11, 12]]
    }

    private static List<List<Integer>> gatherLevel(BTNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root == null) {
            return output;
        }
        Queue<BTNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size(); // Get the current level size
            List<Integer> currLevel = new ArrayList<>();

            // Process all nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                BTNode rem = q.poll();
                currLevel.add(rem.data);

                // Add children of the removed node to the queue
                if (rem.left != null) {
                    q.add(rem.left);
                }
                if (rem.right != null) {
                    q.add(rem.right);
                }
            }
            output.add(currLevel);
        }
        return output;
    }
}
