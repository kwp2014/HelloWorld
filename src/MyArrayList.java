/**
 * 
 */

/**
 * @author kuwei_000
 *
 */
public class MyArrayList<E> extends MyAbstractList<E> {
	public static final int INITIAL_CAPACITY = 16;
	@SuppressWarnings("unchecked")
	private E[] data = (E[])new Object[INITIAL_CAPACITY];
	
	public MyArrayList(){}
	
	public MyArrayList(E[] objects){
		for(int i=0;i<objects.length;i++){
			add(objects[i]);
		}
	}
	
	/**
	 * index arange from 0 to size-1
	 */
	public void add(int index,E e){
		ensureCapacity();
		if(index > size-1){
			data[size] = e;
			size ++;
		}else{
			for(int i=size-1;i>=index;i--){
				data[i+1] = data[i];
			}
			data[index] = e;
			size ++;
		}
		
	}
	
	public void ensureCapacity(){
		if (size > data.length){
			@SuppressWarnings("unchecked")
			E[] newData = (E[])new Object[size*2+1];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}
	
	/**
	 * clear the list
	 */
	@SuppressWarnings("unchecked")
	public void clear(){
		data = (E[])new Object[INITIAL_CAPACITY];
		size = 0;
	}
	
	/**
	 * return true if the list contains the element
	 */
	public boolean contains(E e){
		for(int i=0;i<size;i++){
			if(e.equals(data[i])){
				return true;
			}
		}
		return false;
	}
	
	public E get(int index){
		return data[index];
	}
	public int indexOf(E e){
		for(int i=0;i<size;i++){
			if (e.equals(data[i])){
				return i;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(E e){
		for(int i=size-1;i>=0;i--){
			if (e.equals(data[i])){
				return i;
			}
		}
		return -1;
	}
	
	
	/**
	 * return the element that was removed
	 */
	public E remove(int index){
		E e = data[index];
		for(int i=index;i<size-1;i++){
			data[i] = data[i+1];
		}
		data[size-1] = null;
		size --;
		return e;
	}
	
	/**
	 * replace the element at the specified position in this list
	 */
	public E set(int index,E e){
		E old = data[index];
		data[index] = e;
		return old;
	}
	
	/**
	 * Override toString() to return elements in this list
	 */
	public String toString(){
		StringBuilder result = new StringBuilder("[");
		for(int i=0;i<size;i++){
			result.append(data[i]);
			if(i < size-1){
				result.append(",");
			}
		}
		return result.toString() + "]";
	}
	
	/**
	 * trims the capacity to current size
	 */
	public void trimToSize(){
		if(size != data.length){
			@SuppressWarnings("unchecked")
			E[] newData = (E[]) new Object[size];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}
	
	
	
	
	
	
}
