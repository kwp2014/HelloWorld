import java.util.Observer;

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
	
	// ------------------    构造器        ---------------------------
	public MyBinaryTree(){
		
	}
	
	/**
	 * 从数组中创建一棵BST
	 */
	public MyBinaryTree(E[] objects){
		for(int i=0;i<objects.length;i++){
			insert(objects[i]);
		}
	}
	
	// ------------------    查找       ---------------------------
	
	/**
	 * 若待查找元素在BST中，返回真
	 */
	public boolean search(E e){
		TreeNode<E> current = root;
		
		while(current != null){
			if(e.compareTo(current.element) < 0 ){
				current = current.left;
			}
			else if(e.compareTo(current.element) > 0){
				current = current.right;
			}else{
				return true;
			}
		}
		return false;
		
	}
	
	// ------------------    增添      ---------------------------
	/**
	 * 增添一个元素到BST中，增添成功则返回true
	 */
	public boolean insert(E e){
		if(root == null){
			root = createNewNode(e);
		}else{
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while(current != null){
				if(e.compareTo(current.element)<0){
					parent = current;
					current = current.left;
				}else if(e.compareTo(current.element)>0){
					parent = current;
					current = current.right;
				}else{
					return false;
				}
				
			}
			if(e.compareTo(parent.element)<0){
				parent.left = createNewNode(e);
			}else{
				parent.right = createNewNode(e);
			}
		}
		size ++;
		return true;
	}
	
	
	
	protected TreeNode<E> createNewNode(E e) {
		// TODO Auto-generated method stub
		return new TreeNode<E>(e);
	}



	/**
	 * 静态内部类，作为节点的实现
	 * @author Weiping
	 *
	 * @param <E>
	 */
	public static class TreeNode<E extends Comparable<E>>{
		E element;
		TreeNode<E> left;
		TreeNode<E> right;
		
		public TreeNode(E e){
			element = e;
		}
	}

	@Override
	public boolean delete(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean serach(E e) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
