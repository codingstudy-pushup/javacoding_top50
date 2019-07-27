package zTest;

public class Maze1_dfs {

		public static void main(String[] args) {
				
				int[][] maze= {
						{0,0,1,0,0},
						{0,0,0,0,0},
						{0,0,0,1,0},
						{1,1,0,1,1},
						{0,0,0,0,0}
				};
				int[] start= {0,4};
//				int[] dest = {4,4};
			    int[] dest = {3,2};
			Maze1_dfs a= new Maze1_dfs();
			System.out.println(a.hasPath(maze, start,dest ));
		}
	
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	int m, n;

	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		m = maze.length;
		n = maze[0].length;
		boolean[][] visited = new boolean[m][n];
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
		return dfs(maze, start, destination, visited);
	}

	public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
		System.out.println(
				"#########start x: " + start[0] + " y: " + start[1] + " visited " + visited[start[0]][start[1]]);
		if (start[0] < 0 || start[0] >= m || start[1] < 0 || start[1] >= n || visited[start[0]][start[1]])
			return false;

		visited[start[0]][start[1]] = true;
		print(visited);
		if (start[0] == destination[0] && start[1] == destination[1])
			return true;

		for (int[] dir : dirs) {
			int x = start[0];
			int y = start[1];
			System.out.println("11 x: " + x + " y: " + y);
			while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
				x += dir[0];
				y += dir[1];
				System.out.println("22 x: " + x + " y: " + y + " " + dir[0] + " " + dir[1]);

			}
			x -= dir[0];
			y -= dir[1];
			System.out.println("new int x: " + x + " y: " + y);
			if (dfs(maze, new int[] { x, y }, destination, visited)) {
				return true;
			}
			System.out.println();
		}

		return false;
	}

	private void print(boolean[][] visited) {
		if (visited == null || visited.length == 0)
			return;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(visited[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
}
