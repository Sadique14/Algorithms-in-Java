
import java.io.File;
import java.util.Scanner;

public class BackwardApproach {

	public static void BGraph(int[][] c, int k, int n, int[] p)
	{
		int[] d = new int[n+1];
		int[] bcost = new int[n+1];
		bcost[1] = 0;
		for(int j=2; j<=n; j++)
		{
			int r = nextVertex(j,c,n,bcost);
			bcost[j] = bcost[r]+c[r][j];
			d[j] = r;
			
		}
		p[1] = 1;
		p[k] = n;
		for(int j=k-1; j>=2; j--)
		{
			p[j] = d[p[j+1]];
			
		}
	}
	private static int nextVertex(int j, int[][] c, int n, int[] bcost) 
	{
		int min = 9999;
		int vertex = 0;
		for(int r=1; r<=n; r++)
		{
			if(c[r][j] != 0 && c[r][j]+bcost[r] < min)
			{
				min = c[r][j]+bcost[r];
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
			
			BGraph(cost, k, n, p);
			
			for(int i=1; i<=k; i++)
			{
				System.out.print(p[i]+" " );
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
