package top50;

import java.util.ArrayList;
import java.util.List;



public class T05_InsertInterval {

	public static void main(String[] args) {
		T05_InsertInterval a = new T05_InsertInterval();
	
		List<Interval> list = new ArrayList<>();
		Interval i1 = new Interval(1,3);
		Interval i2 = new Interval(6,9);
		Interval newIn = new Interval(2,5);

		list.add(i1);
		list.add(i2);
	
	
		print(list);
		List<Interval> list2 = a.insert(list, newIn);
		System.out.println("===============");
		print(list2);
	}
	
	  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	        List<Interval> res = new ArrayList<>();
	        int index = 0;
	        for(int i = 0; i < intervals.size(); i++) {
	        	
	            if( newInterval.end < intervals.get(i).start ) {
	            	res.add(intervals.get(i));
        
		        } else if(intervals.get(i).end < newInterval.start) {
		            res.add(intervals.get(i));
		            index++;
		        } else {
		            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
		            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
		        }
	        	
	        }
	        res.add(index, newInterval);
	        return res;
	    }
	  
	  public static void print(List<Interval> intervals) {
			if(intervals !=null && !intervals.isEmpty()) {
				for(Interval interval : intervals) {
					if(interval !=null) {
						System.out.println(interval.start+" "+interval.end);
					}
				}
			}
	  }
}
