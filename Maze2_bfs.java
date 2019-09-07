package zTest;



import java.util.*;

public class Maze2_bfs {
	
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
		Maze2_bfs a= new Maze2_bfs();
		System.out.println(a.shortestDistance(maze, start,dest ));
	}

	int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	int m, n;
	
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {

		m = maze.length;
		n = maze[0].length;
	   
	    int[][] distance=new int[m][n];
	
	    for(int[] a:distance){
	        Arrays.fill(a,-1);
	    }
	   
	    distance[start[0]][start[1]]=0;
	    Queue<int[]> q=new LinkedList<>();
	    q.add(start);
	    while(!q.isEmpty()){
	        int[] c=q.poll();
	        for(int[] dir:dirs){
	            int count=distance[c[0]][c[1]];
	            int x=c[0];
	            int y=c[1];
	            while(x+dir[0]>=0&&x+dir[0]<maze.length&&y+dir[1]>=0&&y+dir[1]<maze[0].length&&maze[x+dir[0]][y+dir[1]]!=1){
	                x+=dir[0];
	                y+=dir[1];
	                count++;
	            }
	          
	            if(distance[x][y]==-1||distance[x][y]>count){
	                q.add(new int[]{x,y});
	                distance[x][y]=count;
	            }
	        }
	    }
	    return distance[destination[0]][destination[1]];
			}
}

