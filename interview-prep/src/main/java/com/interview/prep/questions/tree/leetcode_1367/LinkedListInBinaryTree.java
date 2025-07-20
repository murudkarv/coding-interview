package com.interview.prep.questions.tree.leetcode_1367;

//Leetcode 1367
//Given a binary tree root and a linked list with head as the first node.
//
//Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.
//
// In this context downward path means a path that starts at some node and goes downwards.

//Example 1:
//Input: head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
//Output: true
//Explanation: Nodes in blue form a subpath in the binary Tree.

//Example 2:
//Input: head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
//Output: true

//Example 3:
//
//Input: head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
//Output: false
//Explanation: There is no path in the binary tree that contains all the elements of the linked list from head.

//Constraints:
//
//The number of nodes in the tree will be in the range [1, 2500].
//The number of nodes in the list will be in the range [1, 100].
//1 <= Node.val <= 100 for each node in the linked list and binary tree.

import com.interview.prep.questions.tree.ListNode;
import com.interview.prep.questions.tree.TreeNode;

public class LinkedListInBinaryTree {
    public boolean isSubPath(ListNode head, TreeNode root){

        if(root == null)
            return false;
        return depthFirstSearch(head, root) || isSubPath(head, root.getLeft()) || isSubPath(head, root.getRight());


    }

    public boolean depthFirstSearch(ListNode head, TreeNode node){
        if(head == null)
            return true; // List got empty because everything matched
        if(node == null)
            return false; // Tree path ended before list
        if(head.getVal() != node.getVal())
            return false;
        //Go left first and then right for depth
        return depthFirstSearch(head.getNext(), node.getLeft()) || depthFirstSearch(head.getNext(), node.getRight());
    }

    public static void main(String[] args) {
        Integer[] list = {4,2,8};
        Integer[] list1 = {1,4,2,6};
        Integer[] list2 = {1,4,2,6,8};
        Integer[] tree = {1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3};
        Integer[] tree1 = {1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3};
        Integer[] tree2 = {1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3};

        LinkedListInBinaryTree linkedListInBinaryTree = new LinkedListInBinaryTree();
        System.out.println(linkedListInBinaryTree.isSubPath(ListNode.buildList(list), TreeNode.buildTree(tree)));
        System.out.println(linkedListInBinaryTree.isSubPath(ListNode.buildList(list1), TreeNode.buildTree(tree1)));
        System.out.println(linkedListInBinaryTree.isSubPath(ListNode.buildList(list2), TreeNode.buildTree(tree2)));
    }
}
