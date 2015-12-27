package graph;
public class Node
{
     private int info;
     private Node link;
     
     public Node(int info, Node link)
     {
          this.info = info;
          this.link = link;
     }
     
     public int getInfo() { return info; }
     public void setInfo(int info) { this.info = info; }
     
     public Node getLink() { return link; }
     public void setLink(Node link) { this.link = link; }
     
     /*public int compareTo(E a)
     {
        return info.compareTo(a);
     }*/
     
}