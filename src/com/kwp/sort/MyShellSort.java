/**
 * Shell排序：
 * 	分组（缩小增量）插入排序算法，不稳定
 * 	关键：将待排数据进行分组，不断的使用插入排序
 * 	概念：h序列  h=3*h+1(该序列从1开始) 1，4，
 */
package com.kwp.sort;

/**
 * @author Weiping
 *
 */
public class MyShellSort extends MyAbstractSort implements MySort {

	/**
	 * 
	 */
	public MyShellSort() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param list
	 */
	public MyShellSort(int[] list) {
		super(list);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kwp.sort.MyAbstractSort#sort()
	 */
	@Override
	public void sort() {
		shellSort(list);

	}

	private void shellSort(int[] data) {
		// 计算出最大的h值
		int h = 1;
		while (h <= data.length / 3) {
			h = h * 3 + 1;
		}
		while (h > 0) {
			for (int i = h; i < data.length; i += h) {
				if (data[i] < data[i - h]) {
					int tmp = data[i];
					int j = i - h;
					while (j >= 0 && data[j] > tmp) {
						data[j + h] = data[j];
						j -= h;
					}
					data[j + h] = tmp;

				}
			}
			// 计算出下一个h值
			h = (h - 1) / 3;
		}
	}

}
