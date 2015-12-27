package tree;
public class MyBinaryTreeV2{
     public BTNode root;
     
     public MyBinaryTreeV2()
     {
          root = null;
          nodeCount = 0;
          leafCount = 0;
     }
     public void setRoot(BTNode e)
     {
    	 root = e; 
     }
     
     public boolean isEmpty(){   return root == null;  }
     
     public void preorderTraversal(BTNode current)
     {
          if ( current != null )
          {
               nodeCount++;
               if(current.getLeft() == null && current.getRight() == null)
                    leafCount++;
               System.out.print(current.getInfo()+"  ");
               preorderTraversal(current.getLeft());
               preorderTraversal(current.getRight());
          }
     }
     
     public void inorderTraversal(BTNode current)
     {
       if ( current != null )
          {
               inorderTraversal(current.getLeft());
               System.out.print(current.getInfo()+"  ");
               inorderTraversal(current.getRight());
          }
     }
     
     public void postorderTraversal(BTNode current)
     {
       if ( current != null )
          {
               postorderTraversal(current.getLeft());
               postorderTraversal(current.getRight());
               System.out.print(current.getInfo()+"  ");
          }
     }
     
     public int TreeHeight(BTNode temp)
     {
        if(temp==null)
          return 0;
        else
          return 1 + max(TreeHeight(temp.getLeft()), TreeHeight(temp.getRight()));
     }
     
     private int max(int heightLeft, int heightRight)
     {
       if (heightLeft>heightRight)
         return heightLeft;
       else
         return heightRight;
     }
     
     public int TreeNodeCount()
     {
          nodeCount = 0; 
          preorderTraversal(root);
          return nodeCount;
     }
     
     private int nodeCount = 0;
     private int leafCount = 0;
     
     public int TreeLeavesCount()
     {
          leafCount = 0; 
          preorderTraversal(root);
          return leafCount;
     }
     
}