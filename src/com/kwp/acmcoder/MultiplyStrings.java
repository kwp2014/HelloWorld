package com.kwp.acmcoder;
import java.util.Scanner;

/**
 * 大数乘法:
 * 非负
 */
public class MultiplyStrings {

	public static void main(String[] args) {
		System.out.print(">> ");
		Scanner scaner = new Scanner (System.in);
		String input = scaner.nextLine();
		scaner.close();
		System.out.println(input);
		String[] str = input.split(" ");
		String output = multiply(str[0],str[1]);
		System.out.println(output);

		char a= '9';
		int b = a - '0';
		System.out.println(b);
	}

	
	public static String multiply(String num1, String num2) {
		char[] c1 = inverseString(num1).toCharArray();
		char[] c2 = inverseString(num2).toCharArray();
		
		int[] result = new int[c1.length+c2.length];
		int bitFlag = 0;
		for(int i=0;i<c1.length;i++){
			for(int j=0;j<c2.length;j++){
				int temp = (c2[j]-'0')*(c1[i]-'0');
				bitFlag = temp/10;
				result[i+j] += temp - bitFlag*10;
				result[i+j+1] += bitFlag;
				if(result[i+j]>9){
					bitFlag = result[i+j]/10;
					result[i+j] -= bitFlag*10;
					result[i+j+1] += bitFlag;
				}
				if(result[i+j+1]>9){
					bitFlag = result[i+j+1]/10;
					result[i+j+1] -= bitFlag*10;
					result[i+j+1+1] += bitFlag;
				}
			}
			
			bitFlag = 0;
		}
		
		String output = "";
		boolean flag = true;
		for(int i=result.length-1;i>=0;i--){
			if(result[i] == 0 && flag){
				continue;
			}else{
				flag = false;
			}
			output +=result[i];
		}
		
		if(output == ""){
		    output += "0";
		}
		
		return output;
        
    }


	private static String inverseString(String str) {
		String result = "";
		for(int i=0;i<str.length();i++){
			result += str.charAt(str.length() -i-1);
		}
		return result;
	}
}
