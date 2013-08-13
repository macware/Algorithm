package Math;
import java.util.*;

public class AddBinary {

	public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (a.length() < b.length()){
            String tmp = b;
            b = a;
            a = tmp;
        }
        
        char[] res = new char[a.length()+1];
        int carry = 0;
        
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0){
            int c = carry + a.charAt(i) - '0';
            if (j >= 0)
                c += b.charAt(j) - '0';
            
            res[i+1] = (char)('0'+c%2);
            carry = c/2;
            i--;
            
            if (j >= 0)
                j--;
        }
        
        res[0] = (char)('0' + carry);
        if (res[0] != '0')
            return new String(res,0,res.length);
            
        return new String(res,1,res.length - 1);
    }
	
	public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] res = new int[digits.length+1];
        int sum, carry = 1;
        
        for (int i = digits.length - 1; i >= 0; i--){
            sum = digits[i] + carry;
            carry = sum / 10;
            res[i+1] = sum % 10;            
        }
        
        res[0] = carry;
        int start = 0;
        if (res[0] == 0)
            start = 1;
            
        return Arrays.copyOfRange(res,start,res.length);
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddBinary ab = new AddBinary();
		ab.plusOne(new int[]{9});
	}

}
