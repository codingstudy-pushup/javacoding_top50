package Searching;

import java.util.*;

public class MergeInterval {

	public static void main(String[] args) {
		MergeInterval a = new MergeInterval();
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] res = a.solve(intervals);
		for (int[] arr : res)
			System.out.println(arr[0] + ":" + arr[1]);

	}

	public int[][] solve(int[][] intervals) {
		List<int[]> res = new ArrayList<>();

		if (intervals == null || intervals.length == 0) 
			return res.toArray(new int[][] {});

		Arrays.sort(intervals, (a, b)-> a[0]-b[0]);

		int start = intervals[0][0];
		int end = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][1] < end) {
				continue;
			}

			if (intervals[i][0] > end) {
				res.add(new int[] { start, end });
				start = intervals[i][0];
			}

			end = intervals[i][1];
		}
		res.add(new int[] { start, end });
		return res.toArray(new int[][] {});
	}

}
