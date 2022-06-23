package graph;

/***
 * 
 * 
 * Time Complexity: O(NM)
 * Space Complexity: O(NM)
 * Use Case: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/number-of-distinct-island-official/ojquestion
 * 
 */

import java.util.HashSet;
import java.util.Set;

public class DFSNumberOfDistinctIsland {

	public static int numDistinctIslands(int[][] grid) {

		int i, j, n = grid.length, m = grid[0].length;
		boolean[][] visited = new boolean[n][m];
		Set<String> set = new HashSet<String>();
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {

				if (visited[i][j] == false && grid[i][j] == 1) {
					StringBuilder sb = new StringBuilder("C");
					StringBuilder path = dfs(grid, i, j, visited, sb, n, m);

					set.add(path.toString());
				}
			}
		}
		return set.size();
	}

	public static StringBuilder dfs(int[][] grid, int i, int j, boolean[][] visited, StringBuilder path, int n, int m) {

		visited[i][j] = true;

		if (i + 1 < n && grid[i + 1][j] == 1 && visited[i + 1][j] == false) {
			path.append("D");
			dfs(grid, i + 1, j, visited, path, n, m);
		}
		if (i - 1 >= 0 && grid[i - 1][j] == 1 && visited[i - 1][j] == false) {
			path.append("U");
			dfs(grid, i - 1, j, visited, path, n, m);
		}
		if (j + 1 < m && grid[i][j + 1] == 1 && visited[i][j + 1] == false) {
			path.append("R");
			dfs(grid, i, j + 1, visited, path, n, m);
		}
		if (j - 1 >= 0 && grid[i][j - 1] == 1 && visited[i][j - 1] == false) {
			path.append("L");
			dfs(grid, i, j - 1, visited, path, n, m);
		}
		return path;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
