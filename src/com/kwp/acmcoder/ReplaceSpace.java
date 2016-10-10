package com.kwp.acmcoder;
import java.util.Scanner;

public class ReplaceSpace {

	public static void main(String[] args) {
		StringBuffer str = new StringBuffer(" 123 456  789 ");
		System.out.println(replaceSpace(str));
		Scanner scan = new Scanner(System.in);
		String ss = scan.nextLine();
		System.out.println(ss);

	}
	
	public static String replaceSpace(StringBuffer str) {
		StringBuffer out=new StringBuffer();
        for (int i = 0; i < str.toString().length(); i++) {
            char b=str.charAt(i);
            if(String.valueOf(b).equals(" ")){
                out.append("%20");
            }else{
                out.append(b);
            }
        }
        return out.toString();  
		
    }

	
}

