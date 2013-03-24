import java.io.*;
import java.util.*;

public class qsort {

	public static ArrayList<Integer> data = new ArrayList<Integer>(10000);
	public static int comparisonCount = 0;

	public static int readData(String filePath) {
		try {
			BufferedReader bReader = new BufferedReader(
					new FileReader(filePath));
			String line;

			while ((line = bReader.readLine()) != null) {
				data.add(Integer.parseInt(line));
			}

			bReader.close();
			System.out.println("Read "+data.size()+" lines");

		} catch (Exception e) {
			System.out.println("Fail to read data !");
			e.printStackTrace();
			return -1;
		}

		return 0;
	}

	public static int choosePivot(int offset, int len, int type) {
		int pivot;

		switch (type) {
		
		//choose the first element
		case 0:
			pivot = offset;
			break;

		//choose the last element
		case 1:
			pivot = offset + len - 1;
			break;
			
		//choose the median
		case 2:
			if (len < 3){
				pivot = offset;
				break;
			}
			
			int mid = offset + len/2 - 1 + len % 2;
			int last = offset+len-1;
			
			if(data.get(mid) > data.get(offset)){
				if(data.get(last) > data.get(mid))
					pivot = mid;
				else if(data.get(last) > data.get(offset))
					pivot = last;
				else
					pivot = offset;
			} else {
				if(data.get(last) > data.get(offset))
					pivot = offset;
				else if(data.get(last) > data.get(mid))
					pivot = last;
				else
					pivot = mid;
			}			
			break;
						
		default:
			pivot = offset;

		}

		return pivot;
	}

	public static int partition(int offset, int len, int pivot){
		int i,j,tmp,pos;
		
		//swap the pivot
		tmp = data.get(offset);
		data.set(offset,data.get(pivot));		
		data.set(pivot, tmp);
		
		i = j = 1;
		while(j < len){
			if(data.get(offset+j) < data.get(offset)){
				//swap to the left side
				tmp = data.get(offset+i);
				data.set(offset+i,data.get(offset+j));
				data.set(offset+j, tmp);
				i++;
			}
			j++;
		}
		
		//reposition the pivot
		pos = offset+i-1;
		tmp = data.get(offset);
		data.set(offset, data.get(pos));
		data.set(pos,tmp);
		
		return pos;		
	}
	
	public static void quickSort(int offset, int len) {
		if (len <= 1)
			return;

		comparisonCount += (len - 1);
		
		int pivot = choosePivot(offset,len,2);
		int pivotPos = partition(offset,len,pivot);
		
		quickSort(offset,pivotPos-offset);
		quickSort(pivotPos+1,offset+len - (pivotPos+1));		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (readData("//media//Work//src//QuickSort.txt") < 0)
			return;

		quickSort(0,data.size());
		
		System.out.println("Total comparisons: "+comparisonCount);
	}

}
