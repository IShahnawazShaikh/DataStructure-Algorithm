package graph;

/***
 * 
 *  Time Complexity: O(V+E) +O(V) -> dfs traversal + traversing on the astronaut list (eg: mList)
 *  Space Complexity: O(V+E)+ O(V)+ O(V) -> Adjacency List, Visited array, list of astronauts belong to different countries
 *  Use Case: https://www.hackerrank.com/challenges/journey-to-the-moon/problem
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class JourneyToTheMoon {
	public static int cnt = 0;

	public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
		// Write your code here

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int i, m = astronaut.size();
		for (i = 0; i < n; i++)
			adj.add(new ArrayList<Integer>());

		for (i = 0; i < m; i++) {
			int src = astronaut.get(i).get(0);
			int des = astronaut.get(i).get(1);
			adj.get(src).add(des);
			adj.get(des).add(src);
		}

		boolean[] visited = new boolean[n];
		ArrayList<Integer> mList = new ArrayList<>();
		for (i = 0; i < n; i++) {
			if (visited[i] == false) {
				cnt = 0;
				dfs(adj, i, visited);
				mList.add(cnt);

			}

		}
		int prev = 0;
		long total = (n * (n - 1)) / 2;
		for (i = 0; i < mList.size(); i++) {
			int temp = (mList.get(i) * (mList.get(i) - 1)) / 2;
			total = total - temp;
		}

		return (int) (total);

	}

	public static void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited) {

		cnt++;
		visited[src] = true;
		for (int des : adj.get(src)) {
			if (visited[des] == false) {
				dfs(adj, des, visited);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
