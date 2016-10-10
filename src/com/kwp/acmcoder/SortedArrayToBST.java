package com.kwp.acmcoder;

public class SortedArrayToBST {

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,5};
		print(sortedArrayToBST(nums));

	}

	private static void print(TreeNode root) {		
		preOrder(root);
	}

	private static void preOrder(TreeNode root){
		if(root == null){
			return;
		}
		System.out.print(root.val+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    
    private static TreeNode sortedArrayToBST(int[] nums,int start,int end){
        if(end - start < 0){
            return null;
        }
        int medium = (end+start)/2;
        TreeNode root = new TreeNode(nums[medium]);
        root.left = sortedArrayToBST(nums,start,medium-1);
        root.right = sortedArrayToBST(nums,medium+1,end);

        return root;
    }
	
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
