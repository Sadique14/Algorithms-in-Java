package characterGraph;

public class LinkedStack<E> {
	
	Node<E> t;
	
	public LinkedStack()
	{
		t = null;
	}
	public int size()
	{
		int count = 0;
		for(Node i = t; i!=null; i=i.getLink())
		{
			count++;
		}
		return count;
	}
	public boolean isEmpty()
	{
		return (t==null);
	}
	
	public void push(E e)
	{
		Node<E> newNode = new Node<E>(e, null);
		if(t==null)
			t = newNode;
		else {
			newNode.setLink(t);
			t = newNode;
		}
	}
	public E pop()
	{
		if(t== null)
		{
			System.out.println("Stack is empty");
			return null;
		}
		else {
			E item = t.getInfo();
			t = t.getLink();
		    return item;	
		}
	}
	public E peek()
	{
		if(t== null)
		{
			System.out.println("Stack is empty");
			return null;
		}
		else {
			return t.getInfo();
		}	
	}
}
