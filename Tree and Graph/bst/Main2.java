package bst;
public class Main2
{
     public static void main(String[] args) {
          MyBinaryTreeV3 mbt = new MyBinaryTreeV3();
          
          ///BinarySearchTree insertion
          mbt.BSTInsertALt(43);
          mbt.BSTInsertALt(31);
          mbt.BSTInsertALt(64);
          mbt.BSTInsert(20);
          mbt.BSTInsert(40);
          mbt.BSTInsert(56);
          mbt.BSTInsert(89);
          mbt.BSTInsert(28);
          mbt.BSTInsert(33);
          mbt.BSTInsert(47);
          mbt.BSTInsert(59);
          ////////////////////////////////
          
          //mbt.delete(54);
                    
          mbt.preorderTraversal(mbt.root);
          System.out.println();
          mbt.delete(43);
          mbt.preorderTraversal(mbt.root);
          //mbt.inorderTraversal(mbt.root);
          //System.out.println();
          //mbt.postorderTraversal(mbt.root);
          //System.out.println("No of nodes " + mbt.TreeNodeCount());
          //System.out.println("No of leaves " + mbt.TreeLeavesCount());
          //System.out.println("Height " + mbt.TreeHeight(mbt.root));
          //System.out.println(mbt.maximumNode(mbt.root).getInfo());
     }
}