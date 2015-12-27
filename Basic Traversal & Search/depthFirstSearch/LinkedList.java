package depthFirstSearch;

public class LinkedList {

	Node first,last;
	public LinkedList()
	{
		first = null;
		last = null;
	}
	public void insert(int item)
	{
		Node newNode = new Node(item, null);
		if(last == null)
		{
			first = last = newNode;
		}
		else
		{
			last.setLink(newNode);
			last = last.getLink();
		}
	}
	public Node getFirst()
	{
		return first;
	}
}
