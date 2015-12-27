
public class BinarySearch {

	//Recursive Binary Search
	public static int BinSearch(int[] a,int i, int l, int x)
	{
		if(i==l)
		{
			if(x==a[i])
				return i;
			else
				return -1;
		}
		else
		{
			int mid = (i+l)/2;
			if(x == a[mid])
				return mid;
			else if(x > a[mid])
				return BinSearch(a, mid+1, l, x);
			else {
				return BinSearch(a, i, mid-1, x);
			}
		}
	}
	
	//Iterative Binary Search
	public static int BinSearch(int[] a, int n, int x)
	{
		int low = 0;
		int high = n;
		while(low<=high)
		{
			int mid = (low+high)/2;
			if(x<a[mid])
				high = mid-1;
			else if(x>a[mid])
				low = mid + 1;
			else {
				return mid;
			}
		}
		return -1;
	}
	public static void main(String[] args) 
	{
		int[] a = {1,2,3,4,5,6,7,10};
		System.out.println(BinSearch(a, 0, a.length-1, 10));
		System.out.println(BinSearch(a, a.length-1, 4));
	}
}
