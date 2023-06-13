import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CycleDetector {
	int[] edgeTo;
	boolean[] marked;
	boolean hasCycle;
	ArrayList<Integer> cyclePath;

	public CycleDetector(Graph g) {
		edgeTo = new int[g.V()];
		marked = new boolean[g.V()];

		for (int v = 0; v < g.V(); v++)
			if (!marked[v] && !hasCycle())
				dfs(g, v, v);
	}

	public void dfs(Graph g, int v, int pred) {
		marked[v] = true;
		for (int w : g.adj(v)) {
			if (hasCycle())
				return;

			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(g, w, v);
			} else if (w != pred) {
				hasCycle = true;
				cyclePath = new ArrayList<Integer>();
				cyclePath.add(w);
				for(int i = v ; i != w ; i = edgeTo[i]) {
					cyclePath.add(i);
				}
				cyclePath.add(w);
			}
		}
	}

	public boolean hasCycle() {
		return hasCycle;
	}

	public ArrayList<Integer> getCyclePath(){
		return cyclePath;
	}
	public static void main(String[] args) throws FileNotFoundException {
		Graph g = new Graph(args[0]);
//		g.removeEdge(3, 4);
//		g.removeEdge(0, 6);
//		g.removeEdge(9, 11);

		CycleDetector c = new CycleDetector(g);
		System.out.println("Has Cycle: " + c.hasCycle());
		
		if(c.hasCycle()) {
			ArrayList<Integer> cyclePath = c.getCyclePath(); 
			System.out.print("Cycle: ");
			for(int path : cyclePath) {
				System.out.print(path);
			}
		}
	}
}