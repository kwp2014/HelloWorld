public interface MyList<E>{

	// add a new element at the end of the this list
	public void add(E e);

	// add a new element at the specialized index in this list
	public void add(int index,E e);


	// remove the first occurrence of the element o from this list
	public boolean remove(E e);	
	
	// remove the element at the specified position in this list
	// return the element that was removed
	public E remove(int index);

	// clear the list
	public void clear();

	// return true if this list contains the element
	public boolean contains(E e);

	// get the element by the index
	public E get(int index);

	// get the first index of the given element
	public int indexOf(E e);

	// get the last index of the given element
	public int lastIndexOf(E e);

	// if the list is empty
	public boolean isEmpty();

	
	/* set the specified element in the specified position
	    return the new list			*/
	public Object set(int index,E e);

	// return the number of the element in this list
	public int size();


}