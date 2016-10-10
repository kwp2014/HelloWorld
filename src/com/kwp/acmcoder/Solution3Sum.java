package com.kwp.acmcoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3Sum {

	public static void main(String[] args) {
		int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9
		               ,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,
		               -5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,
		               5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,
		               -1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,
		               8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		
		List<List<Integer>> result = threeSum(nums);
		//System.out.println(result);
		
		short s = 1;
		s += 1;
		System.out.println(s);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int length = nums.length;
        if (length < 3) {
            return result;
        }
        Arrays.sort(nums);
        
        int match = -1; //索引号
        for(int i=0;i<length-1;i++){
            for(int j=i+1;j<length;j++){
                if(isExist(nums[i],nums[j],result)){  //过滤重复元组
                    continue;
                }
                match = findMatch(-(nums[i]+nums[j]),nums,i,j);
                if(match == -1){
                    continue;
                }else{
                    ArrayList<Integer> threeSum = new ArrayList<Integer>();
                    int max = Math.max(Math.max(nums[i],nums[j]),-(nums[i]+nums[j]));
                    int min = Math.min(Math.min(nums[i],nums[j]),-(nums[i]+nums[j]));
                    int mid = -(max+min);
                    threeSum.add(min);   
                    threeSum.add(mid);
                    threeSum.add(max);     // 从小到大排序
                    result.add(threeSum);
                }
            }
        }
        
        
        return result;
    }
    
    public static boolean isExist(int a,int b,List<List<Integer>> result){
        if(result.size() == 0){
            return false;
        }
        
        int max = Math.max(Math.max(a,b),-(a+b));
        int min = Math.min(Math.min(a,b),-(a+b));
        int mid = -(max+min);
        for(List<Integer> list:result){
            if(min== list.get(0) && mid==list.get(1) && max == list.get(2)){
                return true;
            }
        }
        
        return false;
    }
    
    /** 
     * nums已经排序
     */
    public static int findMatch(int a,int[] nums,int i,int j){
        int length = nums.length;

        
        for(int k=0;k<length;k++){
            if(k!=i && k!=j && a==nums[k]){
                return k;
            }
            if(nums[k]>a){
                break;
            }
        }
        
        return -1;
    }
}
