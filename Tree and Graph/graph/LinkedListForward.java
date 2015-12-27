package graph;
public class LinkedListForward
{
     Node first, last, newNode;
     
     public LinkedListForward()
     {
          first = null;
          last = null;
     }
     
     public Node getFirst()
     {
          return first;
     }
     
     public void insert(int x)
     {
          newNode = new Node(x, null);
          if (first == null) {
               //list is empty
               //both first and last pointing newNode
               first = last = newNode;
          }
          else{
               //list is not empty add newNode after last
               last.setLink(newNode);
               //change last
               last = newNode;
          }
     }
     
     /*Returns a simple character string showing the current board.*/
     public String toString() {
          StringBuilder sb = new StringBuilder();
          for (Node i = first; i != null; i=i.getLink()) { //for#1
               if(i == first)
                    sb.append(i.getInfo());
               else
                    sb.append(", " + i.getInfo());
          }//end for#1
          
          return sb.toString();
     }//end toString
}