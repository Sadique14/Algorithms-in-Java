package binaryTree;
public class MyBinaryTreeV2{
     public BTNode root;
     
     public MyBinaryTreeV2()
     {
          root = null;
     }
     public void setRoot(BTNode e)
     {
    	 root = e; 
     }
     
     public boolean isEmpty()
     {
    	 return root == null;  
     }
     
     public void preorderTraversal(BTNode current)
     {
          if ( current != null )
          {
               System.out.print(current.getInfo()+"  ");
               preorderTraversal(current.getLeft());
               preorderTraversal(current.getRight());
          }
     }
     
 
     
}