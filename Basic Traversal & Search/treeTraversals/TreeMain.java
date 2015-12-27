package treeTraversals;

public class TreeMain {

	public static void main(String[] args) {
		//I manually took input the tree of figure 6.1 of Algorithms book
		Traversal t = new Traversal();
		Node root = new Node('A');
		t.setRoot(root);
		t.root.setLchild('B');
		t.root.setRchild('C');
		t.root.getLchild().setLchild('D');
		t.root.getLchild().setRchild('E');
		t.root.getLchild().getLchild().setLchild('F');
		t.root.getLchild().getLchild().setRchild('G');
		t.root.getLchild().getLchild().getRchild().setLchild('H');
		t.root.getLchild().getLchild().getRchild().setRchild('I');
		System.out.println("InOrder Traversal:");
		t.inOrder(root);
		System.out.println();
		System.out.println("PreOrder Traversal:");
		t.preOrder(root);
		System.out.println();
		System.out.println("PostOrder Traversal:");
		t.postOrder(root);
		System.out.println();
		System.out.println("Triple Order:");
		t.Triple(root);
	}
}
