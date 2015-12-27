package binarySearchTree;

public class Bst {

	Node tree = null;  //Root of the tree
	
	//insertion into a binary search tree
	public boolean insert(int x)
	{
		boolean found = false;
		Node p = tree;
		Node q = null;
		while(p != null && !found)
		{
			q = p;
			if(p.getInfo() == x)
			{
				found = true;
			}
			else if(x < p.getInfo())
				p = p.getLeft();
			else {
				p = p.getRight();
			}
		}
		
		if(!found)
		{
			p = new Node(null, x, null);
			if(tree != null)
			{
				if(x > q.getInfo())
					q.setRight(p);
				else
					q.setLeft(p);
			}
			else
				tree = p;
			return true;
		}
		else
			return false;
	}
	
	//Recursive search
	public int search(Node t, int x)
	{
		if(t == null)
			return 0;
		else if(x == t.getInfo())
			return t.getInfo();
		else if(x > t.getInfo())
			return search(t.getRight(), x);
		else {
			return search(t.getLeft(), x);
		}
	}
	
	//Iterative Search
	public int Isearch(int x)
	{
		boolean found = false;
		Node t = tree;
		while(t!=null && !found)
		{
			if(x == t.getInfo())
				found = true;
			else if(x > t.getInfo())
				t = t.getRight();
			else {
				t = t.getLeft();
			}
		}
		if(!found)
			return 0;
		else
			return t.getInfo();
	}
	
	//Search by rank
	public int SearchK(int k)
	{
		Node t = tree;
		boolean found = false;
		while(t != null && !found)
		{
			if(k == leftSize(t))
				found = true;
			else if(k < leftSize(t))
				t = t.getLeft();
			else {
				k = k - leftSize(t);
				t = t.getRight();
			}
		}
		if(!found)
			return 0;
		else
			return t.getInfo();
	}
	//finding rank
	public int leftSize(Node current)
	{
		int k = 0;
		while(current!=null)
		{
			k++;
			current = current.getLeft();
		}
		return k;
	}
	public void preorderTraversal(Node current)
    {
         if ( current != null )
         {
              System.out.print(current.getInfo()+"  ");
              preorderTraversal(current.getLeft());
              preorderTraversal(current.getRight());
         }
    }
}
