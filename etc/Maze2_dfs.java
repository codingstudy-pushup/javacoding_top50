package zTest;

import java.util.*;



public class Maze2_dfs {

	public static void main(String[] args) {
		
		int[][] maze= {
				{0,0,1,0,0},
				{0,0,0,0,0},
				{0,0,0,1,0},
				{1,1,0,1,1},
				{0,0,0,0,0}
		};
		int [] start= {0,4};
		int[] dest = {4,4};
		Maze2_dfs a= new Maze2_dfs();
		System.out.println(a.shortestDistance(maze, start,dest ));
	}
	    int[][] dirs={{0,1}, {0,-1}, {-1,0}, {1,0}};
	    int m, n ;
	    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
	    	m = maze.length;
	    	n = maze[0].length;
	        int[][] distance = new int[m][n];
	        for (int[] row: distance)
	            Arrays.fill(row, Integer.MAX_VALUE);
	        distance[start[0]][start[1]] = 0;
	        dfs(maze, start, distance);
	        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
	    }

	    public void dfs(int[][] maze, int[] start, int[][] distance) {
	      
	        for (int[] dir: dirs) {
	            int x = start[0] + dir[0];
	            int y = start[1] + dir[1];
	            int count = 0;
	            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
	                x += dir[0];
	                y += dir[1];
	                count++;
	            }
	            if (distance[start[0]][start[1]] + count < distance[x - dir[0]][y - dir[1]]) {
	            	
	              	System.out.println("Start$$$$$$$");
	            	  System.out.println(
	      	          "distance["+(start[0])+"]["+(start[1])+"] count "+count+" : "+(distance[start[0]][start[1]] + count )+
	      	          " distance["+(x - dir[0])+"]"+"["+(y - dir[1])+"] "+distance[x - dir[0]][y - dir[1]]
	      	         		);
	            	
	     
	            	
	                distance[x - dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
	                
	                
	                System.out.println(
	                "distance["+(x - dir[0])+"]"+"["+(y - dir[1])+"] :"
	                +" distance["+(start[0])+"]["+(start[1])+"] count= "+count+" : "+(distance[start[0]][start[1]] + count )
	         		);
	             			
	               	System.out.println("=============================================");
	                dfs(maze, new int[]{x - dir[0],y - dir[1]}, distance);
	            }
	        }
	    }
	}
	
	

