package graph;
import java.io.File;
import java.util.Scanner ;

public class MyGraph {
     private Node[] nodes;
     private int size;
     LinkedListForward list;
     
     public MyGraph()
     {
          size = 0;
     }
     
     public void createGraph() throws Exception
     {
    	 try {
    		 //read from file
    		 File inFile = new File("LinkedGraph.txt");          
    		 Scanner opnScanner = new Scanner (inFile) ;

    		 size = opnScanner.nextInt();
    		 //declare array to store adjacency lists
    		 nodes = new Node[size+1];
    		 //System.out.println(size)
    		 int vertex;
    		 int adjacent;
    		 for(int i = 1; i <= size; i++)
    		 {
    			 vertex =  opnScanner.nextInt();
    			 LinkedListForward lsf = new LinkedListForward();
    			 adjacent = opnScanner.nextInt();               
    			 while( adjacent != 0 )  {                    
    				 lsf.insert(adjacent);
    				 adjacent = opnScanner.nextInt();
    			 }//end while
    			nodes[vertex] = lsf.getFirst();
    		 }//end for
    		 opnScanner.close();
    	 }
     catch (Exception e) {
    		 // TODO: handle exception
    		 System.out.println(e.getMessage());
    	 }

     }


     public void printGraph()
     {
    	 Node temp;
         for(int i=1; i<=size;i++)
         {
              System.out.print(i + "  ");
              temp = nodes[i];
              while(temp!=null)
              {
                   System.out.print(temp.getInfo() + "  ");
                   temp = temp.getLink();
              }
              System.out.println();
         }
     }
     //for integer
     public void breadthFirstTraversal(int start)
     {          
          ArrayQueue<Integer> linkedQueue = new ArrayQueue<>(100);
          //for each vertex V in G if V is not visited add V to the queue
          boolean[] visited = new  boolean[size];
          //initially all the vertices are unvisited
          for(int i = 0; i < size; i++)
               visited[i] = false;
          
          linkedQueue.enqueue(start);
          visited[start] = true;
          
          int current, adjacentToCurrent;
          Node temp;
          while (!linkedQueue.isEmpty())
          {               
               current = linkedQueue.dequeue();
               System.out.print(current + "   ");
               //retrieve the vertices adjacent to current
               temp = nodes[current];
               while ( temp != null ) {
                    adjacentToCurrent = temp.getInfo();
                    if( !visited[adjacentToCurrent] ) {
                         linkedQueue.enqueue(adjacentToCurrent);
                         visited[adjacentToCurrent] = true;
                    }//end if
                    temp = temp.getLink();
               }//end while temp null
          }//end while empty queue
          
     }//end method breadth first traversal

     public static void main(String[] args) {
		MyGraph g = new MyGraph();
		try {
			g.createGraph();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		g.printGraph();
		//g.breadthFirstTraversal(0);
	}
}