package breadthFirstSearch;

public class Node {

	int info;
	Node Link;
	public Node(int info, Node Link) 
	{
		this.info = info;
		this.Link = Link;
	}
	public int getInfo() {
		return info;
	}
	public void setInfo(int info) {
		this.info = info;
	}
	public Node getLink() {
		return Link;
	}
	public void setLink(Node Link) {
		this.Link = Link;
	}
	
}
