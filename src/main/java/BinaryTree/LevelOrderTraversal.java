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
        System.out.println(res);
    }

    private static List<List<Integer>> gatherLevel(BTNode root) {

        List<List<Integer>> output = new ArrayList<>();

        if(root == null) {
            return output;
        }

        Queue<BTNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();

            int size = q.size();

            for (int i=0;i<size;i++) {
                BTNode rem = q.poll();

                if (rem.left != null) {
                    q.add(rem.left);
                }

                if(rem.right != null) {
                    q.add(rem.right);
                }
                currLevel.add(rem.data);
            }

            output.add(currLevel);
        }

        return output;

    }
}
