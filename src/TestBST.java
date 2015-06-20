
public class TestBST {

	public static void main(String[] args) {
		Integer[] numbers = {2,4,3,1,8,5,65,7};
		MyBinaryTree<Integer> intTree = new MyBinaryTree<Integer>(numbers);
		System.out.print("\n Inorder: ");
		intTree.inorder();

	}

}
