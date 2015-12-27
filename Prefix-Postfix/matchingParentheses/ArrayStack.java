package matchingParentheses;

public class ArrayStack<E> {
    
	int t = -1;
	E[] data;
	int maxSize;
	public ArrayStack(int capacity)
	{
		maxSize = capacity;
		data = (E[])new Object[maxSize];
	}
	public int size()
	{
		return t+1;
	}
	public boolean isEmpty()
	{
		return (t==-1);
	}
	public boolean isFull()
	{
		return (t+1 == maxSize);
	}
	
	public void push(E e) throws IllegalStateException
	{
		if(isFull())
			throw new IllegalStateException("Stack is full");
		else {
			data[++t] = e;
		}
	}
	public E pop() throws IllegalStateException
	{
		if(isEmpty())
			throw new IllegalStateException("Stack is Empty");
		else {
			E answer = data[t];
			data[t] = null;
			t--;
			return answer;
		}
	}
	public E peek() throws IllegalStateException
	{
		if(isEmpty())
			throw new IllegalStateException("Stack is Empty");
		else {
			return data[t];
		}	
	}
}
