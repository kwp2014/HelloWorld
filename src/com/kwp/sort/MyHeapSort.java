package com.kwp.sort;
/**
 * �������ʵ�֣�
 * 	��̬������С�ѣ���������ʽ��
 * 	�ؼ������ڵ����ӽڵ������֮��Ĺ�ϵ
 * 		[0,(1,2)],[1,(3,4)],[k,(2k+1,2k+2)],k=0,1,2,...\
 * 	
 */


import java.util.ArrayList;

/**
 * @author Weiping
 *
 */
public class MyHeapSort extends MyAbstractSort implements MySort {

	/**
	 * 
	 */
	public MyHeapSort() {

	}

	/**
	 * @param list
	 */
	public MyHeapSort(int[] list) {
		super(list);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kwp.sort.MyAbstractSort#sort()
	 */
	@Override
	public void sort() {
		heapSort(list);
	}

	private void heapSort(int[] list) {

		Heap heap = new Heap();

		// add,��������
		for (int i = 0; i < list.length; i++) {
			heap.add(list[i]);
		}

		// remove,ע��������c��
		for (int i = list.length - 1; i >= 0; i--) {
			list[i] = heap.remove();
		}

	}

	class Heap {

		private ArrayList<Integer> heapList = new ArrayList<Integer>();

		public Heap(){

		}

		public Heap(int[] objects) {
			for (int e : objects) {
				add(e);
			}
		}

		/**
		 * ��̬�������ѣ�ÿ�����һ��Ԫ��,�ٵ���
		 * 
		 * @param newObject
		 */
		public void add(int newObject) {
			heapList.add(newObject);// ��ӵ��������
			int currentIndex = heapList.size() - 1;
			// ��ʼ������
			while(currentIndex > 0){
				int parentIndex = (currentIndex-1)/2;
				if(heapList.get(currentIndex) > heapList.get(parentIndex)){
					// swap
					Integer temp = heapList.get(currentIndex);
					heapList.set(currentIndex, heapList.get(parentIndex));
					heapList.set(parentIndex, temp);
				}else{
					break; // no need for adjustment 
				}
				currentIndex = parentIndex;
			}
			
		}
		
		/**
		 * ÿ���Ƴ����ڵ㣬������
		 * @return
		 */
		public Integer remove() {
			if(getSize()==0){
				return null;
			}
			Integer removeObject = heapList.get(0);
			heapList.set(0, heapList.get(getSize()-1));
			heapList.remove(heapList.get(getSize()-1));
			
			// ��ʼ������
			int currentIndex = 0;
			while(currentIndex < heapList.size()){
				int leftChildrenIndex = currentIndex*2 + 1;
				int rightChildrenIndex = currentIndex*2 + 2;
				
				if(leftChildrenIndex >= heapList.size() ){// ֻ��1��Ԫ��
					break;
				}
				// find the maximun from children
				int maxIndex = leftChildrenIndex;
				if(rightChildrenIndex < heapList.size()){ // ֻ��2��Ԫ��
					if(heapList.get(maxIndex)<heapList.get(rightChildrenIndex)){
						maxIndex = rightChildrenIndex;
					}
				}
				
				if(heapList.get(currentIndex) > heapList.get(maxIndex)){
					
				
					// swap  the maximum with the currentIndex
					Integer temp = heapList.get(maxIndex);
					heapList.set(maxIndex, heapList.get(currentIndex));
					heapList.set(currentIndex, temp);
					
					currentIndex = maxIndex;
				}else{
					break;
				}
				
				
				
			}
			
			return removeObject;

		}

		public int getSize() {
			return heapList.size();
		}

	}

}
