package Search;

public class CountAndSay {

	public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n < 1)
            return "";
            
        String res = "1";        
        StringBuilder tmp;
        char tag = 0;
        int i,j,count;
        
        for (i = 2; i <= n; i++){
            tmp = new StringBuilder();
            tag = res.charAt(0);
            count = 1;
            for (j = 1; j < res.length(); j++){
                if (res.charAt(j) != tag){
                    tmp.append(count);
                    tmp.append(tag);
                    tag = res.charAt(j);
                    count = 1;
                }else
                    count++;
            }
            
            tmp.append(count);
            tmp.append(tag);
            
            res = tmp.toString();
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
