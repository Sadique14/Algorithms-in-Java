package characterGraph;

public class LinkedListType<E> {

	protected int count;
	protected Node<E> first;
	protected Node<E> last;
	public LinkedListType()
	{
		count = 0;
		first = last = null;
	}
	
	public void initializeList()
	{
		count =0;
		first = last = null;
	}
	public boolean isEmpty()
	{
		if(first == null)
			return true;
		return false;
	}
	
	public void insertLast(E newItem)
	{
		Node<E> newNode = new Node<E>(newItem, null);
		if(last == null)
		{
			first = last = newNode;
		}
		else {
			last.setLink(newNode);
			last = newNode;
		}
		count++;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(Node<E> i = first; i!= null; i = i.getLink())
		{
			if(i.equals(first))
				sb.append(i.getInfo());
			else {
				sb.append(", "+i.getInfo());
			}
		}
		return sb.toString();
	}
	public int length()
	{
		return count;
	}
	public Node<E> getFront()
	{
		return first;
	}
	public Node<E> getBack()
	{
		return last;
	}
}
