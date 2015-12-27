package grahamScan;

public class Node {

	double x;
	double y;
	Node prev;
	Node next;
	public Node(Node prev, double x, double y, Node next) 
	{
		this.x = x;
		this.y = y;
		this.prev = prev;
		this.next = next;
	}
	public double getX() 
	{
		return x;
	}
	public void setX(double x) 
	{
		this.x = x;
	}
	public double getY() 
	{
		return y;
	}
	public void setY(double y) 
	{
		this.y = y;
	}
	public Node getPrev() 
	{
		return prev;
	}
	public void setPrev(Node prev) 
	{
		this.prev = prev;
	}
	public Node getNext() 
	{
		return next;
	}
	public void setNext(Node next) 
	{
		this.next = next;
	}
	
}
