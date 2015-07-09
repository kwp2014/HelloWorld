package com.kwp.sort;
/**
 * 堆排序的实现：
 * 	动态构建最小堆（二叉树形式）
 * 	关键：父节点与子节点的索引之间的关系
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

		// add,构建最大堆
		for (int i = 0; i < list.length; i++) {
			heap.add(list[i]);
		}

		// remove,注意这里是c堆
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
		 * 动态构建最大堆，每次添加一个元素,再调整
		 * 
		 * @param newObject
		 */
		public void add(int newObject) {
			heapList.add(newObject);// 添加到树的最后
			int currentIndex = heapList.size() - 1;
			// 开始调整树
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
		 * 每次移除根节点，调整树
		 * @return
		 */
		public Integer remove() {
			if(getSize()==0){
				return null;
			}
			Integer removeObject = heapList.get(0);
			heapList.set(0, heapList.get(getSize()-1));
			heapList.remove(heapList.get(getSize()-1));
			
			// 开始调整树
			int currentIndex = 0;
			while(currentIndex < heapList.size()){
				int leftChildrenIndex = currentIndex*2 + 1;
				int rightChildrenIndex = currentIndex*2 + 2;
				
				if(leftChildrenIndex >= heapList.size() ){// 只有1个元素
					break;
				}
				// find the maximun from children
				int maxIndex = leftChildrenIndex;
				if(rightChildrenIndex < heapList.size()){ // 只有2个元素
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
