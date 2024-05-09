package Array.Palindrome;

import LinkedList.NodeLL;

/*
Given the head of a singly linked list, return true if it is a
palindrome or false otherwise.
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        NodeLL head = new NodeLL(1);
        head.next = new NodeLL(2);
        head.next.next = new NodeLL(2);
        head.next.next.next = new NodeLL(1);

        System.out.println(isPalindrome(head));
    }

    static NodeLL curr;

    //any problem which you can do using stack  can also be done using recursion
    private static boolean isPalindrome(NodeLL head) {

        curr = head;
        return solve(head);

    }

    private static boolean solve(NodeLL node) {
        if(node==null) {
            return true;
        }
        boolean ans = solve(node.next);

        ans = ans && node.data == curr.data;

        curr = curr.next;

        return ans;
    }
}
