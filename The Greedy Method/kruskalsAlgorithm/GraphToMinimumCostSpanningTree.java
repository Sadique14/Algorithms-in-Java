package kruskalsAlgorithm;

import java.util.Scanner;
import java.lang.Math;

public class GraphToMinimumCostSpanningTree {

	int min=0;
	int[] parent = new int[10];
	public int Kruskal(int[] E, int[][] cost, int n, int[][] t)
	{
		Heapify(E, n);
		//all elements of parents are already 0
		int i=0;
		int mincost = 0;
		//printHeap(E);
		while(i<(n-1) && delmin(E, n))
		{
			int minimum = min;
			int[] temp = findVertex(cost, min, n);
			int x,y;
			int u= x = temp[0];
			int v= y = temp[1];
			
			int j = find(u);
			int k = find(v); 
			if(Union(j, k))
			{
				i++;
				t[i][0] = u;
				t[i][1] = v;
				mincost+=cost[u][v];
			}
			cost[x][y] = cost[y][x] = 0;
		}
        return 0;
	}
	
	public int find(int i)
	{
		while(parent[i]!=0)
			i = parent[i];
		return i;
	}
	public boolean Union(int i,int j)
	{
		if(i!=j)
		{
			parent[j]=i;
			return true;
		}
		return false;
	}
	public int[] findVertex(int[][] cost, int min, int n)
	{
		int[] temp = new int[2];
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n; j++)
			{
				if(cost[i][j] == min)
				{
					temp[0] = i;
					temp[1] = j;
					break;
				}
			}
		}
		return temp;
	}
	public static void Heapify(int[] a, int n)
	{
		for(int j=2; j<=n; j++)
		{
			int i = j;
			int temp = a[j];
			while(i>1 && temp > a[i/2])
			{
				a[i] = a[i/2];
				i = i/2;
			}
			a[i] = temp;
		}
	}
	
	public void adjust(int[] a, int i, int n)
	{
		int item = a[i];
		int j = 2*i;
		while(j <= n)
		{
			if(j<n && a[j]<a[j+1])
				j = j+1;
			if(item > a[j])
				break;
			else
			{
				a[j/2] = a[j];
				j = 2*j;
			}
		}
		a[j/2] = item;
	}
	//Deletion from a heap
	public boolean delmin(int[] a, int n)
	{
		if(n < 1)
		{
			System.out.println("Heap is empty");
			return false;
		}
		min = a[1]; 
        a[1] = a[n];
        adjust(a, 1, n-1);
        a[n] = 0;
        return true;
	}

	public void printHeap(int[] a)
	{
		for(int i:a)
		{
			System.out.print(i+" ");
		}
	}
	public int[] removeDuplicate(int[] E)
	{
		int n = (int)Math.sqrt(E.length-1);
		int k = 5;
		for(int i=2; i<=n; i++)
		{
			for(int j = 1; j<=i; j++)
			{
				E[k+j] = 0;
			}
			k += 5;
		}
		int[] temp = new int[E.length];
		k=1;
		for(int i=1; i<E.length; i++)
		{
			if(E[i]!=0)
			{
				temp[k++] = E[i];
			}
		}
		E = new int[k];
		for(int i=1; i<E.length; i++)
		{
			E[i] = temp[i];
		}
		return E;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Number of vertex:");
		int n = sc.nextInt();
		int[][] graph = new int[n+1][n+1];
		int[] Edge = new int[(n*n)+1];
		System.out.println("Enter costs:");
		int k=1;
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n; j++)
			{
				int x = sc.nextInt();
				Edge[k++] = x;
				if(x==0)
				    graph[i][j] = 999;
				else
					graph[i][j] = x;
			}
		}
		sc.close();
		GraphToMinimumCostSpanningTree gs = new GraphToMinimumCostSpanningTree();
		int[] E = gs.removeDuplicate(Edge);
		int[][] t = new int[n+1][2];
		gs.Kruskal(E, graph, n, t);
	}
}
