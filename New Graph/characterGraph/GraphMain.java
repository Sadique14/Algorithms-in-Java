package characterGraph;

public class GraphMain {

	public static void main(String[] args) {
		Graph g = new Graph();
		try {

			g.createGraph();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//g.printGraph();
        //g.breadthFirstSearch('A');
        g.depthFirstSearch('A');

	}
}

