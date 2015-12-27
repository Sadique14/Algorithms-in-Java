package grahamScan;

public class LinkedList {

	Node first,last;
	int count;
	public LinkedList() 
	{
		first = last = null;
		count = 0;
	}
	public void insertLast(double x, double y)
	{
		if(first==null)
		{
			Node newNode = new Node(null, x, y, null);
			first = last = newNode;
			count++;
		}
		else {
			Node newNode = new Node(last, x, y, null);
			last.setNext(newNode);
			last = newNode;
			count++;
		}
	}
	public Node getFirst()
	{
		return first;
	}
	public String print()
	{
		StringBuilder s = new StringBuilder();
		Node i;
		for(i = first; i!=null; i=i.getNext())
		{
			if(i.equals(first))
				s.append(i.getX()+" "+i.getY());
			else {
				s.append(","+i.getX()+" "+i.getY());
			}
		}
		return s.toString();
	}
}
