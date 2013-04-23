package Search;

import java.util.*;

public class Lon2CharSubseq {

	public String getLongestSubseq(String str) {
		if (str == null || str.length() == 0)
			return "";

		int newLen, maxLen, start, i;
		// Record consecutive counts of a character
		HashMap<Character, Integer> charCounts = new HashMap<Character, Integer>();

		charCounts.put(str.charAt(0), 1);
		newLen = maxLen = 1;
		start = 0;

		for (i = 1; i < str.length(); i++) {
			Character c = str.charAt(i);
			if (c == str.charAt(i - 1)) {
				// Record consecutive counts
				int count = charCounts.get(c);
				count++;
				charCounts.put(c, count);
			} else {
				// We have to evict one
				if (!charCounts.containsKey(c) && charCounts.size() >= 2) {
					if (newLen > maxLen){
						maxLen = newLen;
						start = i - maxLen;
					}
					
					// Set the newLen to the counts of previous character
					newLen = charCounts.get(str.charAt(i - 1));
					
					// Remove the other one
					Character old = null;
					for (Character ch : charCounts.keySet()) {
						if (ch != str.charAt(i - 1)) {
							old = ch;
							break;
						}
					}
					charCounts.remove(old);	
				}
				
				// Reset the non-consecutive count to 1
				charCounts.put(c, 1);
			}

			// increment newLen
			newLen++;
		}

		// After the main loop
		if (newLen > maxLen){
			maxLen = newLen;
			start = i - maxLen;
		}
		
		return str.substring(start,start + maxLen);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lon2CharSubseq lon2 = new Lon2CharSubseq();
		System.out.println(lon2.getLongestSubseq("a"));
	}

}
