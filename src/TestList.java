import com.kwp.ds.MyLinkedList;
import com.kwp.ds.MyList;


public class TestList {

	public static void Main(String[] args) {
		
//		MyList<String> list = new MyArrayList<String>();
		MyList<String> list = new MyLinkedList<String>();
		// add an element to the list
		list.add("America");
		System.out.println("[1]:"+ list);
		// add an element to the beginning of the list
		list.add(0,"Canada");
		System.out.println("[2]:"+ list);
		
		list.add("France");
		System.out.println("[3]:"+ list);
		
		list.add("Japan");
		System.out.println("[4]:"+ list);
		
		
		list.remove("France");
		System.out.println("[5]:"+ list);
		
		list.add(87,"China");
		System.out.println("[6]:"+ list);
		System.out.println("Hello: this is the basic List.");
	}

}
