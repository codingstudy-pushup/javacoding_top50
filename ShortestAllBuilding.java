package p1;
import java.util.*;
import java.util.Queue;



public class ShortestAllBuilding {

	public static void main(String[] args) {
		int[][] grid= {{1,0,2,0,1},
					   {0,0,0,0,0},
				       {0,0,1,0,0}};
//		int[][] grid = {{5,-1,4},
//		          {6,3,-1},
//		          {2,-1,1}};
		G051_ShortestAllBuilding a = new G051_ShortestAllBuilding();
		System.out.println(a.shortestDistance(grid));

	}
	final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public int shortestDistance(int[][] grid) {
	    int n = grid.length;
	    int m = grid[0].length;
	    int[][] dp = new int[n][m];
	    int[][] reach = new int[n][m];
	    int countBuilding = 0;
	    Queue<int[]> queue = new LinkedList<>();

	    // step 1
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            if (grid[i][j] == 1) {
	                queue.offer(new int[]{i, j});
	                bfs(queue, grid, dp, reach, n, m);
	                countBuilding++;
	                print(dp);
	            }
	        }
	    }

	    // step 2
	    int result = Integer.MAX_VALUE;
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < m; j++) {
	            // WARNING: DO NOT FORGET to check whether current point is 0 and whether current point can reach all buildings
	            if (grid[i][j] == 0 && reach[i][j] == countBuilding) {
	                result = Math.min(result, dp[i][j]);
	            }
	        }
	    }
	    return result == Integer.MAX_VALUE ? -1 : result;
	}
	
	void print(int[][] dp) {
		System.out.println("===================================dp==");
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length;j++) {
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("===================================dp==");
	}

	public void bfs(Queue<int[]> queue, int[][] grid, int[][] dp, int[][] reach, int n, int m) {
	    int level = 1;
	    // DO NOT USE hashset, since hashset cannot determine whether it contains an array (coordinate)
	    boolean[][] visited = new boolean[n][m];
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        System.out.println("size: "+size);
	        int[] quePeek = queue.peek();
	        System.out.println("peek: "+quePeek[0]+" "+quePeek[1]);
	        for (int i = 0; i < size; i++) {
	            int[] curPoint = queue.poll();
	            int x = curPoint[0];
	            int y = curPoint[1];
	            System.out.println("x: "+x+" y: "+y);
	            for (int j = 0; j < 4; j++) {
	                int dx = x + dir[j][0];
	                int dy = y + dir[j][1];
//	                System.out.println("before dx: "+dx+" dy: "+dy);
	                if (dx < 0 || dx > n - 1 || dy < 0 || dy > m - 1 || grid[dx][dy] != 0 || visited[dx][dy]) {
	                    continue;
	                }
	                System.out.println("after  dx: "+dx+" dy: "+dy);
	                queue.offer(new int[]{dx, dy});
	                visited[dx][dy] = true;
	                dp[dx][dy] += level;
	                reach[dx][dy] = grid[dx][dy];
	            }
	        }
	      
	        level++;
	        System.out.println("========level=========: "+level);
	    }
	}
