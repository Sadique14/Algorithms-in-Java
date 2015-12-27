package shortestPath;

import java.util.Scanner;

public class SingleSourceShortestPaths {

	public static void BellmanFord(int v, int[][] cost, int[] dist, int n)
	{
		for(int i=1; i<=n; i++)
		{
			dist[i] = cost[v][i];           
		}
		for(int k=2; k<=n-1; k++)          
		{
			for(int u=1; u<=n; u++)        
			{
				if(u!=v && checkIncomingEdge(u, cost, n)) 
				{
					for(int i=1; i<=n; i++)
					{
						if(dist[u] > dist[i] + cost[i][u])   
							dist[u] = dist[i] + cost[i][u];
					}
				}
			}
		}
	}
	public static Boolean checkIncomingEdge(int u, int[][] cost, int n)
	{
		for(int i=1; i<=n; i++)
		{
			if(cost[i][u] != 0 || cost[i][u] != 99)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Number of vertex:");
		int n = sc.nextInt();
		int[][] graph = new int[n+1][n+1];
		System.out.println("Enter costs:");
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n; j++)
			{
			    graph[i][j] = sc.nextInt();
			    //I took 99 as unlimited value
			    /* INPUT GRAPH for figure 5.10 Algorithms book
			    0 6 5 5 99 99 99 
			    99 0 99 99 -1 99 99
			    99 -2 0 99 99 1 99
			    99 99 -2 0 99 -1 99
			    99 99 99 99 0 99 3
			    99 99 99 99 99 0 3
			    99 99 99 99 99 99 0
			    */
			}
		}
		System.out.println("Source vertex:");
		int source = sc.nextInt();
		sc.close();
		int[] dist = new int[n+1];
		BellmanFord(source, graph, dist, n);
		for(int i=1; i<=n; i++)
		{
			System.out.print(dist[i]+" ");
		}
	}
}
