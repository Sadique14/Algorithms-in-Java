package tree;
public class Main
{
     public static void main(String[] args) {
          MyBinaryTreeV2 mbt = new MyBinaryTreeV2();
          
          BTNode node1 = new BTNode(10);
          mbt.setRoot(node1);
          mbt.root.setLeft(20);
          mbt.root.setRight(30);          
          
          mbt.root.getLeft().setRight(50);
          mbt.root.getLeft().setLeft(40);
          mbt.root.getLeft().getLeft().setLeft(80);
          
          mbt.root.getRight().setLeft(60);
          mbt.root.getRight().getLeft().setLeft(90);
          mbt.root.getRight().setRight(70);
          mbt.root.getRight().getRight().setRight(100);
          
          mbt.preorderTraversal(mbt.root);
          System.out.println();
          mbt.inorderTraversal(mbt.root);
          System.out.println();
          mbt.postorderTraversal(mbt.root);
          System.out.println();
          System.out.println("No of nodes " + mbt.TreeNodeCount());
          System.out.println("No of leaves " + mbt.TreeLeavesCount());
          System.out.println("Height " + mbt.TreeHeight(mbt.root));
     }
}