package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
 *         Use Case: https://www.codingninjas.com/codestudio/problems/1062670
 */
public class CycleDetectionBFSUndirected {

	public static String cycleDetection(int[][] edges, int n, int m) {
		ArrayList<Integer>[] adj = new ArrayList[n + 1];
		int i;
		for (i = 0; i <= n; i++)
			adj[i] = new ArrayList<Integer>();
		boolean[] visited = new boolean[n + 1];
		for (i = 0; i < m; i++) {
			int src = edges[i][0];
			int des = edges[i][1];
			adj[src].add(des);
			adj[des].add(src);
		}
		for (i = 1; i <= n; i++) {
			if (visited[i] == false) {
				if (bfs(adj, i, visited) == true)
					return "Yes";
			}
		}
		return "No";
	}

	public static boolean bfs(ArrayList<Integer>[] adj, int start, boolean[] visited) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(start, -1));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			visited[node.src] = true;
			for (int des : adj[node.src]) {
				if (visited[des] == false) {
					queue.add(new Node(des, node.src));
				} else {
					if (des != node.prev)
						return true;
				}
			}
		}
		return false;
	}

	static class Node {
		int src, prev;

		Node(int src, int prev) {
			this.src = src;
			this.prev = prev;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
