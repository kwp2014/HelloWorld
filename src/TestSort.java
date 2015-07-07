import com.kwp.sort.MyBubbleSort;
import com.kwp.sort.MySort;


public class TestSort {

	public static void main(String[] args) {
		
		int[] list = {1,2,33,4,5,6,77,3,22};
		
		MySort sort = new MyBubbleSort(list);
		sort.sort();
		sort.print();

	}

}
