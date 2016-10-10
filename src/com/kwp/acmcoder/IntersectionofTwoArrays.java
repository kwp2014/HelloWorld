package com.kwp.acmcoder;

public class IntersectionofTwoArrays {

	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		int[] result = intersect(nums1,  nums2);
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]+" ");
		}
		

	}

public static int[] intersect(int[] nums1, int[] nums2) {
        
        if (nums1.length == 0 || nums2.length == 0){
        	return new int[0];
        }
        
        int size_nums1 = nums1.length;
        int size_nums2 = nums2.length;
        int[] resultFlag = new int[size_nums2];
        int[] flag = new int[size_nums1];
        int num = 0;
        for(int i=0;i<size_nums2;i++){
            for(int j=0; j<size_nums1;j++){
            	if(flag[j]==1){
            		continue;
            	}
                if(nums2[i] == nums1[j]){
                    flag[j] = 1;
                    resultFlag[i] = 1;
                    num ++;
                    break;
                }
            }
        }
        if(num == 0){
        	return new int[0];
        }else{
            int[] result = new int[num];
            int k=0;
            for(int i=0;i<size_nums2;i++){
                if(resultFlag[i]==1){
                    result[k] = nums2[i];
                    k++;
                }
            }
            return result;
        }
        
        
    }
}
