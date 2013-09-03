package String;

public class IsPalidrome {

	public int convertChar(char c){	       
		// Below are the so-called alphanumeric characters
		
        if (c >= 'a' && c <= 'z')
            return c;
            
        if (c >= 'A' && c <= 'Z')
            return (int)(c - 'A' + 'a');
            
        if (c >= '0' && c <= '9')
            return c;
            
        return -1;
    }
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() < 2)
            return true;
            
        int i,j;
        i = 0;
        j = s.length() - 1;
        
        int left,right;
        left = right = 0;
        while (i < j){
            while (i < j){
                left = convertChar(s.charAt(i));
                if (left > 0)
                    break;
                i++;
            }
            
            while (i < j){
                right = convertChar(s.charAt(j));
                if (right > 0)
                    break;
                j--;
            }
           
            if (i >= j)
                break;
                
            if (left != right)
                return false;
            i++;
            j--;
        }
        
        return true;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
