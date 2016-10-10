package com.kwp.acmcoder;
import java.util.Scanner;
import java.util.Stack;

/**
 * 表达式计算 + -
 * 
 * @author Weiping
 *
 */
public class SparseCalcu {
	static Stack<String> postfixStack  = new Stack<String>();//后缀式栈
	static Stack<Character> opStack  = new Stack<Character>();//运算符栈
	
	public static void main(String[] args) {

	sparse("1+3/4-2");

		

	System.out.println(calculate());
	}
	
	private static String calculate(){
		while(postfixStack.size()>1){
			String s1 = postfixStack.pop();
			String s2 = postfixStack.pop();
			char sign = opStack.pop();
			if(sign=='+'){
				double temp = Double.parseDouble(s1) + Double.parseDouble(s2);
				postfixStack.push(String.valueOf(temp));
			}else if(sign=='-'){
				double temp = Double.parseDouble(s1) - Double.parseDouble(s2);
				postfixStack.push(String.valueOf(temp));
			}else if(sign=='*'){ // 精度问题
				double temp = Double.parseDouble(s1) * Double.parseDouble(s2);
				postfixStack.push(String.valueOf(temp));
			}else{ // 精度问题
				double temp = Double.parseDouble(s1) / Double.parseDouble(s2);
				postfixStack.push(String.valueOf(temp));
			}
		}
		return postfixStack.pop();
	}
	/**
	 * 表达式转换
	 * @param in
	 * @return
	 */
	private static void sparse(String in) {
		
		int i=0;
		for(;i<in.length();i++){
			if(isNumber(in.charAt(i))){
				postfixStack.push(in.substring(i, i+1));
			}else{
				if(!opStack.empty()){
					if(greater(in.charAt(i),opStack.peek())>0){
						opStack.push(in.charAt(i));
					}else{
						char temp = in.charAt(i);
						char c1 = opStack.pop();
						opStack.push(temp);
						opStack.push(c1);
						
						String s1 = postfixStack.pop();
						String s2 = postfixStack.pop();
						postfixStack.push(in.substring(i+1, i+2));
						postfixStack.push(s1);
						postfixStack.push(s2);
						i++;
						
					}
				}else{
					opStack.push(in.charAt(i));
				}
			}
		}
		
		
	}

	private static int greater(char c1, Character c2) {
		if((c1=='*' || c1=='/') && (c2=='+' ||c2=='-') ){
			return 1;
		}
		return 0;
	}

	private static boolean isNumber(char c) {
		if(c>='0' &&c <= '9'){
			return true;
		}
		return false;
	}

}
