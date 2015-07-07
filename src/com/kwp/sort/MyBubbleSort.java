package com.kwp.sort;

public class MyBubbleSort extends MyAbstractSort implements MySort {

	private int[] list;
	
	public MyBubbleSort(){
	}
	
	public MyBubbleSort(int[] list){
		this.list = list;
	}
	
	@Override
	public void sort() {
		for(int k=1;k<list.length;k++){
			for(int i=0;i<list.length-k;i++){
				if(list[i] > list[i+1]){
					swap(list[i],list[i+1]);
				}
			}
		}

	}
	
	@Override
	public void print(){
		for(int i:list){
			System.out.print(i+",");
		}
	}

}
