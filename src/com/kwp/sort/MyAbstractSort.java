package com.kwp.sort;

public abstract class MyAbstractSort implements MySort {
	
	/**
	 * ÅÅÐòÖ÷·½·¨
	 */
	public void sort(){
		
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 */
	public static void swap(int a,int b){
		int temp = a;
		a = b;
		b = temp;
	}
	
}
