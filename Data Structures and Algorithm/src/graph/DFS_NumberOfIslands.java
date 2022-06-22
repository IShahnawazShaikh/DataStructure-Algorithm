package graph;

/***
 *   
 *   Working: Used to traverse through all the nodes, In BFS start from any node and
 *            we add all the adjacent node for particular node.
 *    
 *   Time Complexity:  O(number of cells visited)
 *   Space Complexity: O(NM)  -> visited 2D array
 *     
 *   Use Case: https://leetcode.com/problems/number-of-islands/
 */

public class DFS_NumberOfIslands {
	public int numIslands(char[][] grid) {

		int i, j, n = grid.length, m = grid[0].length;
		boolean[][] visited = new boolean[n][m];

		int[] row = { 1, -1, 0, 0 };
		int[] col = { 0, 0, 1, -1 };
		int cnt = 0;
		for (i = 0; i < n; i++) {

			for (j = 0; j < m; j++) {

				if (grid[i][j] == '1') {

					if (visited[i][j] == false) {
						cnt += 1;
						dfs(grid, i, j, visited, row, col);
					}
				}

			}

		}
		return cnt;
	}

	private void dfs(char[][] grid, int i, int j, boolean[][] visited, int row[], int[] col) {

		if (isValid(i, j, grid.length, grid[0].length) == false || visited[i][j] == true || grid[i][j] != '1')
			return;

		visited[i][j] = true;

		for (int p = 0; p < 4; p++) {
			int desR = row[p] + i;
			int desC = col[p] + j;
			dfs(grid, desR, desC, visited, row, col);
		}

	}

	private boolean isValid(int row, int col, int n, int m) {
		return row >= n || col >= m || row < 0 || col < 0 ? false : true;
	}

	public static void main(String... x) {

	}

}
