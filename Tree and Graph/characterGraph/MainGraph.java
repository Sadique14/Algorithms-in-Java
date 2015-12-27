package characterGraph;
public class MainGraph {

	
	public static void main(String[] args) {
		MyGraph2 g=new MyGraph2();
		g.createGraph();
		
		//g.printGraph();
		System.out.println("Breadth First traversal:");
		g.breadthFirstTraversal(0);
		System.out.println();
		System.out.println("Depth First Traversal");
		g.depththFirstTraversal(0);
		System.out.println();
		System.out.println("The graph is:");
		g.printGraph();
	}

}
