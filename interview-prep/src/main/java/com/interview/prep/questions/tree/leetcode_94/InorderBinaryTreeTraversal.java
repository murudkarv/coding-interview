package com.interview.prep.questions.tree.leetcode_94;
//Leetcode_94
//Given the root of a binary tree, return the inorder traversal of its nodes' values.
//
//
//
//        Example 1:
//
//        Input: root = [1,null,2,3]
//
//        Output: [1,3,2]
//
//        Explanation:
//
//
//
//        Example 2:
//
//        Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
//
//        Output: [4,2,6,5,7,1,3,9,8]
//
//        Explanation:
//
//
//
//        Example 3:
//
//        Input: root = []
//
//        Output: []
//
//        Example 4:
//
//        Input: root = [1]
//
//        Output: [1]
//
//
//
//        Constraints:
//
//        The number of nodes in the tree is in the range [0, 100].
//        -100 <= Node.val <= 100

import com.interview.prep.questions.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static com.interview.prep.questions.tree.TreeNode.buildTree;

public class InorderBinaryTreeTraversal {
    public InorderBinaryTreeTraversal() {
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        traverse(root, output);
        return output;
    }
    public void traverse(TreeNode root, List<Integer> output){
        if(root == null) return;
        traverse(root.left, output);
        output.add(root.val);
        traverse(root.right, output);
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,null,8,null,null,6,7,9};

        Integer[] arr1 = {};
        Integer[] arr2 = {1};
        Integer[] arr3 = {1,null,2,3};

        InorderBinaryTreeTraversal inorderBinaryTreeTraversal = new InorderBinaryTreeTraversal();
        System.out.println(inorderBinaryTreeTraversal.inorderTraversal(buildTree(arr)));
        System.out.println(inorderBinaryTreeTraversal.inorderTraversal(buildTree(arr1)));
        System.out.println(inorderBinaryTreeTraversal.inorderTraversal(buildTree(arr2)));
        System.out.println(inorderBinaryTreeTraversal.inorderTraversal(buildTree(arr3)));
    }
}
