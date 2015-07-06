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

	// ------------------ 构造器 ---------------------------
	public MyBinaryTree() {

	}

	/**
	 * 从数组中创建一棵BST
	 */
	public MyBinaryTree(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			insert(objects[i]);
		}
	}


	

	// ------------------ 增添 ---------------------------
	/**
	 * 增添一个元素到BST中，增添成功则返回true 没有经过树的调整，直接加在叶节点上，关键在于新节点的父节点位置
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

	// ------------------ 删除 ---------------------------
	/**
	 * 在BST中删除一个指定值的元素 关键在于定位该元素以及该元素的父节点的位置 分类讨论该元素节点的类型
	 */
	public boolean delete(E e) {
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		while (current != null) { // 定位该元素所在的节点
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
		// case2: current has a left children 如何调整BST
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

	// ------------------ 遍历 ---------------------------

	/**
	 * Inorder traversal 中序遍历
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
	 * preorder traversal 前序遍历
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
	 * posteorder traversal 后序遍历
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
	
	
	
	// ------------------ 迭代器的实现 -----------------------
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
		 * 增
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
		 * 查
		 * get the current element and move the cursor to the next
		 */
		public Object next() {
			
			return list.get(current++);
		}
		/**
		 * 改
		 * remove the current element and refresh the list
		 */
		public void remove(){
			delete(list.get(current));
			list.clear();
			inorder();//rebuild the list
		}		
		
	}
	
	
	
	// ------------------ 内部类 ---------------------------
	/**
	 * 静态内部类，作为节点的实现
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

	// ------------------ 查找 ---------------------------
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
