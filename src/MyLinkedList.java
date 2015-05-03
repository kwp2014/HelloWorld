
public class MyLinkedList<E> extends MyAbstractList<E> {

	private Node<E> head,tail;
	
	public MyLinkedList(){}
	
	public MyLinkedList(E[] object){		
		super(object);	
	}
	
	@Override
	public void add(int index, E e) {
		if (index == 0){
			addFirst(e);
		}else if(index >= size){
			addLast(e);
		}else{
			Node<E> current = head;
			for(int i=1;i<index;i++){
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<E>(e);
			(current.next).next = temp;
			size ++;
		}

	}

	private void addLast(E e) {
		Node<E> newNode = new Node<E>(e);
		if(tail == null){
			head = newNode;
			tail = head;
		}else{
			tail.next = newNode;
			tail = tail.next;
		}
		size ++;
	}

	private void addFirst(E e) {
		Node<E> newNode = new Node<E>(e);
		newNode.next = head;
		head = newNode;
		size ++;
		if(tail == null){
			tail = head;
		}
		
	}

	@Override
	public E remove(int index) {
		if(index < 0 || index>= size){
			return null;
		}else if(index == 0){
			return removeFirst();
		}else if(index == size-1){
			return removeLast();
		}else{
			Node<E> previous = head;
			for(int i=1;i<index;i++){
				previous = previous.next;
			}
			Node<E> current = previous.next;
			previous.next = current.next;
			size --;
			return current.element;
		}
		
	}

	private E removeLast() {
		if(size ==0){
			return null;
		}else if(size==1){
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		}else{
			Node<E> current = head;
			for(int i=0;i<size-2;i++){
				current = current.next;
			}
			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}

	/**
	 * remove the head node
	 * @return the object that is contained in the removed node
	 */
	private E removeFirst() {
		if(size ==0){
			return null;
		}else if(size==1){
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		}else{
			Node<E> temp = head;
			head = head.next;
			size--;
			return temp.element;
		}
	}

	/**
	 * clear the list
	 */
	@Override
	public void clear() {
		head = tail = null;
	}

	@Override
	public boolean contains(E e) {
		if(size == 0){
			return false;
		}else{
			Node<E> current = head;
			for(int i=0;i<size;i++){
				if(e.equals(current.element)){
					return true;
				}else{
					current = current.next;
				}			
			}
			return false;
		}
	}

	@Override
	public E get(int index) {
		if(index < 0 || index > size-1){
			return null;
		}else{
			Node<E> current = head;
			for(int i=0;i<index;i++){				
				current = current.next;
			}
			return current.element;
		}
	}

	/**
	 * return the index of the first matching element
	 * return -1 if no match
	 */
	@Override
	public int indexOf(E e) {
		if(size == 0){
			return -1;
		}else{
			Node<E> current = head;
			for(int i=0;i<size;i++){				
				if(e.equals(current.element)){
					return i;
				}else{
					current = current.next;
				}	
			}
			return -1;
		}
	}

	/**
	 * return the index of the last matching element
	 * return -1 if no match
	 */
	@Override
	public int lastIndexOf(E e) {
		if(size == 0){
			return -1;
		}else{		
			for(int i=size-1;i>=0;i--){	
				Node<E> current = head;
				for(int j=0;j<i;j++){				
					current = current.next;		
				}
				if(e.equals(current.element)){
					return i;
				}				
			}
			return -1;
		}
	}

	/**
	 * replace the element at the specified position 
	 * with the specified element
	 * return the original element
	 */
	@Override
	public Object set(int index, E e) {
		if(index < 0 || index > size-1){
			return null;
		}else{
			Node<E> current = head;
			for(int j=0;j<index;j++){				
				current = current.next;		
			}
			E temp = current.element;
			current.element = e;
			return temp;
		}
	}
	
	/**
	 * Override toString() to return elements in this list
	 */
	public String toString(){
		StringBuilder result = new StringBuilder("[");
		Node<E> current = head;
		for(int i=0;i<size;i++){
			result.append(current.element);
			if(i < size-1){
				result.append(",");
			}
			current = current.next;
		}
		return result.toString() + "]";
	}
	
	private static class Node<E>{
		E element;
		Node<E> next;
		
		public Node(E element){
			this.element = element;
			this.next = null;
		}
	}
}
