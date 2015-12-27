package breadthFirstSearch;

import java.io.File;
import java.util.Scanner;

public class Graph {
	static int size;
	static Boolean[] visited;
	static Node[] headNodes;

	public static void BFS(int v)
	{
		Queue q = new Queue(20);
		q.AddQ(v);
		visited = new Boolean[size+1];
		
		for(int i = 0; i <= size; i++)
            visited[i] = false;
		visited[v] = true;
		Node temp;
		int u;  
		int w;  
		while(!q.isEmpty())
		{
		    u = q.DeleteQ();
		    System.out.print(u+" ");
		    temp = headNodes[u];
		    while(temp!=null)
		    {
		    	w = temp.getInfo();
		    	if(visited[w] == false)
		    	{
		    		q.AddQ(w);
		    		visited[w] = true;
		    	}
		    	temp = temp.getLink();
		    }
		}
	}
	public static void main(String[] args) {
		File f = new File("LinkedGraph.txt");
		try {
			Scanner sc = new Scanner(f);
			size = sc.nextInt();
			headNodes = new Node[size+1];
			int vertex;
			int adjacent;
			for(int i=1; i<=size; i++)
			{
				vertex = sc.nextInt();
				adjacent = sc.nextInt();
				LinkedList G = new LinkedList();
				while(adjacent != 0)
				{
					G.insert(adjacent);
					adjacent = sc.nextInt();
				}
				headNodes[vertex] = G.getFirst();
			}
			sc.close();
			
			BFS(1);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
