package Searching;

import java.util.*;

public class MergeInterval {

	public static void main(String[] args) {
		MergeInterval a = new MergeInterval();
		int[][] intervals = { 
				{ 1, 4 }, 
				{ 8, 10 }, 
				{ 2, 6 }, 
				{ 15, 18 } 
				};
		int[][] res = a.solve(intervals);
		for (int[] arr : res) {
			System.out.println("result");
			System.out.println(arr[0] + ":" + arr[1]);
		}

	}
	
	public int[][] solve(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals.length == 0 || intervals == null) 
        	return res.toArray(new int[0][]);
        
        //1 ds
//        print(intervals);
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);//asc
//        System.out.println("==after=");
//        print(intervals);
        //2 for while
        
        int start =  intervals[0][0];
        int end = intervals[0][1];
        
//        for(int[] i : intervals) {
//        	if(end >= i[0]) {
//        	//4 >= 2
//        		end = Math.max(end, i[1]);//6
//        	}else {
//        		res.add(new int[] {start, end});
//        		start= i[0];
//        		end = i[1];
//        	}
//        }
        
        for(int i=1; i<intervals.length; i++) {
        	if(end >= intervals[i][0]) {
        	//4 >= 2
        		end = Math.max(end, intervals[i][1]);//6
        	}else {
        		res.add(new int[] {start, end});
        		start= intervals[i][0];
        		end = intervals[i][1];
        	}
        }
        
        
        res.add(new int[] {start, end});
//		return res.toArray(new int[0][]); 
		return res.toArray(new int[res.size()][]); 
    }


	private void print(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
