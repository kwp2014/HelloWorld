/**
 * 选择排序的实现：
 * 	每次在无序中选择一个最小的数放在指定位置
 */
package com.kwp.sort;

/**
 * @author Weiping
 *
 */
public class MyChooseSort extends MyAbstractSort implements MySort {

	public MyChooseSort(){
		
	}
	
	public MyChooseSort(int[] list){
		super(list);
	}
	
	/* (non-Javadoc)
	 * @see com.kwp.sort.MyAbstractSort#sort()
	 */
	@Override
	public void sort() {
		for(int i=0;i<list.length;i++){
			for(int j=i;j<list.length;j++){
				if(list[j]<list[i]){
					swap(list,i,j);
				}
			}
		}

	}

}
