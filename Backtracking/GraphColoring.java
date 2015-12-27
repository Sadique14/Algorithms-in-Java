import java.util.Scanner;

public class GraphColoring {

	public static int[][] g;
	public static int[] x;
	public static int n;
	public static int m;
	public static void mColoring(int k)
	{
		do
		{
			NextValue(k);     
			if(x[k] == 0)
				return;     
			if(k == n)     
			{
				for(int i=1; i<=n; i++)
				{
					System.out.print(x[i]+" ");
				}
				System.out.println();
			}
			else
				mColoring(k+1);      
		}
		while(true);
	}
	public static void NextValue(int k)
	{
		do {
			x[k] = (x[k] + 1) % (m+1);
			if(x[k] == 0)
				return;
			int j;
			for(j=1; j<=n; j++)
			{
				if(g[k][j] != 0 && x[k] == x[j])
					break;
			}
			if(j == n+1)
				return;
		} while (true);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("number of vertices:");
		n = sc.nextInt();
		System.out.println("maximum number of colors:");
		m = sc.nextInt(); 
		g = new int[n+1][n+1];
		System.out.println("The Graph:");
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n; j++)
			{
				g[i][j] = sc.nextInt();
				/*I took input from figure 7.11 of Algorithms book
				 0 1 1 0 1
                 1 0 1 0 1
                 1 1 0 1 0
                 0 0 1 0 1
                 1 1 0 1 0
				 */
			}
		}
		sc.close();
		x = new int[n+1];
		
		mColoring(1);
	}
}
