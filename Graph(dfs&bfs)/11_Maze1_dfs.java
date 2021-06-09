package graph;

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
		int[] dest = {4,4};
//		int[] dest = {3,2};
		
	Maze1_dfs a= new Maze1_dfs();
	System.out.println(a.hasPath(maze, start,dest ));
}
	int[][] dirs= {{-1,0},{1,0},{0,-1},{0,1}};
	int m, n;
	public boolean hasPath(int[][] maze, int[] start, int [] dest) {
		if(maze==null|| maze.length==0)
			return false;
		m = maze.length;//5
		n = maze[0].length;//5
		boolean[][] visited = new boolean[m][n];
		return dfs(maze, start, dest, visited);
	}
	
		
	public boolean dfs(int[][] maze, int[] start, int[] dest, boolean[][] visited) {
		System.out.println("start: "+start[0]+"  "+start[1]);
		if (start[0] < 0 || start[0] >= m || start[1] < 0 || start[1] >= n || visited[start[0]][start[1]])
			return false;
		
		visited[start[0]][start[1]]=true;
		if(start[0]==dest[0] && start[1]==dest[1]) return true;
		print(visited);
		//2
		for(int[] dir : dirs) {
			int x = start[0];
			int y = start[1];
			while(x >=0 && x<m && y>=0 && y<n && maze[x][y]==0) {
				x += dir[0];
				y += dir[1];
				System.out.println("x: "+x+" y: "+y);
			}
			x-= dir[0];
			y-= dir[1];
			if(dfs(maze, new int[] {x,y}, dest, visited)) {
				return true;
			}
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
