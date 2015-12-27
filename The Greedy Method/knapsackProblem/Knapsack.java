package knapsackProblem;
import java.util.Scanner;

public class Knapsack {

	public void GreedyKnapsack(int m, int n, Container[] c)
	{
		//initialize x to 0
		for(int i=0; i<n; i++)
		{
			c[i].x = 0.0f;
		}
		int u=m;              //remaining size
		int i;
		for(i=0; i<n; i++)
		{
			if(c[i].w>u)
			{
				break;
			}
			c[i].x = 1.0f;
			u=u-c[i].w;
		} 
		if(i<n)
		{
			c[i].x = u/(float)c[i].w;
		}
		//OldPosition(c);
	}
	
	public void DecreasingSort(Container[] c)
	{
		for(int i=1; i<c.length; i++)
	    {
	        float key = (c[i].p/(float)c[i].w);
	        Container temp = c[i];
	        int j = i-1;
	        while(j>=0 && key>(c[j].p/(float)c[j].w))
	        {
	            c[j+1] = c[j];
	            j--;
	        }
	        c[j+1] = temp;
	    }
	}
	public void OldPosition(Container[] c)
	{
		for(int i=1; i<c.length; i++)
	    {
	        int key = c[i].sortingVariable;
	        Container temp = c[i];
	        int j = i-1;
	        while(j>=0 && key<c[j].sortingVariable)
	        {
	            c[j+1] = c[j];
	            j--;
	        }
	        c[j+1] = temp;
	    }
	}
	
	public static void main(String[] args) {
		Knapsack k = new Knapsack();
		Scanner sc = new Scanner(System.in);
		System.out.print("Number of elements: ");
		int n = sc.nextInt();
		System.out.print("knapsack capacity: ");
		int m = sc.nextInt();
		Container[] c = new Container[n];
		int l = 0;
		for(int i=0; i<n; i++)
		{
			c[i] = new Container();
			c[i].sortingVariable = l++;
		}
		System.out.println("Price:");
		for(int i=0; i<n; i++)
		{
			c[i].p = sc.nextInt();
		}
		System.out.println("Weight:");
		for(int i=0; i<n; i++)
		{
			c[i].w = sc.nextInt();
		}
		sc.close();
		k.DecreasingSort(c);           //Sorting according to price/weight
		k.GreedyKnapsack(m, n, c);
		for(int i=0; i<n; i++)
		{
			System.out.println(c[i].x);
		}
	}
}
