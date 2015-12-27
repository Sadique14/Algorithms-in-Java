package jobSequencing;

import java.util.Scanner;

public class Job {

	public int JS(Container[] c, int[] j, int n)
	{
		c[0].d=j[0]=0;
		j[1] = 1;
		int k = 1;
		for(int i=2; i<=n; i++)
		{
			int r=k;
			while(c[j[r]].d > c[i].d && c[j[r]].d != r)
				r = r-1;
			if(c[j[r]].d < c[i].d && c[i].d>r)
			{
				for(int q=k; q<=r+1; q++)
				{
					j[q+1] = j[q]; 
				}
				j[r+1] = i;
				k++;
			}
		}
		return k;
	}
	
	public void DecreasingSort(Container[] c)
	{
		for(int i=2; i<c.length; i++)
	    {
	        int key = c[i].p;
	        Container temp = c[i];
	        int j = i-1;
	        while(j>=1 && key>c[j].p)
	        {
	            c[j+1] = c[j];
	            j--;
	        }
	        c[j+1] = temp;
	    }
	}
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("Number of jobs: ");
		int n = sc.nextInt();
		System.out.println("Their prices:");
		Container[] c = new Container[n+1];
		int l=0;
		for(int i=0; i<=n; i++)
		{
			c[i] = new Container();
			c[i].s = l++;
		}
		for(int i=1; i<=n; i++)
		{
			c[i].p = sc.nextInt();
		}
		System.out.println("Their deadlines:");
		for(int i=1; i<=n; i++)
		{
			c[i].d = sc.nextInt();
		}
		sc.close();
		
		Job jb = new Job();
		int[] j = new int[n+1];
		jb.DecreasingSort(c);
		int k = jb.JS(c, j, n);
		System.out.println("Number of jobs can be done: "+k);
		
		int profit = 0;
		for(int i=1;i<=n;i++)
		{
			profit+=c[j[i]].p;
		}
		System.out.println("Total Profit: "+profit);
		System.out.println("Their sequence:");
		for(int i=1;i<=k;i++)
		{
			System.out.print(c[j[i]].s+" ");
		}
	}
}
