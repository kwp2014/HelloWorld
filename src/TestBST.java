import java.util.ArrayList;

import com.kwp.ds.MyBinaryTree;



public class TestBST {

	public static void main(String[] args) {
		Integer[] numbers = {2,4,3,1,8,5,65,7};
		MyBinaryTree<Integer> intTree = new MyBinaryTree<Integer>(numbers);
		System.out.print("Inorder: ");
		intTree.inorder();
		System.out.print("\npreorder: ");
		intTree.preorder();
		ArrayList<Integer> list  = intTree.path(7);
		System.out.print("\npath: ");
		java.util.ListIterator<Integer> listiterator = list.listIterator();
		while(listiterator.hasNext()){
			System.out.print(listiterator.next() + " ");
		}
	}

}
