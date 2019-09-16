package Top50_test;

import java.util.*;

//1
class Interval {
	int start;
	int end;

	Interval(int s, int e) {
		this.start = s;
		this.end = e;
	}
}

public class T04_MergeInterval {
	// 2
	public static void main(String[] args) {
		Interval in = new Interval(1, 3);
		Interval in3 = new Interval(2, 6);
		Interval in2 = new Interval(8, 10);
		Interval in4 = new Interval(15, 18);
		T04_MergeInterval a = new T04_MergeInterval();
		List<Interval> list = new ArrayList<>();
		list.add(in);
		list.add(in2);
		list.add(in3);
		list.add(in4);
		a.solve(list);
	}

	public List<Interval> solve(List<Interval> list) {
		List<Interval> result = new ArrayList<>();
		if (list == null || list.size() == 0)
			return result;
		print(list);

		Collections.sort(list, comp2);
		System.out.println("====after=====");
		print(list);

		// 4
		Interval in = list.get(0);

		return list;
	}

	Comparator<Interval> comp = new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start > o2.start) {
				return 1;
			} else if (o1.start < o2.start) {
				return -1;
			} else {
				return 0;
			}
		}
	};

	Comparator<Interval> comp2 = new Comparator<Interval>() {

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			return o1.start - o2.start;
		}

	};

	public void print(List<Interval> list) {
		if (list != null) {
			for (Interval in : list) {
				if (in != null) {
					System.out.println(in.start + " " + in.end);
				}
			}
		}
	}
}
