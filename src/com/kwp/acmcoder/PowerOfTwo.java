package com.kwp.acmcoder;
import java.util.Scanner;

/**
 * Power of Two 
 * @author Weiping
 * @Date 4-19
 *
 */
public class PowerOfTwo {

	public static void main(String[] args) {
		System.out.println(">> ");
		Scanner scaner = new Scanner (System.in);
		int input = Integer.parseInt(scaner.nextLine());
		scaner.close();
		System.out.println(input);
		boolean output = isPowerOfTwo(input);
		System.out.println(output);
	}
	
	public static boolean isPowerOfTwo(int n) {
        return (n > 0) && (n&(n-1))==0;
    }

}
