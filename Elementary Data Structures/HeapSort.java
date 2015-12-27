  import java.util.Scanner;

public class HeapSort {

	public static void adjust(int[] a, int i, int n)
	{
		int item = a[i];
		int j = 2*i+1;
		while(j <= n)
		{
			if(j<n && a[j]<a[j+1])
				j = j+1;
			if(item > a[j])
				break;
			else
			{
				a[(j-1)/2] = a[j];
				j = 2*j+1;
			}
		}
		a[(j-1)/2] = item;
	}
	
	public static void Heapify(int[] a, int n)
	{
		for(int j=1; j<=n; j++)
		{
			int i = j;
			int temp = a[j];
			while(i>0 && temp > a[(i-1)/2])
			{
				a[i] = a[(i-1)/2];
				i = (i-1)/2;
			}
			a[i] = temp;
		}
	}
	
	public static void heapSort(int[] a, int n)
	{
		Heapify(a, n);
		
		int temp;
		for(int i=n; i>0; i--)
		{
			temp = a[i];
			a[i] = a[0];
			a[0] = temp;
			adjust(a, 0, i-1);
		}
	}
	public static void printHeap(int[] a)
	{
		for(int i:a)
		{
			System.out.print(i+" ");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[12];
		int n = 0;
		while(n < 7)
		{
			a[n] = sc.nextInt();
			n++;
		}
		sc.close();
		printHeap(a);

		Heapify(a, 6);
		heapSort(a, 6);
		System.out.println();
	    printHeap(a);
	}
}
