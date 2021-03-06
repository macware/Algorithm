package String;

import java.util.HashMap;

public class LonNoRepSubstr {

	/*
	 * Longest substring without repeating characters If possible, use an
	 * example to test your thought and find some blind mistakes Think carefully
	 * when you decide to start a new round, reset or backtrack? Did you really
	 * finish all the work after the main loop. (Counting problem needs final
	 * check) How to slickly detect a old record. (Record a valid pos/time,
	 * indicating a valid start point)
	 */
	public static int lengthOfLongestSubstring(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		HashMap<Character, Integer> chars = new HashMap<Character, Integer>();

		int i,newLen, max;
		int validPos = 0;
		max = newLen = 0;

		for (i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (chars.containsKey(c) && chars.get(c) >= validPos) {
				if (newLen > max){
					max = newLen;
					System.out.println("Starting at "+(i-newLen));
				}

				validPos = chars.get(c) + 1;
				newLen = i - validPos;
			}

			chars.put(c, i);
			newLen++;
		}

		if (newLen > max)
			max = newLen;

		return max;
	}
	
	public int lengthOfLongestSubstring2(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, maxLen,newLen;
        maxLen = newLen = 0;
        
        HashMap<Character,Integer> records = new HashMap<Character,Integer>();
        int validStart = 0;
        
        for(i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (records.containsKey(c) && records.get(c) >= validStart){
                // repeated character
                newLen = i - validStart;
                validStart = records.get(c) + 1;
                maxLen = Math.max(maxLen,newLen);
            }
            records.put(c,i);
        }
        
        newLen = i - validStart;
        maxLen = Math.max(maxLen,newLen);
        
        return maxLen;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LonNoRepSubstr t = new LonNoRepSubstr();
		System.out.println(t.lengthOfLongestSubstring2(""));
	}

}
