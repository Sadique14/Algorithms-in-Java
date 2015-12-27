package primsAlgorithm;

import java.util.Scanner;

public class GraphToMinimumCostSpanningTree {

	public int Prim(int[][] cost, int n, int[][] t)
	{
		int[] temp = MinimumCost(cost, n);
		int k = temp[0];
		int l = temp[1];
		t[1][0] = k;
		t[1][1] = l;
		int mincost = cost[k][l];
		int[] near = new int[n+1];
		for(int i=1; i<=n; i++)
		{
			if(cost[i][l] < cost[i][k])
			{
				near[i] = l;
			}
			else if(cost[i][l] > cost[i][k])
			{
				near[i] = k;
			}
			else
				near[i] = 99;
		}
		near[k] = near[l] = 0;
		for(int i=2; i<=n-1; i++)
		{
			 int j = MinimumCost(cost, near, n);
			 t[i][0] = j;
			 t[i][1] = near[j];
			 mincost+=cost[j][near[j]];
			 near[j] = 0;
			 for(int x=1; x<=n; x++)
			 {
				 if(near[x]>n)
					 near[x] = j;
				 else if(near[x] != 0 && cost[x][near[x]] > cost[x][j])
					 near[x] = j;
			 }
		}
		return mincost;
	}
	public int[] MinimumCost(int[][] cost, int n)             
	{
		int[] min = new int[2];
		int temp=999;
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n; j++)
			{
				if(cost[i][j] < temp)
				{
					temp = cost[i][j];
					min[0] = i;
					min[1] = j;
				}
			}
		}
		return min;
	}
	public int MinimumCost(int[][] cost, int[] near, int n)    //return index of near which cost is minimum
	{
		int min = 9999;
		int minNear = 0;
		for(int i=1; i<=n; i++)
		{
			if(near[i]<=n)
			{
				if(cost[i][near[i]] < min && near[i]!=0)
				{
					min = cost[i][near[i]];
					minNear = i;
				}

			}
		}
		return minNear;
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
			}
		}
		sc.close();
		GraphToMinimumCostSpanningTree gs = new GraphToMinimumCostSpanningTree();
        int[][] t = new int[n+1][2];
        int minimumCost = gs.Prim(graph, n, t);
        System.out.println("Minimum Cost: "+minimumCost);
        for(int i=1; i<n; i++)
		{
			for(int j=0; j<2; j++)
			{
				System.out.print(t[i][j]+" ");
			}
			System.out.println();
		}
	}
}
