package top50;

import java.util.*;

public class KClosest {

	public static void main(String[] args) {
		KClosest a = new KClosest();
		int[][] points = { { 1, 3 }, { -2, 2 } };
		System.out.println("=");
		a.print(points);
		int k = 1;
//		int[][] points = {{3,3},{5,-1},{-2,4}};
//		int k =2;
		System.out.println("===result==");
		int[][] result = a.solve(points, k);
		a.print(result);
	}

	//
	public int[][] solve(int[][] points, int k) {
//		Queue<int[]> queue = new PriorityQueue<>(points.length, Comp);
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] + a[1]) - (b[0] * b[0] + b[1] * b[1]));
		int[][] result = new int[k][2];
		int index = 0;

		for (int[] p : points) {
			queue.offer(p);
		}
		while (index < k) {
			result[index] = queue.poll();
			index++;
		}
		return result;

	}

	Comparator<int[]> Comp = new Comparator<int[]>() {

		@Override
		public int compare(int[] a, int[] b) {
			// TODO Auto-generated method stub
			return (a[0] * a[0] + a[1] + a[1]) - (b[0] * b[0] + b[1] * b[1]);
		}

	};

	/*참고
	 * Time: O(NlogN)
	 */
	public int[][] solve_2(int[][] points, int K) {
		Arrays.sort(points, (a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
		return Arrays.copyOfRange(points, 0, K);
	}

	public void print(int[][] result) {
		int m = result.length;
		int n = result[0].length;
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(" [" + i + "][" + j + "] " + result[i][j]);
			}
			System.out.println();
		}
	}
}
