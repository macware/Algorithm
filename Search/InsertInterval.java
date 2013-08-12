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
            if (intv.start > newInterval.end)          
                break;
            
            if (newInterval.start <= intv.end){
                newInterval.start = Math.min(newInterval.start, intv.start);
                newInterval.end = Math.max(newInterval.end, intv.end);
                continue;
            }
                
            res.add(intv);
        }
        
        res.add(newInterval);
        
        for (; i < intervals.size(); i++)
            res.add(intervals.get(i));
            
        return res;
    }
	
	public ArrayList<Interval> insert2(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0){
            res.add(newInterval);
            return res;
        }
        
        Interval tag, cur;
        tag = null;
        
        for (int i = 0; i < intervals.size(); i++){
            cur = intervals.get(i);
            if (newInterval != null){
                if (newInterval.start >= cur.start && newInterval.start <= cur.end){
                    cur.start = Math.min(newInterval.start, cur.start);
                    cur.end = Math.max(newInterval.end, cur.end);
                    newInterval = null;
                } else if (newInterval.start < cur.start){
                    cur = newInterval;
                    i--;
                    newInterval = null;
                }
            }
            
            if (tag != null  && cur.start >= tag.start && cur.start <= tag.end){
                tag.start = Math.min(tag.start, cur.start);
                tag.end = Math.max(tag.end, cur.end);
            } else{
                if (tag != null)
                    res.add(tag);
                tag = cur;
            }
        }
        
        res.add(tag);
        if (newInterval != null)
            res.add(newInterval);
        
        return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
