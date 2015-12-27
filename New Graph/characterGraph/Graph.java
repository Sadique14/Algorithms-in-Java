package characterGraph;

import java.io.File;
import java.util.Scanner;

public class Graph {

	Node<Character>[] nodes;
	int size;
	LinkedListType<Character> list;
	public Graph()
	{
		size = 0;
		
	}
	public void createGraph() throws Exception
	{
		Scanner sc = null;
		try {
			File f = new File("E:\\input5.txt");
			sc = new Scanner(f);
		}
		catch(Exception e)
		{
			throw new Exception("Error in file");
		}
		size  = sc.nextInt();
		nodes = new Node[size];
		for(int i=0; i<size; i++)
			nodes[i] = new Node<Character>('#', null);

		char vertex;
		char adjacent;

		for(int i=0; i<size; i++)
		{
			vertex = sc.next().charAt(0);
			//System.out.println(vertex);
			nodes[i].setInfo(vertex);
			list = new LinkedListType<>();
			adjacent = sc.next().charAt(0);
			while(adjacent != '#')
			{
				list.insertLast(adjacent);
				adjacent = sc.next().charAt(0);
			}

			nodes[i].setLink(list.getFront());
		}
		sc.close();
	}

	public void breadthFirstSearch(char start)
	{
		ArrayQueue<Character> q = new ArrayQueue<Character>(50);
		String visited = new String("");
		q.enqueue(start);
		visited = visited + start;
		//System.out.println(visited);
		char current, adjacent;
		Node<Character> temp;
		//int k = 0;
		while(!q.isEmpty())
		{
			current = q.dequeue();
			System.out.println(current);
			
			int index = findIndex(current);
			temp = nodes[index].getLink();
			while(temp!=null)
			{
				adjacent = temp.getInfo();
				if(visited.indexOf(adjacent) == -1)
				{
					q.enqueue(adjacent);
					visited = visited + adjacent;
				}
				temp = temp.getLink();
			}
		}
	}
	
	public void depthFirstSearch(char start)
	{
		LinkedStack<Character> stack = new LinkedStack<>();
		String visited = new String("");
		stack.push(start);
		visited = visited + start;
		//System.out.println(visited);
		char current, adjacent;
		Node<Character> temp;
		int k = 0;
		while(!stack.isEmpty())
		{
			current = stack.pop();
			System.out.println(current);
			
			int index = findIndex(current);
			temp = nodes[index].getLink();
			while(temp!=null)
			{
				adjacent = temp.getInfo();
				if(visited.indexOf(adjacent) == -1)
				{
					stack.push(adjacent);
					visited = visited + adjacent;
				}
				temp = temp.getLink();
			}
		}
	}
	
	public int findIndex(char vertex)
	{
		int i;
		for(i=0; i<size; i++)
		{
			if(vertex == nodes[i].getInfo())
			{
				break;
			}
		}
		return i;
	}
	public void printGraph()
	{
		Node temp;
		for(int i=0; i<size;i++)
		{
			System.out.print(nodes[i].getInfo()+" ");
			temp = nodes[i].getLink();
			while(temp!=null)
			{
				System.out.print(temp.getInfo() + " ");
				temp = temp.getLink();
			}
			System.out.println();
		}
	}
}
