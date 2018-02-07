public class StackList<E> {
	private Node<E> head = null;
	private int size = 0;

	private static class Node<E> {
		private E data;
		private Node<E> next;

		private Node(E dataItem) {
			data = dataItem;
			next = null;
		}

		private Node(E dataItem,Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}
	}

	public void push(E e) {
		Node<E> newNode = new Node<E>(e);
		if (head==null) {
			head = newNode;
		} else { 
			Node<E> cur = head;
			head = newNode;
			newNode.next = cur;
		}
		size++;
	}

	public E pop() {
		E returnValue = head.data;
		head = head.next;
		size--;
		return returnValue;
	}

	public boolean isEmpty() {
		return size==0;
	}
}