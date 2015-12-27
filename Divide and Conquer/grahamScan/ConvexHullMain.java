package grahamScan;

import java.io.*;
import java.util.Scanner;

public class ConvexHullMain {
	
	public static void main(String[] args) {
		Scanner sc = null;
		int length = 0;
		
		try {
			File in = new File("Coordinates.txt");
			sc = new Scanner(in);
			length = sc.nextInt();
			
		} catch (Exception e) {
			System.out.println("File not Found");
		}
		Coordinate[] cod = new Coordinate[length];
		for(int i=0; i<cod.length; i++)
		{
			cod[i] = new Coordinate();
		}
		int k = 0;
		while(sc.hasNextDouble())
		{
			cod[k].setX(sc.nextDouble());
			cod[k].setY(sc.nextDouble());
			k++;
		}
		sc.close();
		LinkedList list = new LinkedList();                 
		
		double y=999.00;
		double x = 0.0;
		for(int i=0; i<length; i++)
		{
			if(cod[i].getY() < y) 
			{
				y = cod[i].getY();
				x = cod[i].getX();
				k=i;
			}
		}
		cod[k].setX(cod[0].getX());
		cod[k].setY(cod[0].getY());
		cod[0].setX(x);
		cod[0].setY(y);
		
		double angle = 0.0;
		for(int i=1; i<length; i++)
		{
		    angle = polarAngle(cod[0].getX(), cod[0].getY(), cod[i].getX(), cod[i].getY());
		    cod[i].angle = angle;
		}
		//sorting the list according to polar angle
		sort(cod);
		//insert the sorted list into an linked list
		for (int i = 0; i < cod.length; i++) 
		{
			list.insertLast(cod[i].getX(), cod[i].getY());
		}
		ConvexHull c = new ConvexHull(list.getFirst());
		//System.out.println(list.print());
	}
	
	public static void sort(Coordinate[] a)
	{
		for(int i=2; i<a.length; i++)
	    {
	        int j=i-1;
	        Coordinate key = a[i];
	        while(j>=1 && a[j].angle>key.angle)
	        {
	            a[j+1]=a[j];
	            j--;
	        }
	        a[j+1] = key;
	    }
	}
	public static double polarAngle(double x1, double y1, double x, double y)
	{
	  return -(x-x1)/(y-y1);
	}
}
