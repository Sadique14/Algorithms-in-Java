package characterGraph;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;



public class MyGraph2 {
	private Node[] nodes;
	private char[] charNodes;
	private Node<Character>ch[];
	private int size;
	public MyGraph2()
	{
		size=0;
	}
	public void createGraph() {
		try {
			File infile=new File("H:\\2nd year, 1st term\\Data Structure LAB\\New Graph\\input5.txt");
			Scanner op=new Scanner(infile);
			if (infile==null) {
				System.out.println("cannot open from empty file");
				return;
				
			}
			size=op.nextInt();
			nodes=new Node[size];
			charNodes=new char[size];
			int vertex;
			int adjacent;
			for (int i = 0; i <size; i++) {
				vertex=intToChar(op.next().charAt(0));
				LinkedListForward lsf=new LinkedListForward<Integer>();
				adjacent=intToChar(op.next().charAt(0));
				while(adjacent!=-1)
				{
					lsf.insert(adjacent);
					adjacent=intToChar(op.next().charAt(0));
					
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
		LinkedListForward linkedQueue=new LinkedListForward<Integer>();
		boolean[]visited=new boolean[size];
		for (int i = 0; i <size; i++) {
			visited[i]=false;
			
		}
		linkedQueue.insert(start);
		visited[start]=true;
		int current,adjacentToCurrent;
		Node<Integer>temp;
		while(!linkedQueue.isEmpty())
		{
			current=linkedQueue.remove();
			System.out.print(charNodes[current]+" ");
			temp=nodes[current];
			while(temp!=null)
			{
				adjacentToCurrent=temp.getInfo();
				if (!visited[adjacentToCurrent]) {
					linkedQueue.insert(adjacentToCurrent);
					visited[adjacentToCurrent]=true;
					
				}
				temp=temp.getLink();
			}
		}
		
		
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
               System.out.print(charNodes[current]+ " ");
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
	 private int nodeChar=0;
	 private int intToChar(char ch) {
		int retvalue=-1;
		if (ch=='#') {
			return retvalue;
			
		}
		for (int i = 0; i <nodeChar; i++) {
		
			if (charNodes[i]==ch) {
				return i;
				
			}
			
		}
		//System.out.println("Nodes"+ch);
		charNodes[nodeChar]=ch;
		retvalue=nodeChar;
		nodeChar++;
		return retvalue;
		
	}

}
