package zTest;

import java.util.*;

public class NumberOfIsland_bfs {

	public static void main(String[] args) {
		char[][] grid= {
				{'1','1','0','0','1'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'},
				{'1','0','0','1','1'}
			   };
		NumberOfIsland_bfs a = new NumberOfIsland_bfs();
		System.out.println(a.solve(grid));
	}
	int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	int m, n;
	
	public int solve(char[][] grid) {
		if(grid==null || grid.length==0)
			return 0;
		m = grid.length;
		n = grid[0].length;
		int count=0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j]=='1') {
					count++;
					bfs(grid, i,j);
				}
			}
		}
		return count;
	}
	
	public void bfs(char[][] grid, int x, int y) {
		grid[x][y] ='0';
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
		while(!queue.isEmpty()) {
			//int size = queue.size();  //사이즈로 돌리는거 불필요함, 밑에 poll()에서 빼서 쓰면됨
			int[] p = queue.poll();
			//for( int i=0; i<size; i++) {//사이즈로 돌리는거 불필요
				for(int[] dir :dirs) {
					int dx = p[0]+dir[0];
					int dy = p[1]+dir[1];
					if(dx>=0&& dx<m && dy>=0 && dy<n && grid[dx][dy]=='1') {
						grid[dx][dy]='0';
						queue.offer(new int[] {dx, dy});
					}
				}
			//}
		}
		
	}
	
	
}
