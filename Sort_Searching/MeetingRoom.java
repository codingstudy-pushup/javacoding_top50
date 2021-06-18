package Searching;

import java.util.Arrays;

public class MeetingRoom {

	public static void main(String[] args) {

		MeetingRoom a = new MeetingRoom();
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 16, 20 } };
//		int[][] intervals = { { 7, 10 }, { 2, 4 } };
		
		System.out.println(a.solve(intervals));

	}

	public boolean solve(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return true;
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int end = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < end) {
				return false;
			}
			end = intervals[i][1];
		}
		return true;
	}
}
