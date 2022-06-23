package graph;

/***
 *   
 *   Working: Used to traverse through all the nodes, In BFS start from any node and
 *            we add all the adjacent node for particular node.
 *    
 *   Time Complexity:  O(V+E)
 *   Space Complexity: O(V)+ O(V) + O(V)  -> visited list, answer list, queue data structure
 *     note: Adjacency List is given already
 *     
 *   Use Case: https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
 * 
 * 
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[V];
		ArrayList<Integer> list = new ArrayList<>();

		queue.offer(0);
        visited[0]=true;
		while (queue.isEmpty() == false) {
			int src = queue.poll();

			list.add(src);
			for (int des : adj.get(src)) {
				if (visited[des] == false) {
					visited[des] = true;
					queue.offer(des);
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		
		/***
		 * 
		 * We can also create adjacency list like
		 *    ArrayList<ArrayList<Integer>>[] adj=new ArrayList[3];
		 *    		for (int i = 0; i < 3; i++) {
		 *	             adj.add(new ArrayList<Integer>());
		 *           }
		 *    
		 * 
		 * 
		 */
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {

			adj.add(new ArrayList<Integer>());
		}
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(0);

		System.out.println(bfsOfGraph(3, adj));

	}

}
