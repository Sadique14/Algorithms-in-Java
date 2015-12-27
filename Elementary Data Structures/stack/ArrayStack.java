package stack;

public class ArrayStack {
    
	int top = -1;
	int[] data;
	int n;
	static int deleteItem = 0;
	public ArrayStack(int capacity)
	{
		n = capacity;
		data = new int[n];
	}
	
	public boolean add(int item)
	{
		if(top >= n-1)
		{
			System.out.println("Stack is full");
			return false;
		}
		else
		{
			top = top+1;
			data[top] = item;
			return true;
		}
	}
	public boolean Delete()
	{
		if(top < 0)
		{
			System.out.println("stack is empty");
			return false;
		}
		else
		{
			deleteItem = data[top];
			top = top-1;
			return true;
		}
	}
	public void print()
	{
		for(int i=0; i<=top; i++)
		{
			System.out.println(data[i]);
		}
	}
	
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(10);
		stack.add(10);
		stack.add(20);
		stack.add(30);
		stack.add(40);
		//stack.Delete();
		//System.out.println(deleteItem);
		//stack.Delete();
		//System.out.println(deleteItem);
		stack.print();
	}
}
