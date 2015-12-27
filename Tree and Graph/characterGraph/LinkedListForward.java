package characterGraph;
public class LinkedListForward<E> {
	Node<Integer> first,last,newNode;
	public LinkedListForward()
	{
		first=null;
		last=null;
	}
	public Node getFirst()
	{
		return first;
	}
	//insert last
	public void insert(int x) {
		newNode=new Node<Integer>(x, null);
		if (first==null) {
			//list is empty
            //both first and last pointing newNode
			first=last=newNode;
			
		}
		else {
			//list is not empty add newNode after last
			last.setLink(newNode);
			//change last
			last=newNode;
		}
		
	}
	//remove first
	public int remove() {
		int retvalue;
		if (first!=null) {//queue is not empty
			retvalue=first.getInfo();
			if (first==last) {
				first=last=null;
				
			}
			else {
				first=first.getLink();
			}
			
			
		}
		else {
			retvalue=-1;
		}
		return retvalue;
		
	}
	public boolean isEmpty() {
		return (first==null);
		
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for (Node i = first; i!=null; i=i.getLink()) {
			if (i==first) {
				sb.append(i.getInfo());
				
			}
			else {
				sb.append(" , "+i.getInfo());
			}
			
		}
		return sb.toString();
		
	}
    
}
