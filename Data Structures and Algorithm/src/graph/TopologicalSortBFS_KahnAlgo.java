package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/***
 * 
 * @author Shahnawaz Shaikh
 * 
 *         Working:
 *         Topological sort 
 *         -> The linear ordering of nodes/vertices such that if there exists an edge between 2 nodes u,v then ‘u’ appears before ‘v’.
 *         -> Topological sort is not possible with cyclic graph, so Topological sort is also used to detect cycle in the graph.
 *         -> Topological Sort is not possible in Directed Graph
 *         
 *         Time Complexity: O(V+E) 
 *         Space Complexity: O(V) + O(V) -> Indegre Array, Sorted Array Use Case:
 *         
 *         https://practice.geeksforgeeks.org/problems/topological-sort/1
 *
 */
public class TopologicalSortBFS_KahnAlgo {

	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
		int[] indegree = new int[V];
		int i, n = adj.size();
		for (i = 0; i < n; i++) {
			for (int x : adj.get(i)) {
				indegree[x]++;
			}
		}
		int[] ans = new int[V];
		int cnt = bfs(adj, indegree, ans);

		if (cnt != V)
			return new int[] {};

		return ans;

	}

	static int bfs(ArrayList<ArrayList<Integer>> adj, int[] indegree, int[] ans) {

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				queue.add(i);
		}
		int cnt = 0;
		while (!queue.isEmpty()) {

			int src = queue.poll();

			ans[cnt++] = src;

			for (int des : adj.get(src)) {
				indegree[des]--;
				if (indegree[des] == 0)
					queue.add(des);
			}

		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
