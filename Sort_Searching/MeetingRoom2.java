package Searching;

import java.util.*;
import java.util.Comparator;

public class MeetingRoom2 {

	public static void main(String[] args) {

		MeetingRoom2 a = new MeetingRoom2();
		int[][] intervals = { { 5, 10 }, { 16, 20 }, { 0, 30 } };
//		int[][] intervals = { { 7, 10 }, { 2, 4 } };
		System.out.println(a.solve(intervals));
	}
	
	public int solve(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        Queue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        for(int[] arr:intervals){
            if(pq.isEmpty()) pq.add(arr);
            else{
                if(pq.peek()[1]<=arr[0]){
                    pq.poll();
                }
                pq.offer(arr);
            }
        }
        return pq.size();
    }
}
