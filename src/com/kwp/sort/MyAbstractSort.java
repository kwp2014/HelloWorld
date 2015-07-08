package com.kwp.sort;

public abstract class MyAbstractSort implements MySort {
	
	protected int[] list;
	
	public MyAbstractSort(){
	}
	
	public MyAbstractSort(int[] list){
		this.list = list;
	}
	/**
	 * ÅÅÐòÖ÷·½·¨
	 */
	public abstract void sort();
	
	/**
	 * 
	 * @param a
	 * @param b
	 */
	public void swap(int[] list,int a,int b){
		int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	}
	
	@Override
	public void print(){
		for(int i:list){
			System.out.print(i);
			if(i != list[list.length-1]){
				System.out.print(",");
			}else{
				System.out.print("\n");
			}
		}
	}
	
}
