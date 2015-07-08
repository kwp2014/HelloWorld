/**
 * Shell����
 * 	���飨��С���������������㷨�����ȶ�
 * 	�ؼ������������ݽ��з��飬���ϵ�ʹ�ò�������
 * 	���h����  h=3*h+1(�����д�1��ʼ) 1��4��
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
		// ���������hֵ
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
			// �������һ��hֵ
			h = (h - 1) / 3;
		}
	}

}
