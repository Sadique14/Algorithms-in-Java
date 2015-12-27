import java.util.Scanner;

public class Tapes {
	public static int[] b;

	public static void combination(int[] a, int k, int n)
	{
		if(k == n)
		{
			a[k] = 0;
			print(a, n);
			a[k] = 1;
			print(a, n);
			return;
		}
		if(k<=n)
		{
			a[k] = 0;
			combination(a, k+1, n);
			a[k] = 1;
			combination(a, k+1, n);
		}

	}
	public static void print(int[] a, int n) 
	{
		int sum = 0;
		for(int i=1; i<=n; i++)
		{
			if(a[i] == 1)
			{
				System.out.print(b[i]+" ");
				sum++;
			}
		}
		if(sum==0)
			System.out.println("null");
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("n = ");
		int n = sc.nextInt();
		b = new int[n+1];
		for(int i=1; i<=n; i++)
		{
			b[i] = sc.nextInt();
		}
		
		int[] a = new int[n+1];
		combination(a, 1, n);
	}
}
