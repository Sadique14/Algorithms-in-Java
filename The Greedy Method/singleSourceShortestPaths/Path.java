package singleSourceShortestPaths;

import java.util.Scanner;

public class Path {

	public void ShortestPaths(int v, int[][] cost, int[] dist, int n)
	{
		//v=source
		boolean[] s = new boolean[n+1];
		for(int i=1; i<=n; i++)
		{
			s[i] = false;
		}
		s[v] = true;
	    for(int i=1; i<=n; i++)
	    {
	    	dist[i] = cost[v][i];
	    }
	    dist[v] = 0;
	    for(int num=2; num<=n; num++)
	    {
	    	int u = minimumDistance(dist, s, n);
	    	//System.out.println(u);
	    	s[u] = true;
	    	for(int i=1; i<=n; i++)
	    	{
	    		if(cost[u][i] != 99 && s[i] == false)
	    		{
	    			int w = i;
	    			//System.out.println(i);
	    			if(dist[w] > dist[u]+cost[u][w])
	    				dist[w] = dist[u]+cost[u][w];
	    			//System.out.println(dist[w]);
	    		}
	    	}
	    }
	}
	
	public int minimumDistance(int[] dist, boolean[] s, int n)
	{
		int min = 9999;
		int index = -1;
		for(int i=1; i<=n; i++)
		{

			if(s[i] == false)
			{
				if(dist[i]<min)
				{
					min = dist[i];
					index=i;
				}

			}
		}
		return index;
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
				int in = sc.nextInt();
				if(in == 0)
				    graph[i][j] = 99;
				else
					graph[i][j] = in;
			}
		}
		System.out.println("Source vertex:");
		int source = sc.nextInt();
		sc.close();
		
		int[] dist = new int[n+1];
		Path p = new Path();
		p.ShortestPaths(source, graph, dist, n);
		for (int i=1; i<=n; i++)
		{
			System.out.println(dist[i]);
		}
		for(int x=1; x<=n; x++)
		{
			if(x != source && dist[x]!=99)
			    System.out.println("Shortest distance of "+source+" from "+x+" is--  "+dist[x]);
		}
	}
}
