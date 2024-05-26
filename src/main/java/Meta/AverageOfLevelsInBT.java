package Meta;

import BinaryTree.BTNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBT {

    public static void main(String[] args) {
        BTNode n1 = new BTNode(3);
        n1.left = new BTNode(9);
        n1.right = new BTNode(20);
        n1.right.left = new BTNode(7);
        n1.right.right = new BTNode(15);
    }

    public List<Double> avgOfLevels(BTNode root) {

        List<List<Integer>> output = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

    }
}
