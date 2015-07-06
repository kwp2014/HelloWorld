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
	 * ��ӡ��������Ľڵ�
	 */
	public void inorder();
	
	/**
	 * postorder traversal from the root
	 * ��ӡ��������Ľڵ�
	 */
	public void postorder();
	
	/**
	 * preorder traversal from the root
	 * ��ӡǰ������Ľڵ�
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
	 * ���ر���Ԫ�صĵ�����
	 */
	@SuppressWarnings("rawtypes")
	public java.util.Iterator iterator();
	
	/**
	 * ɾ���������е�Ԫ��
	 */
	public void clear();
	
	
}
