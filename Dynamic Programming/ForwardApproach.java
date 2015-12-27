
import java.io.File;
import java.util.Scanner;

public class ForwardApproach {

	public static void FGraph(int[][] c, int k, int n, int[] p)
	{
		int[] d = new int[n+1];
		int[] cost = new int[n+1];
		cost[n] = 0;
		for(int j=n-1; j>=1; j--)
		{
			int r = nextVertex(j,c,n,cost);
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
	public static int nextVertex(int j, int[][] c, int n, int[] cost) 
	{
		int min = 9999;
		int vertex = 0;
		for(int r=1; r<=n; r++)
		{
			if(c[j][r] != 0 && c[j][r]+cost[r] < min)
			{
				min = c[j][r]+cost[r];
				vertex = r;
			}
		}
		return vertex;
	}
	
	public static void main(String[] args) {
		Scanner sc=null;
		int k=0;
		int n=0;
		try {
			sc = new Scanner(new File("MultistageGraph.txt"));
			k = sc.nextInt();
			n = sc.nextInt();
			int cost[][] = new int[n+1][n+1];
			int x;
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
			
			for(int i=1; i<=k; i++)
			{
				System.out.print(p[i]+" " );
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
