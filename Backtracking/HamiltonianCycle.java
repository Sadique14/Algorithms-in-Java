import java.util.Scanner;

public class HamiltonianCycle {

	public static int[][] g;
	public static int[] x;
	public static int n;
	public static void Hamiltonian(int k)
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
				Hamiltonian(k+1);      
		}
		while(true);
	}
	public static void NextValue(int k)
	{
		do {
			x[k] = (x[k] + 1) % (n+1);
			if(x[k] == 0)
				return;
			int j;
			if(g[x[k-1]][x[k]] != 0)
			{
				for(j=1; j<=k-1; j++)
				{
					if(x[j] == x[k])
						break;
				}
				if(j == k)
				{
					if(k<n || (k==n && g[x[n]][x[1]] != 0))
					{
						return;
					}
				}	
			}
		} while (true);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("number of vertices:");
		n = sc.nextInt();
		g = new int[n+1][n+1];
		System.out.println("The Graph:");
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n; j++)
			{
				g[i][j] = sc.nextInt();
				/* I took input from figure 7.15 of Algorithms book
				 0 1 1 0 0 0 1 0
                 1 0 1 0 0 0 0 1
                 1 1 0 1 0 1 0 0
                 0 0 1 0 1 0 0 0
                 0 0 0 1 0 1 0 0
                 0 0 1 0 1 0 1 0
                 1 0 0 0 0 1 0 1
                 0 1 0 0 0 0 1 0
				 */
			}
		}
		sc.close();
		x = new int[n+1];
		for(int i=1; i<=n; i++)
		{
			x[1]=i;
			for(int j=2; j<=n; j++)
			{
				x[j]=0;
			}
			Hamiltonian(2);
		}
		
	}
}
