package com.kwp.ds;

/**
 * 
 */

/**
 * @author Weiping
 *
 */
public class MyBinaryTree<E extends Comparable<E>> extends MyAbstractTree<E> {

	protected TreeNode<E> root;
	protected int size = 0;

	// ------------------ ������ ---------------------------
	public MyBinaryTree() {

	}

	/**
	 * �������д���һ��BST
	 */
	public MyBinaryTree(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			insert(objects[i]);
		}
	}


	

	// ------------------ ���� ---------------------------
	/**
	 * ����һ��Ԫ�ص�BST�У�����ɹ��򷵻�true û�о������ĵ�����ֱ�Ӽ���Ҷ�ڵ��ϣ��ؼ������½ڵ�ĸ��ڵ�λ��
	 */
	public boolean insert(E e) {
		if (root == null) {
			root = createNewNode(e);
		} else {
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null) {
				if (e.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				} else if (e.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				} else {
					return false;
				}

			}
			if (e.compareTo(parent.element) < 0) {
				parent.left = createNewNode(e);
			} else {
				parent.right = createNewNode(e);
			}
		}
		size++;
		return true;
	}

	protected TreeNode<E> createNewNode(E e) {
		return new TreeNode<E>(e);
	}

	// ------------------ ɾ�� ---------------------------
	/**
	 * ��BST��ɾ��һ��ָ��ֵ��Ԫ�� �ؼ����ڶ�λ��Ԫ���Լ���Ԫ�صĸ��ڵ��λ�� �������۸�Ԫ�ؽڵ������
	 */
	public boolean delete(E e) {
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		while (current != null) { // ��λ��Ԫ�����ڵĽڵ�
			if (e.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			} else {
				break;
			}
		} // current --> TreeNode(e)
		if (current == null) {
			return false; // not in the tree
		}

		// case1: current has no left children
		if (current.left == null) {
			if (parent == null) { // root is the current element
				root = current.right;
			} else { // two cases:

				if (e.compareTo(parent.element) < 0) { // current node is the
														// left node of the
														// parent node
					parent.left = current.right;
				} else {
					parent.right = current.right;
				}
			}
		}
		// case2: current has a left children ��ε���BST
		// locate the rightmost node in the left subtree of the current node->
		// 'e'
		else {
			TreeNode<E> rightMost = current.left;
			TreeNode<E> parentOfRightMost = current.left;
			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right;
			}
			current.element = rightMost.element;

			// two cases of rightMost's location
			if (parentOfRightMost.right == rightMost) {
				parentOfRightMost.right = rightMost.left;
			} else {
				parentOfRightMost.left = rightMost.left;
			}
		}
		// we can also consider the right node of current node's location
		size--;
		return true;
	}
	
	/**
	 * clear a BST
	 */
	public void clear(){
		root = null;
		size = 0;
	}

	// ------------------ ���� ---------------------------

	/**
	 * Inorder traversal �������
	 */
	public void inorder() {
		inorder(root);
	}

	protected void inorder(TreeNode<E> root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.element + " ");
		inorder(root.right);
	}

	/**
	 * preorder traversal ǰ�����
	 */
	public void preorder() {
		preorder(root);
	}

	protected void preorder(TreeNode<E> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.element + " ");
		inorder(root.left);
		inorder(root.right);
	}

	/**
	 * posteorder traversal �������
	 */
	public void postorder() {
		preorder(root);
	}

	protected void postorder(TreeNode<E> root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		inorder(root.right);
		System.out.print(root.element + " ");
	}

	
	/**
	 * get the number of the nodes in the tree
	 */
	public int getSize() {
		return size;
	}

	/**
	 * get the root in the tree
	 */
	public TreeNode<E> getRoot() {
		return root;
	}

	/**
	 * get the path from the root to the specified element
	 */
	public java.util.ArrayList<E> path(E e) {
		java.util.ArrayList<E> list = new java.util.ArrayList<E>();
		TreeNode<E> current = root;
		while (current != null) {
			list.add(current.element);
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else {
				break;
			}
		}

		return list;

	}
	
	
	
	// ------------------ ��������ʵ�� -----------------------
	/**
	 * obtain the inorder Iterator
	 * @author Weiping
	 *
	 */
	@SuppressWarnings("rawtypes")
	public java.util.Iterator inorderIterator(){
		return new InorderIterator();
	}
	
	@SuppressWarnings("rawtypes")
	public java.util.Iterator iterator(){
		return inorderIterator();
	}
	
	@SuppressWarnings("rawtypes")
	class InorderIterator implements java.util.Iterator{

		private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
		
		private int current = 0; // point the current element in the list
		
		public InorderIterator(){
			inorder();
		}
		private void inorder(){
			inorder(root);
		}
		/**
		 * ��
		 * @param root
		 */
		private void inorder(TreeNode<E> root){
			if(root == null){
				return;
			}
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}
	
		/**
		 * next element for traversing
		 */
		public boolean hasNext() {
			if(current < list.size()){
				return true;
			}
			return false;
		}

		/**
		 * ��
		 * get the current element and move the cursor to the next
		 */
		public Object next() {
			
			return list.get(current++);
		}
		/**
		 * ��
		 * remove the current element and refresh the list
		 */
		public void remove(){
			delete(list.get(current));
			list.clear();
			inorder();//rebuild the list
		}		
		
	}
	
	
	
	// ------------------ �ڲ��� ---------------------------
	/**
	 * ��̬�ڲ��࣬��Ϊ�ڵ��ʵ��
	 * 
	 * @author Weiping
	 *
	 * @param <E>
	 */
	public static class TreeNode<E extends Comparable<E>> {
		E element;
		TreeNode<E> left;
		TreeNode<E> right;

		public TreeNode(E e) {
			element = e;
		}
	}

	// ------------------ ���� ---------------------------
	@Override
	public boolean serach(E e) {
		TreeNode<E> current = root;

		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else {
				return true;
			}
		}
		return false;
	}

}
