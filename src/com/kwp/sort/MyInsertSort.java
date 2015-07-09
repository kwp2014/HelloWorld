/**
 * ���������㷨ʵ��:
 * 	�����������������ļ�����
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
