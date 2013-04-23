package Search;

public class FindPivot {

	public int findPivot(int[] ints){
		if (ints == null || ints.length < 2)
			return -1;
		
		int leftMaxIdx,maxIdx;
		int i,j;
		leftMaxIdx = maxIdx = 0;
		i = 0;
		j = 1;
		
		while (j < ints.length){
			if (ints[j] > ints[maxIdx])
				maxIdx = j;
			
			if (ints[i] >= ints[leftMaxIdx] && ints[j] >= ints[i])
				j++;
			else{
				i = j + 1;
				j = i + 1;
				leftMaxIdx = maxIdx;
			}
		}
		
		if (i == ints.length || ints[i] < ints[leftMaxIdx])
			return -1;
		
		return ints[i];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindPivot fp = new FindPivot();
		int[] ints = new int[]{2,1,3,4,2,6,3,7,8,9};
		System.out.println(fp.findPivot(ints));

	}

}
