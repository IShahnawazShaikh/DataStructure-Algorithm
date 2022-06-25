package graph;

/***
 * @author Shahnawaz Shaikh
 *
 **         Working: Used to detect cycle in a graph or not.
 * 
 *         Time Complexity: O(V+E)
 * 
 *         Space Complexity: O(V+E)+ O(V) + O(V) -> adjacency List, visited
 *         list, Queue space note: Adjacency List is given already
 * 
 *         Use Case:  https://www.codingninjas.com/codestudio/problems/1062626
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionBFSDirected {
	public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int i, m = edges.size();
		for (i = 0; i <= n; i++)
			adj.add(new ArrayList<Integer>());
		for (i = 0; i < m; i++) {
			adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
		}

		boolean[] visited = new boolean[n + 1];
		for (i = 1; i <= n; i++) {
			if (visited[i] == false) {
				if (bfs(adj, i, visited))
					return true;
			}
		}
		return false;

	}

	public static boolean bfs(ArrayList<ArrayList<Integer>> adj, int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		HashSet<Integer> stackTrace = new HashSet<>();
		queue.add(start);
		stackTrace.add(start);
		while (!queue.isEmpty()) {
			int src = queue.poll();
			visited[src] = true;
			for (int des : adj.get(src)) {
				if (visited[des] == false) {
					queue.add(des);
					stackTrace.add(des);
				} else {
					if (stackTrace.contains(des))
						return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
