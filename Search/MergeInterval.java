package Search;

import java.util.*;

public class MergeInterval {

	public Comparator<Interval> comp = new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2){
            return (i1.start-i2.start);
        }
    };
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (intervals == null || intervals.size() < 2)
            return intervals;
            
        Collections.sort(intervals,comp);
        ArrayList<Interval> res = new ArrayList<Interval>();
        Interval tag, cur;
        tag = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++){
            cur = intervals.get(i);
            if (cur.start >= tag.start && cur.start <= tag.end){
                tag.end = Math.max(cur.end, tag.end);
            } else {
                res.add(tag);
                tag = cur;
            }
        }
        
        res.add(tag);
        
        return res;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
