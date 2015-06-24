import java.util.ArrayList;



public class TestBST {

	public static void Main(String[] args) {
		Integer[] numbers = {2,4,3,1,8,5,65,7};
		MyBinaryTree<Integer> intTree = new MyBinaryTree<Integer>(numbers);
		System.out.print("\n Inorder: ");
		intTree.inorder();
		System.out.print("\n preorder: ");
		intTree.preorder();
		ArrayList<Integer> list  = intTree.path(7);
		System.out.print("\n path: ");
		java.util.ListIterator<Integer> listiterator = list.listIterator();
		while(listiterator.hasNext()){
			System.out.print(listiterator.next() + " ");
		}
	}

}
