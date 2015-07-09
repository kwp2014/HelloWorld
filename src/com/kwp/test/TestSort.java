package com.kwp.test;

import java.util.Random;

import com.kwp.sort.*;

public class TestSort {

	public static void main(String[] args) {

		// int[] list = {1,2,33,4,5,6,77,3,22};

		Random random = new Random();
		int num = 20;
		int a[] = new int[num];
		for (int i = 0; i < num; i++) {
			a[i] = random.nextInt(num * 10);
			System.out.print(a[i]+"  ");
		}

		long startTime = System.currentTimeMillis();
		MySort sort = new MyHeapSort(a);
		sort.sort();
		long endTime = System.currentTimeMillis(); // ��ȡ����ʱ��

		System.out.println("\n��������ʱ�䣺 " + (endTime - startTime) + "ms");
		sort.print();

	}

}
