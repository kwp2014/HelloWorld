package com.kwp.sort;

public class MyBubbleSort extends MyAbstractSort implements MySort {

	//private int[] list;
	
	public MyBubbleSort(){
	}
	
	public MyBubbleSort(int[] list){
		super(list);
	}
	
	@Override
	public void sort() {
		for(int k=1;k<list.length;k++){ // ð�ݵĴ�������
			for(int i=0;i<list.length-k;i++){// ÿһ��ð�ݵĳ��ȿ���
				if(list[i] > list[i+1]){
					swap(list,i,i+1);
				}
			}
		}

	}
	
	

}
