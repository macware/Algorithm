package Search;

public class FindBadRevision {

	int findBadRevision(int x, int y){
	    if (x > y)
	        return -1;
	    
	    int mid = (x+y)/2;
	    if (mid >= 2 && mid <= 6){
	        int num = findBadRevision(x, mid-1);
	        if (num != -1)
	            return num;
	        return mid;
	    } else
	       return findBadRevision(mid+1, y);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindBadRevision fbr = new FindBadRevision();
		System.out.println(fbr.findBadRevision(2, 6));
	}

}
