/**
 * 快速排序的实现：
 * 	关键字：pivot(枢轴)
 * 	改进的冒泡排序
 */
package com.kwp.sort;

/**
 * @author Weiping
 *
 */
public class MyQuickSort extends MyAbstractSort implements MySort {

	/**
	 * 
	 */
	public MyQuickSort() {

	}

	/**
	 * @param list
	 */
	public MyQuickSort(int[] list) {
		super(list);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kwp.sort.MyAbstractSort#sort()
	 */
	@Override
	public void sort() {
		if(list.length>0){
			quickSort(list,0,list.length-1);
		}
	}

	private void quickSort(int[] list, int low, int high) {
		if (low < high) {
			int middle = partition(list, low, high);

			quickSort(list, low, middle-1);
			quickSort(list, middle + 1, high);
		}

	}

	/**
	 * 将数组一分为二
	 * 
	 * @param list
	 * @param low
	 * @param high
	 * @return
	 */
	private int partition(int[] list, int low, int high) {

		int pivot = list[low];

		while (low < high) {
			while (low < high && list[high] >= pivot) {
				high--;
			}

			list[low] = list[high];

			while (low < high && list[low] <= pivot) {
				low++;
			}

			list[high] = list[low];

		}

		list[low] = pivot;

		return low;
	}

}
