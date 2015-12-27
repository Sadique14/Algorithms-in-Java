package treeTraversals;

public class Traversal {

	Node root = null;
	public void setRoot(Node x)
	{
	    root = x;
	}
	
	public void inOrder(Node t)
	{
		if(t!=null)
		{
			inOrder(t.getLchild());
			System.out.print(t.getInfo()+" ");
			inOrder(t.getRchild());
		}
	}
	public void preOrder(Node t)
	{
		if(t!=null)
		{
			System.out.print(t.getInfo()+" ");
			preOrder(t.getLchild());
			preOrder(t.getRchild());
		}
	}
	public void postOrder(Node t)
	{
		if(t!=null)
		{
			postOrder(t.getLchild());
			postOrder(t.getRchild());
			System.out.print(t.getInfo()+" ");
		}
	}
	
	public void Triple(Node t)
	{
		if(t!=null)
		{
			System.out.print(t.getdata()+" ");
			Triple(t.getLchild());
			System.out.print(t.getdata()+" ");
			Triple(t.getRchild());
			System.out.print(t.getdata()+" ");
		}
	}
}
