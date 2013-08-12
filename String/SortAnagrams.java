package String;
import java.util.*;

// Chapter 11.2, without testing
public class SortAnagrams {

	public String sortChars(String str){
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	public boolean compareStrs(String str1, String str2){
		return sortChars(str1).equals(sortChars(str2));
	}
	
	public void sort(String[] strArr){
		HashMap<String,ArrayList<String>> strMap = new HashMap<String,ArrayList<String>>();
		String str;
		ArrayList<String> list;
		for (int i = 0; i < strArr.length; i++){
			str = sortChars(strArr[i]);
			if (!strMap.containsKey(str)){
				list = new ArrayList<String>();
				list.add(strArr[i]);
				strMap.put(str, list);
			} else {
				list = strMap.get(str);
				list.add(strArr[i]);
			}
		}
		
		int i = 0;
		for(ArrayList<String> strList: strMap.values()){
			for(String s: strList){
				strArr[i++] = s;
			}
		}
	}
	
	/**
	 * second 
	 */
	public String sortStr(String str){
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
    
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
            
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++){
            String str = sortStr(strs[i]);
            ArrayList<String> list = map.get(str);
            if (list == null){
                list = new  ArrayList<String>();
                map.put(str,list);
            }
            list.add(strs[i]);
        }
        
        ArrayList<String> res = new ArrayList<String>();
        for (ArrayList<String> item: map.values()){
            if (item.size() > 1)
                res.addAll(item);
        }
            
        return res;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
