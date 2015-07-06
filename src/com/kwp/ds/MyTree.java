package com.kwp.ds;

/**
 * 
 */

/**
 * @author Weiping
 *
 */
public interface MyTree<E extends Comparable<E>> {
	
	/**
	 * return true if the element is in the tree
	 * @param e
	 * @return
	 */
	public boolean serach(E e);
	
	/**
	 * insert an element into the tree
	 * return true if inserting succeed
	 * @param e
	 * @return
	 */
	public boolean insert(E e);
	
	
	/**
	 * delete an element into the tree
	 * return true if deleting succeed
	 * @param e
	 * @return
	 */
	public boolean delete(E e);
	
	/**
	 * Inorder traversal from the root
	 * 打印中序遍历的节点
	 */
	public void inorder();
	
	/**
	 * postorder traversal from the root
	 * 打印后序遍历的节点
	 */
	public void postorder();
	
	/**
	 * preorder traversal from the root
	 * 打印前序遍历的节点
	 */
	public void pretorder();
	
	/**
	 * Get the number of nodes in the tree
	 * @return
	 */
	public int getSize();
	
	/**
	 * Return true if the tree is empty
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * 返回遍历元素的迭代器
	 */
	@SuppressWarnings("rawtypes")
	public java.util.Iterator iterator();
	
	/**
	 * 删除树中所有的元素
	 */
	public void clear();
	
	
}
