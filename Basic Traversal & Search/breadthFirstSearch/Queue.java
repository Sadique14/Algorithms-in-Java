package breadthFirstSearch;

public class Queue {

	int[] data;
	int front;
	int rear;
	int size;
	int n;
	public Queue(int capacity)
	{
		n = capacity;
		data = new int[n];
		front = 0;
		rear = 0;
		size = 0;
	}
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return (size == 0);
	}
	
	public boolean AddQ(int item)
	{
		rear = (rear+1)%n;
		if(front == rear)
		{
			System.out.println("Queue is full");
			if(front == 0)
				rear = n - 1;
			else {
				rear = rear - 1;
			}
			return false;
		}
		else
		{
			data[rear] = item;
			size++;
			return true;
		}
	}
	
	public int DeleteQ()
	{
		if(front == rear)
		{
			System.out.println("Queue is empty");
			return 0;
		}
		else {
			int deleteItem = data[front+1];
			front = (front+1)%n;
			size--;
			return deleteItem;
		}
	}
	public int first()
	{
		if(isEmpty())
			return 0;
		return data[front+1];
	}
}
