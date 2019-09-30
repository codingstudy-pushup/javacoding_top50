package zTest;

public class NumberOfIsland_dfs {
	public static void main(String[] args) {
		char[][] grid= {
						{'1','1','0','0','0'},
						{'1','1','0','0','0'},
						{'0','0','1','0','0'},
						{'0','0','0','1','1'}
					   };
		
		NumberOfIsland_dfs a = new NumberOfIsland_dfs();
		System.out.println(a.numsIslands(grid));
	}
	int[][] dirs= {{0,1},{0,-1},{1,0},{-1,0}};
	int m, n;
	int numsIslands(char[][] grid) {
		if(grid == null|| grid.length==0 || grid[0].length==0) return 0;
		m = grid.length;
		n = grid[0].length;
		int count =0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j]=='1') {
					count++;
					System.out.println("i: "+i+" y: "+j);
					merge(grid,i,j);
				}
			}
		}
		return count;
	}
	void merge(char[][] grid, int i, int j) {
		System.out.println("==merge=====i: "+i+" y: "+j);
		if(i<0 || i>=m || j<0||j>=n || grid[i][j]!='1') return ;
		grid[i][j]='X';
//		for(int[] dir: dirs) {
//			merge(grid, i+dir[0], j+dir[1]);
//		}
		
		merge(grid, i-1, j);
		merge(grid, i+1, j);
		merge(grid, i, j+1);
		merge(grid, i, j-1);
	}
}
