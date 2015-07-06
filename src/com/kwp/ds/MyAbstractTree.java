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
	 * 打印中序遍历的节点
	 */
	public void inorder(){
		
	}
	
	/**
	 * postorder traversal from the root
	 * 打印后序遍历的节点
	 */
	public void postorder() {
	}
	
	/**
	 * preorder traversal from the root
	 * 打印前序遍历的节点
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
	 * 返回遍历元素的迭代器
	 */
	@SuppressWarnings("rawtypes")
	public java.util.Iterator iterator(){
		return null;
	}
	
	
}
