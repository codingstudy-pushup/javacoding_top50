package p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G119_KClosest {

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		List<Integer> intList = new ArrayList<>();
		List<Integer> intList2 = new ArrayList<>();
		intList.add(1); intList.add(3);
		intList2.add(-2); intList2.add(2);
		list.add(intList);
		list.add(intList2);
		
		System.out.println(kClosest(list, 1));
	}
	
	public static int[][] convert(List<List<Integer>> list) {
		int[][] array = new int[list.size()][];
		for (int i = 0; i < array.length; i++) {
			array[i] = new int[list.get(i).size()];
		}
		for(int i=0; i<list.size(); i++){
			for (int j = 0; j < list.get(i).size(); j++) {
				array[i][j] = list.get(i).get(j);
			}
		}
		return array;
	}
	
	public static int[][] kClosest(List<List<Integer>> list, int K) {
		
		int[][] points = convert(list);
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
    }

    public static int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
