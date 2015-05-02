
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
		// TODO Auto-generated method stub
		return null;
	}

	private E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object set(int index, E e) {
		// TODO Auto-generated method stub
		return null;
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
