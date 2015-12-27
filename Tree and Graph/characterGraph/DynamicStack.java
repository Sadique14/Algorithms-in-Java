package characterGraph;
public class DynamicStack<E> {
	public Node<Integer> top=null;
	public Node first=null;
	public DynamicStack()
	{
		top=null;
		
	}
	
	
		
	public void insertLast(int data) {
	  Node<Integer>newNode=new Node<Integer>(data, null);
		Node temp=first;
		if (first==null) {
			newNode.setLink(null);
			first=newNode;
			
		}
		else {
		while(temp.getLink()!=null)
			{
				temp=temp.getLink();
			}
			temp.setLink(newNode);
			
		}
		
		
	}
	public void showList() {
		Node temp=first;
		while(temp!=null)
		{
			System.out.print(temp.getInfo()+"  ");
			temp=temp.getLink();
		}
		
	}

	   public void printList()
	   {
	     Node node;
	     node= top;
	     
	     while (node!= null )
	     {
	       System.out.print(node.getInfo() + "  " );
	       node=node.getLink();
	     }
	   }
	  
	   
	  
	public void push(int x) {
		Node newNode=new Node<Integer>(x, null);
		if (top==null) {
			newNode.setLink(null);
			top=newNode;
			
		}
		else {
			newNode.setLink(top);
			
			top=newNode;
		}
		
	}
	public int pop() {
		if (top==null) {
			System.out.println("stack underlow");
			System.exit(-1);
			
		}
		int item=top.getInfo();
		top=top.getLink();
		return item;
		
	}
	public int peek() {
		if (top==null) {
			System.out.println("stack underlow");
			System.exit(-1);
			
		}
		int item=top.getInfo();
		return item;
		
	}
	public boolean isEmpty() {
		return (top==null);
		
	}

}
