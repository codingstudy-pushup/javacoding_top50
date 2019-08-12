package zTest01;

import java.util.*;

public class ShortestAllBuildings {

	public static void main(String[] args) {
		int[][] grid = {
				{1,0,2,0,1},
				{0,0,0,0,0},
				{0,0,1,0,0},
		};
		ShortestAllBuildings a = new ShortestAllBuildings();
		System.out.println(a.shortestDist(grid));
	}

	int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	int m, n;

	public int shortestDist(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		int[][] dp = new int[m][n];
		int[][] reach = new int[m][n];
		int countBuilding = 0;
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					queue.offer(new int[] { i, j });
					bfs(queue, grid, dp, reach);
					countBuilding++;
				}
			}
		}

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0 && reach[i][j] == countBuilding) {
					result = Math.min(result, dp[i][j]);
				}
			}
		}
		return result == Integer.MAX_VALUE ? -1 : result;

	}

	public void bfs(Queue<int[]> queue, int[][] grid, int[][] dp, int[][] reach) {
		int level = 1;
		boolean[][] visited = new boolean[m][n];

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] point = queue.poll();
				int x = point[0];
				int y = point[1];
				for (int[] dir : dirs) {
					int dx = x + dir[0];
					int dy = y + dir[1];
					if (dx >= 0 && dx < m && dy >= 0 && dy < n && grid[dx][dy] == 0 && !visited[dx][dy]) {
						queue.offer(new int[] { dx, dy });
						visited[dx][dy] = true;
						dp[dx][dy] += level;
						reach[dx][dy]++;
					}

				}
			}
			level++;
		}
	}	
}
