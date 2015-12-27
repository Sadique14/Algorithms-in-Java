
import java.util.Scanner;
public class Heap {
	int x;
    
	//insertion into a heap
	public boolean insert(int[] a, int n)
	{
		int i = n;
		int temp = a[n];
		while(i>0 && temp > a[(i-1)/2])
		{
			a[i] = a[(i-1)/2];
			i = (i-1)/2;
		}
		a[i] = temp;
		return true;
	}
	
	public void adjust(int[] a, int i, int n)
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
	//Deletion from a heap
	public boolean delMax(int[] a, int n)
	{
		if(n < 0)
		{
			System.out.println("Heap is empty");
			return false;
		}
		x = a[0]; 
        a[0] = a[n];
        adjust(a, 0, n-1);
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
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Heap heap = new Heap();
		int[] a = new int[12];
		int n = 0;
		while(n < 7)
		{
			a[n] = sc.nextInt();
			heap.insert(a, n);
			n++;
		}
		sc.close();
		heap.printHeap(a);
		
		System.out.println();
	}
}
