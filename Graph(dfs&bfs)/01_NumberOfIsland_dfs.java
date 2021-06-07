package graph;

public class NumberOfIsland_dfs {

	public static void main(String[] args) {
		char[][] grid = { 
				{ '1', '1', '0', '0', '0' }, 
				{ '1', '1', '0', '0', '0' }, 
				{ '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '1', '1' } };

//		char[][] grid = {
//				{ '1', '0' },
//				{ '1', '1'}};

		NumberOfIsland_dfs a = new NumberOfIsland_dfs();
		System.out.println(a.solve(grid));
	}

	int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	int m, n;
	int dfsCount = 0;

	public int solve(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		m = grid.length;
		n = grid[0].length;
		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					System.out.println("======================i " + i + " j " + j);
					count++;
					dfs(grid, i, j);
				}
			}
		}
		print(grid);
		return count;
	}

	public void dfs(char[][] grid, int i, int j) {
		dfsCount++;
		System.out.println("===i " + i + " j " + j + " dfsCount " + dfsCount);
		print(grid);
		// 1.error
//		if(i<0 || j<0 || i >= m || j >= n || grid[i][j]!='1') 
//			return;
		if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == '1') {

			grid[i][j] = 'X';
			System.out.println("grid[" + i + "][" + j + "] " + grid[i][j]);
			for (int[] dir : dirs) {
				dfs(grid, i + dir[0], j + dir[1]);
			}
			System.out.println("====end====" + " dfsCount " + dfsCount);
		}

//		dfs(grid, i-1,j);
//		dfs(grid, i+1,j);
//		dfs(grid, i,j-1);
//		dfs(grid, i,j+1);
	}

	public void print(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
//			System.out.print("i "+i);
			for (int j = 0; j < grid[i].length; j++) {
//				System.out.println(grid[i]);
				System.out.print("[" + i + "][" + j + "]" + grid[i][j]);
//				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}

}
