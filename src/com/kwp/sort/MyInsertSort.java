/**
 * 插入排序算法实现:
 * 	将无序的数插入有序的集合中
 */
package com.kwp.sort;

/**
 * @author Weiping
 *
 */
public class MyInsertSort extends MyAbstractSort implements MySort {

	public MyInsertSort() {
	}

	public MyInsertSort(int[] list) {
		super(list);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kwp.sort.MyAbstractSort#sort()
	 */
	@Override
	public void sort() {
		for (int i = 1; i < list.length; i++) {
			for (int j = i; j > 0; j--) {
				if (list[j] < list[j - 1]) {
					swap(list, j, j - 1);
				}
			}
		}

	}

}
