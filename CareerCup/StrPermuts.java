package CareerCup;

import java.util.*;

public class StrPermuts {

	public static ArrayList<StringBuilder> getPermuts(String str){
		ArrayList<StringBuilder> permuts = new ArrayList<StringBuilder>();
		
		
		StringBuilder oldStr, newStr;
		int curSize = 0;
		int i,j,k;
		char c;
		
		newStr = new StringBuilder();
		newStr.append(str.charAt(0));
		permuts.add(newStr);
		
		for (i = 1; i < str.length(); i++){
			c = str.charAt(i);
			curSize = permuts.size();
			for (j = 0; j < curSize; j++){
				oldStr = permuts.get(j);
				for (k = 0; k < oldStr.length(); k++){
					newStr = new StringBuilder(oldStr.insert(k, c).toString());
					permuts.add(newStr);
					oldStr.deleteCharAt(k);
				}
				
				oldStr.insert(k, c);
			}
		}
	
		return permuts;
	}

	public static void printPermuts(ArrayList<StringBuilder> permuts){
		System.out.println("Total permuts: "+permuts.size());
		for(StringBuilder sb: permuts){
			System.out.println(sb.toString());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<StringBuilder> permuts = getPermuts("str");
		printPermuts(permuts);

	}

}
