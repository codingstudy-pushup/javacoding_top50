package Problems;


package top50;



public class MaxOfIsland {

	    public static void main(String[] args) {
		
	    	
	    	int[][] grid = 
	    		            {
	    		            {1,1,0,1,1},
	    					{0,1,1,0,0},
	    					{0,0,0,0,0},
	    					{1,1,0,1,1},
	    					{1,0,1,1,1},
	    					{1,0,1,1,1}};
	    	MaxOfIsland a = new MaxOfIsland();
	    	System.out.println(a.maxAreaOfIsland(grid));
		}
	    
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	int m ,n;
	public int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		m = grid.length;
		n = grid[0].length;
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					int area = dfs(grid, i, j, 0);
					System.out.println("area: " + area);
					max = Math.max(area, max);
				}
			}
		}
		return max;
	}

	int dfs(int[][] grid, int x, int y, int area) {
		if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
			return area;
		}
		grid[x][y] = 0;
		area++;
		for(int[] dir: dirs) {
			area= dfs(grid, x+dir[0], y+dir[1], area);
		}

		return area;
	}

}













public class MaxOfIsland {

	    public static void main(String[] args) {
		
	    	
	    	int[][] grid = 
	    		            {{1,1,0,1,1},
	    					{0,1,1,0,0},
	    					{0,0,0,0,0},
	    					{1,1,0,1,1},
	    					{1,0,1,1,1},
	    					{1,0,1,1,1}};
	    	MaxOfIsland a = new MaxOfIsland();
	    	System.out.println(a.maxAreaOfIsland(grid));
		}
	    
	    
	public int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					int area = dfs(grid, i, j, m, n, 0);
					System.out.println("area: " + area);
					max = Math.max(area, max);
				}
			}
		}
		return max;
	}

	int dfs(int[][] grid, int i, int j, int m, int n, int area) {
		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
			return area;
		}
		grid[i][j] = 0;
		area++;
		area = dfs(grid, i + 1, j, m, n, area);
		area = dfs(grid, i, j + 1, m, n, area);
		area = dfs(grid, i - 1, j, m, n, area);
		area = dfs(grid, i, j - 1, m, n, area);
		return area;
	}

}
