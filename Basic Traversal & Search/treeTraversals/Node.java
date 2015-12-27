package treeTraversals;

public class Node {

	public char data;
	public Node lchild;
	public Node rchild;
	public Node(char data) 
	{
		this.data = data;
		this.lchild = null;
		this.rchild = null;
	}
	public char getInfo()
	{
		return data;
	}
	public char getdata() {
		return data;
	}
	public void setdata(char data) 
	{
		this.data = data;
	}
	public Node getLchild() {
		return lchild;
	}
	public void setLchild(char lchild) 
	{

		Node p = new Node(lchild);
		this.lchild = p;

	}
	public Node getRchild() 
	{
		return rchild;
	}
	public void setRchild(char rchild) 
	{

		Node p = new Node(rchild);
		this.rchild = p;         

	}
	
}
