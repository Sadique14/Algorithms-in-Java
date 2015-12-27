package multistageGraph;

import java.util.Scanner;

public class AllPairsShortestPath {

	public static void AllPaths(int[][] cost, int[][] A, int n)
	{
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n; j++)
			{
				A[i][j] = cost[i][j];
			}
		}
		for(int k=1; k<=n; k++)
		{
			for(int i=1; i<=n; i++)
			{
				for(int j=1; j<=n; j++)
				{
					if((A[i][k]+A[k][j]) < A[i][j])
					    A[i][j] = A[i][k]+A[k][j];
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Number of vertices:");
		int n = sc.nextInt();
		int[][] cost = new int[n+1][n+1];
		System.out.println("The graph:");
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n; j++)
			{
				cost[i][j] = sc.nextInt();
				//I took 99 as unlimited value
			}
		}
		sc.close();
		int[][] A = new int[n+1][n+1];
		
		AllPaths(cost, A, n);
		
		System.out.println("Result Graph:");
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n; j++)
			{
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}
}
