package graph;


/***
 *   
 *   Working: Used to traverse through all the nodes, In DFS start from any node and
 *            explore all the farthest possible node in each path/branch.
 *    
 *   Time Complexity:  O(V+E)
 *   Space Complexity: O(V)+ O(V) + O(V) -> visited list, mList list, Auxiliary space 
 *     note: Adjacency List is given already
 *     
 *   Use Case: https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
 * 
 * 
 */
import java.util.ArrayList;

public class DFS {

	public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

		ArrayList<Integer> mList = new ArrayList<Integer>();
		boolean[] visited = new boolean[V];
		dfs(adj, 0, mList, visited);
		return mList;

	}

	private static void dfs(ArrayList<ArrayList<Integer>> adj, int src, ArrayList<Integer> res, boolean[] visited) {

		visited[src] = true;
		res.add(src);

		for (int des : adj.get(src)) {

			if (visited[des] == false) {
				dfs(adj, des, res, visited);
			}
		}

	}

	public static void main(String[] args) {
       
		ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
		
		for(int i=0;i<3;i++) {
			
			adj.add(new ArrayList<Integer>());
			
		}
		
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(0);
		
		System.out.println(dfsOfGraph(3,adj));
		
	}

}
