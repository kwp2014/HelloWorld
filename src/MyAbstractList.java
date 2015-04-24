
public abstract class MyAbstractList<E> implements MyList<E> {
	
	protected int size = 0; // the size of the list
	
	/**
	 * create a default list
	 */
	protected MyAbstractList(){
		
	}
	/**
	 * create a list from an array of objects
	 */
	protected MyAbstractList(E[] objects){
		for(int i=0;i<objects.length;i++){
			add(objects[i]);
		}
	}
	
	/**
	 * add a new element at the end of the list
	 */
	public void add(E e){
		add(size,e);
	}
	
	/**
	 * return true if the list contains no elements
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * return the size of the list
	 */
	public int size(){
		return size;
	}
	
	/**
	 * remove the first occurrence of the element o from this list
	 */
	public boolean remove(E e){
		if (indexOf(e) >= 0){
			remove(indexOf(e));
			return true;
		}
		else{
			return false;
		}
	}

}

