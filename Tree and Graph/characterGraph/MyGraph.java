package characterGraph;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;



public class MyGraph {
	private Node[] nodes;
	private int size;
	public MyGraph()
	{
		size=0;
	}
	public void createGraph() {
		try {
			File infile=new File("input.txt");
			Scanner op=new Scanner(infile);
			if (infile==null) {
				System.out.println("cannot open from empty file");
				return;
				
			}
			size=op.nextInt();
			nodes=new Node[size];
			int vertex;
			int adjacent;
			for (int i = 0; i <size; i++) {
				vertex=op.nextInt();
				LinkedListForward lsf=new LinkedListForward<Integer>();
				adjacent=op.nextInt();
				while(adjacent!=-1)
				{
					lsf.insert(adjacent);
					adjacent=op.nextInt();
					
				}
				nodes[vertex]=lsf.getFirst();
				
			}
			
			op.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void printGraph() {
		Node temp;
		for (int i = 0; i <size; i++) {
			System.out.print(i+" ");
			temp=nodes[i];
			while(temp!=null)
			{
				System.out.print(temp.getInfo()+" ");
				temp=temp.getLink();
			}
			System.out.println();
			
		}
		
	}
	public void breadthFirstTraversal(int start) {
		ArrayQueue<Integer> linkedQueue=new ArrayQueue<Integer>(100);
		boolean[]visited=new boolean[size];
		for (int i = 0; i <size; i++) {
			visited[i]=false;
			
		}
		linkedQueue.enqueue(start);
		visited[start]=true;
		int current,adjacentToCurrent;
		Node<Integer>temp;
		int sum=0;
		while(!linkedQueue.isEmpty())
		{
			current=linkedQueue.dequeue();
			System.out.print(current+" ");
			sum+=current;
			temp=nodes[current];
			while(temp!=null)
			{
				adjacentToCurrent=temp.getInfo();
				if (!visited[adjacentToCurrent]) {
					linkedQueue.enqueue(adjacentToCurrent);
					visited[adjacentToCurrent]=true;
					
				}
				temp=temp.getLink();
			}
			
		}
		System.out.println("\nsum of trversal node:"+sum);
		
		
	}
	 public void depththFirstTraversal(int start)
     {          
          DynamicStack stack = new DynamicStack<Integer>();
          //for each vertex V in G if V is not visited add V to the queue
          boolean[] visited = new  boolean[size];
          //initially all the vertices are unvisited
          for(int i = 0; i < size; i++)
               visited[i] = false;
          
          stack.push(start);
          visited[start] = true;
          
          int current, adjacentToCurrent;
          Node<Integer> temp;
          while (!stack.isEmpty())
          {               
               current = stack.pop();
               System.out.print(current + " ");
               //retrieve the vertices adjacent to current
               temp = nodes[current];
              
               while ( temp != null ) {
                    adjacentToCurrent = temp.getInfo();
                    
                    if( !visited[adjacentToCurrent] ) {
                         stack.push(adjacentToCurrent);
                         visited[adjacentToCurrent] = true;
                    }//end if
                    temp = temp.getLink();
                 
               }//end while temp null
          }//end while empty queue
        
          
     }//end method breadth first traversal

}
