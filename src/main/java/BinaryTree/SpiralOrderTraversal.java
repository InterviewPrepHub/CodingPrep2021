package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SpiralOrderTraversal {

    public static void main(String[] args) {

        BTNode root = new BTNode(15);
        root.left = new BTNode(10);
        root.right = new BTNode(20);
        root.left.left = new BTNode(8);
        root.left.right = new BTNode(12);
        root.right.left = new BTNode(16);
        root.right.right = new BTNode(25);

        int ht = height(root);
        System.out.println(ht);

        System.out.println();
        System.out.println("Sprial order");

//        levelOrderTraversal(root);

//        levelOrderTraversalWithQueue(root);

        spiralOrderTraversal(root);
    }

    private static void spiralOrderTraversal(BTNode root) {
        if (root == null) {
            return;
        }

        Deque<BTNode> deque = new LinkedList<>();
        deque.addFirst(root); //add in front of queue
        boolean flag = true;

        while (!deque.isEmpty()) {

            int nodeCount = deque.size();

            if (flag) {
                while (nodeCount > 0) {
                    // pop from the front if `flag` is true
                    BTNode curr = deque.pollFirst();
                    System.out.print(curr.data + " ");

                    // it is important to push the left child into the back,
                    // followed by the right child

                    if (curr.left != null) {
                        //Insert at the end of queue
                        deque.addLast(curr.left);
                    }

                    if (curr.right != null) {
                        deque.addLast(curr.right);
                    }

                    nodeCount--;
                }
            }

            // print right to left
            else {
                // process each node of the current level and enqueue their
                // non-empty right and left child
                while (nodeCount > 0) {
                    // it is important to pop from the back
                    BTNode curr = deque.pollLast();
                    System.out.print(curr.data + " ");    // print front node

                    // it is important to push the right child at the front,
                    // followed by the left child

                    if (curr.right != null) {
                        deque.addFirst(curr.right);
                    }

                    if (curr.left != null) {
                        deque.addFirst(curr.left);
                    }

                    nodeCount--;
                }
            }

            // flip the flag for the next level
            flag = !flag;
            System.out.println();
        }
    }

    private static int height(BTNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHt = height(root.left);
            int rightHt = height(root.right);

            if (leftHt > rightHt) {
                return leftHt+1;
            } else {
                return rightHt+1;
            }
        }
    }

    private static void levelOrderTraversal(BTNode node) {
        int ht = height(node);
        for (int i=0;i<=ht;i++) {
            levelOrderTraversal(node, i);
        }
    }

    private static void levelOrderTraversal(BTNode root, int level) {
        if (root == null) {
            return;
        }
        if (level==1) {
            System.out.println(root.data);
        } else {
            levelOrderTraversal(root.left, level-1);
            levelOrderTraversal(root.right, level-1);
        }
    }

    private static void levelOrderTraversalWithQueue(BTNode root) {

        Queue<BTNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BTNode temp = q.poll();
            System.out.print(temp.data+" ");

            if (temp.left!=null) {
                q.add(temp.left);
            }

            if (temp.right!=null) {
                q.add(temp.right);
            }
        }
    }
    
}















