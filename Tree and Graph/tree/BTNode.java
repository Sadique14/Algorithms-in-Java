package tree;
public class BTNode{
    public int info;
    public BTNode left, right;
    
    public BTNode(int x)
    {
        info = x;
        left = null;
        right = null;
    }
    
    public int getInfo()
    {
         return info;
    }
    
    public void setLeft ( int x ) {
        if ( this.left != null ) {
            System.out.println("Invalid insertion!!");
            return;
        }
        else{
            BTNode p = new BTNode(x);
            this.left = p;
         }
    }
    
    public BTNode getLeft ( ) {
         return left;
    }

     public BTNode getRight ( ) {
         return right;
    }
    
    public void setRight (int x ) 
    {
        if ( this.right != null ) {
            System.out.println("Invalid insertion!!");
            return;
        }
        else{
            BTNode p = new BTNode(x);
            this.right = p;         
        }
    }
    
}