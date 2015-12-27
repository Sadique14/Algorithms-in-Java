package characterGraph;
public class Node <E>{
	private E info;
	private Node<E> link;
	public Node(E info,Node<E>link)
	{
		this.info=info;
		this.link=link;
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
