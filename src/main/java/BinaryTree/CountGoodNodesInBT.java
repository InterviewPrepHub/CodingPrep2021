package BinaryTree;

public class CountGoodNodesInBT {

    public static void main(String[] args) {
        BTNode root = new BTNode(3);
        root.left = new BTNode(1);
        root.left.left = new BTNode(3);
        root.right = new BTNode(4);
        root.right.left = new BTNode(1);
        root.right.right = new BTNode(5);
        
        CountGoodNodesInBT c = new CountGoodNodesInBT();
        int max_val = root.data;
        
        int res = c.getGoodNodes(root, max_val);
        System.out.println(res);
    }

    private int getGoodNodes(BTNode root, int max_val) {

        if (root == null) {
            return 0;
        }

        int count = 0;

        if (max_val <= root.data) {
            count++;
            max_val = Math.max(max_val,root.data);
        }


        count+=getGoodNodes(root.left,max_val);
        count+=getGoodNodes(root.right,max_val);

        return count;
    }
}
