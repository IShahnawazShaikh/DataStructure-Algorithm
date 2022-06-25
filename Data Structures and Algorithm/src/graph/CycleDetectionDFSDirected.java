package graph;
/***
 * @author Shahnawaz Shaikh
 * 
 *  Working: Used to detect cycle in a graph or not.
 *    
 *   Time Complexity:  O(V+E) 
 *   
 *   Space Complexity: O(V+E)+ O(V) + O(V) -> adjacency List, visited list, Auxiliary space 
 *     note: Adjacency List is given already
 *     
 *   Use Case: https://www.codingninjas.com/codestudio/problems/1062626
 * 
 */
import java.util.ArrayList;
import java.util.HashSet;

public class CycleDetectionDFSDirected {
	public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
	
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int i, m = edges.size();
		for (i = 0; i <= n; i++)
			adj.add(new ArrayList<Integer>());

		for (i = 0; i < m; i++)
			adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));

		boolean[] visited = new boolean[n + 1];

		for (i = 1; i <= n; i++) {
			if (visited[i] == false) {
				if (dfs(adj, i, visited, new HashSet<Integer>()) == true)
					return true;
			}
		}
		return false;
	}

	public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, HashSet<Integer> trace) {

		visited[src] = true;
		trace.add(src);
		for (int des : adj.get(src)) {
			if (visited[des] == false) {
				if (dfs(adj, des, visited, trace))
					return true;
			} else {
				if (trace.contains(des))
					return true;
			}
		}
		trace.remove(src);
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
