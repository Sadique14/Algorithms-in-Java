import java.util.Scanner;

public class SumOfSubsets {
	public int m;
	public int[] w;
	public int[] x;
    public void SumOfSub(int s, int k, int r)
    {
    	x[k] = 1;
    	if(s+w[k] == m)
    	{
    		for(int i=1; i<=k; i++)
    		{
    			System.out.print(x[i]+" ");
    		}
    		System.out.println();
    	}
    	else if(s + w[k] + w[k+1] <= m)
    	{
    		SumOfSub(s+w[k], k+1, r-w[k]);
    	}
    	if(((s+r)-w[k]) >=m && (s+w[k+1]) <=m)
    	{
    		x[k] = 0;
    		SumOfSub(s,k+1,r-w[k]);
    	}
    }
    public void nonDecreasingsort()
    {
    	for(int i=2; i<w.length; i++)
    	{
    		int key = w[i];
    	    int j = i-1; 
    		while(j >=1 && key < w[j])
    		{
    			w[j+1] = w[j];
    			j--;
    		}
    		w[j+1] = key;
    	}
    }
	public static void main(String[] args) {
		SumOfSubsets s = new SumOfSubsets();
		Scanner sc = new Scanner(System.in);
		System.out.println("number of elements:");
		int n = sc.nextInt();
		s.w = new int[n+1];
		s.x = new int[n+1];
		System.out.println("weights are:");
		int sum = 0;
		for(int i=1; i<=n; i++)
		{
			s.w[i] = sc.nextInt();
			sum += s.w[i];
		}
		s.nonDecreasingsort();
		System.out.println("m is");
		s.m = sc.nextInt();
		sc.close();
		s.SumOfSub(0, 1, sum);
	}
}
