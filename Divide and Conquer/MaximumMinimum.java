
public class MaximumMinimum {

	static int max,min;
	static int[] a = {2,3,1,5,6,7,4,6,9};
	
	public static void maxmin(int i, int j)
	{
		int mid, max1 = 0, min1=0;
	    if(i==j)
	    {
	        max = a[i];
	        min = a[i];
	    }
	    else if(i == j-1)
	    {
	        if(a[i] < a[j])
	        {
	            max = a[j];
	            min = a[i];
	        }
	        else
	        {
	            max = a[i];
	            min = a[j];
	        }
	    }
	    else
	    {
	        mid = (i+j)/2;
	        
	        maxmin(i,mid);
	        
	        max1 = max;
	        min1 = min;
	        maxmin(mid+1,j);

	        if(max<max1)
	        {
	            max = max1;
	        }
	        if(min>min1)
	        {
	            min = min1;
	        }

	    }
	}
	public static void main(String[] args) {
		
		maxmin(0, 8);
		System.out.println(max);
		System.out.println(min);
		
	}
	
}
