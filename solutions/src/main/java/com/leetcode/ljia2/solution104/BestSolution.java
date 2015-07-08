package com.leetcode.ljia2.solution104;

import com.leetcode.ljia2.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BestSolution {
	public int maxDepth(TreeNode root) {
		if(root == null){ return 0; }
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
