package stack;

public class Node<E> {
	
	E info;
	Node<E> link;
	public Node(E info, Node<E> link) {
		this.info = info;
		this.link = link;
	}
	public E getInfo() {
		return info;
	}
	public void setInfo(E info) {
		this.info = info;
	}
	public Node<E> getLink() {
		return link;
	}
	public void setLink(Node<E> link) {
		this.link = link;
	}
	

	
}
