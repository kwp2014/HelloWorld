package com.kwp.acmcoder;

public class Permutation {

	public static void main(String[] args) {
		String s = "abc";
		char[] str = s.toCharArray();
		permutation(str,0);

	}
	
	/**
	 * 求所有的组合
	 * 第一步：求所有可能出现在第一个位置的字符
	 * 第二步：固定第一个字符，求后面所有字符的排列
	 * @param str 
	 * @param begin  将数组分为两个部分  分界线
	 */
	private static void permutation(char[] str,int begin){
		if(begin == str.length-1){
			System.out.println(str);
		}else{
			for(int curr= begin;curr<str.length;curr++){
				
				// 第一步：求所有可能出现在第一个位置的字符 ,即第一次交换
				
				char temp = str[curr];
				str[curr] = str[begin];
				str[begin]= temp;
				
				// 第二步：固定第一个字符，求后面所有字符的排列
				permutation(str,begin+1);
				
				// 保证第一个字符都不一样
				temp = str[curr];
				str[curr] = str[begin];
				str[begin]= temp;
				System.out.println("当前状态:"+str[0]+str[1]+str[2]);
			}
		}
		
	}

}
