package multistage;

import java.io.File;
import java.util.Scanner;

public class Graph {
	static boolean[] temp;

	public static void FGraph(int[][] c, int k, int n, int[] p)
	{
		int temp[]=new int[n+1];
		temp[1]=1;
		for(int i=1;i<k;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(temp[j]==i)
				{
					for(int l=1;l<=n;l++)
					{
						if(c[j][l]!=99)
						{
							temp[l]=i+1;
						}
					}
				}
			}	
		}
		for(int i=1;i<=k;i++)
		{
			System.out.print("Stage "+i+": ");
			for(int j=1;j<=n;j++)
			{
				if(temp[j]==i)
				{
					System.out.print(j+" ");
				}
				
				
			}
			System.out.println();	
		}
		
		int[] d = new int[n+1];
		//d[n] = 0;
		int[] cost = new int[n+1];
		cost[n] = 0;
		//int l=k;
		for(int j=n-1; j>=1; j--)
		{
			int r = next(j,c,n,cost);
			//l--;
			cost[j] = c[j][r] + cost[r];
			d[j] = r;
		}
		p[1] = 1;
		p[k] = n;
		for(int j=2; j<=k-1; j++)
		{
			p[j] = d[p[j-1]];
		}
	}
	public static int next(int j, int[][] c, int n, int[] cost) 
	{
		int min = 99;
		int v = 0;
		for(int r=1; r<=n; r++)
		{
			if(c[j][r] != 0)
			{
				//temp[l][r] = true;
				if(c[j][r]+cost[r] < min)
				{
					min = c[j][r]+cost[r];
					v = r;
				}
			}
		}
		return v;
	}
	
	public static void main(String[] args) {
		Scanner sc=null;
		int k=0;
		int n=0;
		
		
			sc = new Scanner(System.in);
			System.out.println("number of stage: ");
			k = sc.nextInt();
			boolean[]  stage = new boolean[n+1];
			for(int m=0; m<=n; m++)
			{
				stage[m] = false;
			}
			
			System.out.println("number of vertices:");
			n = sc.nextInt();
			
			int cost[][] = new int[n+1][n+1];
			int x;
			//stage[1][1] = true;
			for(int i=1; i<=n; i++)
			{
				for(int j=1; j<=n; j++)
				{
					x = sc.nextInt();
					if(x==0)
					    cost[i][j] = 99;
					else
						cost[i][j] = x;
				
				}
			}
			sc.close();
			
			int[] p = new int[k+1];
			FGraph(cost, k, n, p);
			
			System.out.println("shortest path:");
			
			for(int i=1; i<=k; i++)
			{
				System.out.print(p[i]+" " );
			}
		
	}
}
