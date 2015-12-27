package Heap;

public class Heap {

	public void createMaxHeap(int A[])
	{
		int temp;
		for(int i=1; i<=5; i++)
		{
			temp = A[i];
			int k = i;
			while(k>=0 && temp > A[(k-1)/2])
			{
				A[k] = A[(k-1)/2];
				k = (k-1)/2;
			}
			A[k] = temp;
		}
	}
	
	public static void main(String[] args) {
		Heap p = new Heap();
		int[] a = {45,28,52,25,60,70};
		p.createMaxHeap(a);
		for(int x:a)
		{
			System.out.println(x);
		}
	}
}
