package binarySearchTree;
import java.util.Scanner;

public class BstMain {

	public static void main(String[] args) {
		Bst b = new Bst();
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<4; i++)
		{
			b.insert(sc.nextInt());
		}
		sc.close();
		//System.out.println(b.tree);
		//System.out.println(b.tree.getInfo());
		b.preorderTraversal(b.tree);
	}
}
