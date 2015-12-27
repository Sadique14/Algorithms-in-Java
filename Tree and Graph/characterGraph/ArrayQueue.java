package characterGraph;

public class ArrayQueue<E> {

	E[] data;
	int front;
	int rear;
	int size;
	public ArrayQueue(int capacity)
	{
		data = (E[])new Object[capacity];
		front = 0;
		rear = -1;
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
	public void enqueue(E e) throws IllegalStateException
	{
		if(size == data.length)
			throw new IllegalStateException("Que is full");
		else {
			rear = (rear+1) % data.length;
			data[rear] = e;
			size++;
		}
	}
	public E dequeue()
	{
		if(isEmpty())
			return null;
		E answer = data[front];
		data[front] = null;
		front = (front+1) % data.length;
		size--;
		return answer;
	}
	public E first()
	{
		if(isEmpty())
			return null;
		return data[front];
	}
}
