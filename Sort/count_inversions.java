package Sort;

import java.util.ArrayList;
import java.io.*;

public class count_inversions {

	public static long count = 0;
	public static ArrayList<Integer> intArray = new ArrayList<Integer>(10000);
	
	public static int readArray(String pathStr){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(pathStr));
			String line;
			
			while((line = reader.readLine()) != null){
				intArray.add(Integer.parseInt(line));
			}
			
			reader.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
		return 0;
	}
	
	public static void merge(int start, int end, int[] tmp){
		if (end <= start)
			return;
		
		int center = (start + end)/2;
		merge(start, center, tmp);
		merge(center+1,end, tmp);
		
		// merge
		int tmpPos = start;
		int lpos = start, rpos = center + 1;
		
		while (lpos <= center && rpos <= end){
			if (intArray.get(lpos) > intArray.get(rpos)){
				count += (center - lpos + 1);
				tmp[tmpPos++] = intArray.get(rpos++);
			} else {
				tmp[tmpPos++] = intArray.get(lpos++);
			}
		}
		
		while (lpos <= center)
			tmp[tmpPos++] = intArray.get(lpos++);
		while (rpos <= end)
			tmp[tmpPos++] = intArray.get(rpos++);
		
		// copy back
		for (int i = start; i <= end; i++){
			intArray.set(i, tmp[i]);
		}
	
	}
	
	public static ArrayList<Integer> mergeCount(int offset, int n){
		
		ArrayList<Integer> resultArray = new ArrayList<Integer>(10);
		
		if(n == 1){
			resultArray.add(intArray.get(offset));
			return resultArray;
		}
		
		//split
		int leftOffset,leftLen,rightOffset,rightLen;
		leftOffset = offset;
		leftLen = n/2;
		rightOffset = offset + n/2;
		rightLen = n - n/2;
		
		ArrayList<Integer> leftResult = mergeCount(leftOffset,leftLen);
		ArrayList<Integer> rightResult = mergeCount(rightOffset,rightLen);
		
		//count
		int i,j;
		i = j = 0;
		
		//can not use while(1)
		while(true){
			if(leftResult.get(i) <= rightResult.get(j)){
				resultArray.add(leftResult.get(i));
				i++;
				if(i == leftResult.size()){
					//copy the rightResult to the resultArray and break the loop
					while(j != rightResult.size()){
						resultArray.add(rightResult.get(j));
						j++;
					}
					break;
				}
			} else {
				// leftResult.get(i) > rightResult.get(j)
				resultArray.add(rightResult.get(j));
				count += (leftResult.size() - i);
				j++;
				if(j == rightResult.size()){
					//copy the leftResult to the resultArray and break the loop
					while(i != leftResult.size()){
						resultArray.add(leftResult.get(i));
						i++;
					}
					break;
				}
			}
		}
		
		return resultArray;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(readArray("//media//Work//src//IntegerArray.txt") < 0){
			System.out.println("Error: Could not read intArray.txt");
		}
		int[] tmp = new int[intArray.size()];

		// test simple case
//		intArray.add(1);
//		intArray.add(3);
//		intArray.add(5);
//		intArray.add(2);
//		intArray.add(4);
//		intArray.add(6);
//		int[] tmp = new int[6];
		
		System.out.printf("Read IntegerArray.txt, lines: %d \n",intArray.size());
		//mergeCount(0,intArray.size());
		merge(0,intArray.size()-1,tmp);
		//2407905288
		System.out.println("The number of inversions is: "+count);
	}

}
