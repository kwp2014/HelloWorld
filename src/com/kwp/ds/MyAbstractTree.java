package com.kwp.ds;
/**
 * 
 */

/**
 * @author Weiping
 *
 */
public abstract class MyAbstractTree<E extends Comparable<E>> implements MyTree<E> {

	/**
	 * Inorder traversal from the root
	 * ��ӡ��������Ľڵ�
	 */
	public void inorder(){
		
	}
	
	/**
	 * postorder traversal from the root
	 * ��ӡ��������Ľڵ�
	 */
	public void postorder() {
	}
	
	/**
	 * preorder traversal from the root
	 * ��ӡǰ������Ľڵ�
	 */
	public void pretorder(){
		
	}
	
	
	/**
	 * Return true if the tree is empty
	 * @return
	 */
	public boolean isEmpty(){
		return getSize() == 0;
	}
	
	/**
	 * ���ر���Ԫ�صĵ�����
	 */
	@SuppressWarnings("rawtypes")
	public java.util.Iterator iterator(){
		return null;
	}
	
	
}
