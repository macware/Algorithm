package Search;

import java.util.*;

public class InsertInterval {

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (intervals == null || newInterval == null)
            return intervals;
            
        ArrayList<Interval> res = new ArrayList<Interval>();
        int i = 0;
        for (i = 0; i < intervals.size(); i++){
            Interval intv = intervals.get(i);
            
            if (newInterval.start >= intv.start && newInterval.start <= intv.end){
                newInterval.start = intv.start;
                newInterval.end = Math.max(newInterval.end, intv.end);
                continue;
            }
            
            if (newInterval.end >= intv.start && newInterval.end <= intv.end){
                newInterval.start = Math.min(newInterval.start, intv.start);
                newInterval.end = intv.end;
                continue;
            }
            
            if (newInterval.start <= intv.start && newInterval.end >= intv.end)
                continue;
                
            if (intv.start > newInterval.end)              
                break;
                
            res.add(intv);
        }
        
        res.add(newInterval);
        
        for (; i < intervals.size(); i++)
            res.add(intervals.get(i));
            
        return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
