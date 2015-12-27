package depthFirstSearch;

public class Stack {

	int top = -1;
	int[] data;
	int n;
	public Stack(int capacity)
	{
		n = capacity;
		data = new int[n];
	}
	public boolean isEmpty()
	{
		return (top == -1);
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
	public int Delete()
	{
		int deleteItem;
		if(top < 0)
		{
			System.out.println("stack is empty");
			return 0;
		}
		else
		{
			deleteItem = data[top];
			data[top] = 0;
			top--;
			return deleteItem;
		}
	}
}
