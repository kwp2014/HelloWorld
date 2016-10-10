package com.kwp.acmcoder;
import java.util.Scanner;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
        while(cin.hasNext())
        {
        	String in = cin.nextLine();
            
            
            String out = longestPalindrome(in);
           // System.out.println(out);
            System.out.println(out.length());

        }


	}

	private static String longestPalindrome(String s) {
		if(s.length()==1){
            return s;
        }
		char[] str = s.toCharArray();
		int length = str.length;
		int[] radiuses = new int[length];

		int max = 0;
		int index = 0;
		for (int i = 0; i < length; i++) {
			radiuses[i] = calcuRadius(str, i);
			if (radiuses[i] > max) {
				max = radiuses[i];
				index = i;
			}
		}
		if(max == 0){
			return s.substring(0,1);
		}
		return s.substring(index - max, index + max +1);
	}

	/**
	 * 计算半径
	 */
	private static int calcuRadius(char[] str, int index) {
		if (index < 1) {
			return 0;
		}
		int length = str.length;
		int radius = 0;

		boolean flag = true;
		while (flag) {
			if(index - radius >= 0 && index + radius < length){
				if (str[index - radius] == str[index + radius]) {
					radius++;
				} else {
					radius --;
					break;
				}
			}else{
				radius --;
				flag = false;
			}
			
		}

		return radius;
	}
}
