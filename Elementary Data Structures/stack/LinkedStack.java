package stack;

public class LinkedStack<E> {
	
	Node<E> t;
	
	public LinkedStack()
	{
		t = null;
	}
	
	public void add(E e)
	{
		Node<E> newNode = new Node<E>(e, null);
		if(t==null)
			t = newNode;
		else {
			newNode.setLink(t);
			t = newNode;
		}
	}
	public E delete()
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
	
}
