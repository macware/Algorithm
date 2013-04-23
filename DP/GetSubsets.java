package DP;
import java.util.*;
class GetSubsets {

	public static ArrayList<ArrayList<Integer>> getSubsets(int n){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>()); // empty set
		
		ArrayList<ArrayList<Integer>> newSubsets;
		ArrayList<Integer> newSubset;
		for (int i = 0; i < n; i++){
			newSubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : result){
				newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(i);
				newSubsets.add(newSubset);
			}
			
			result.addAll(newSubsets);		
		}
		
		return result;
	}
	
	public static void printSubsets(ArrayList<ArrayList<Integer>> result){
		for (ArrayList<Integer> subset: result){
			if (subset.size() == 0)
				System.out.println("Empty set");
			else{
				System.out.println(subset);
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result = getSubsets(3);
		printSubsets(result);

	}

}
