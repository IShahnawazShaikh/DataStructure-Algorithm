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
 *   Use Case: https://www.codingninjas.com/codestudio/problems/1062670
 * 
 */
import java.util.ArrayList;

public class CycleDetectionDFSUndirected {

	public static String cycleDetection(int[][] edges, int n, int m) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int i;
		for (i = 0; i <= n; i++)
			adj.add(new ArrayList<Integer>());
		for (i = 0; i < m; i++) {
			int src = edges[i][0];
			int des = edges[i][1];
			adj.get(src).add(des);
			adj.get(des).add(src);
		}
		boolean[] visited = new boolean[n + 1];
		for (i = 1; i <= n; i++) {
			if (visited[i] == false) {
				boolean check = dfs(adj, -1, i, visited);
				if (check == true)
					return "Yes";
			}
		}
		return "No";
	}

	public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int prev, int src, boolean[] visited) {
		visited[src] = true;
		for (int des : adj.get(src)) {
			if (visited[des] == false) {
				if (dfs(adj, src, des, visited))
					return true;
			} else {
				if (des != prev)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
