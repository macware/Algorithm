package String;

public class RegExprMatch {

	/*
	 * Regular expression matching. Don't be rush to write codes. Think the
	 * solution in high level throughly and make it as clear,simple as possible.
	 * Especially for recursion or DP problems, think how the problem evolves as
	 * the input increases by one. Char manipulation using string is really
	 * buggy. Check 0 length before you visit and remember that substring is
	 * inclusive.
	 */
	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (p.equals("") && s.equals(""))
			return true;

		if (p.length() > 1) {
			if (p.charAt(1) != '*') {
				if (s.length() == 0)
					return false;

				if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
					return isMatch(s.substring(1), p.substring(1));
				}
			} else {
				int i = 0;
				for (i = 0; i < s.length(); i++) {
					if (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.') {
						if (isMatch(s.substring(i), p.substring(2)))
							return true;
					} else
						break;
				}

				// make sure we include the case s.substring(s.length());
				return isMatch(s.substring(i), p.substring(2));
			}
		} else {
			if (s.length() == 0 || p.length() == 0)
				return false;

			if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
				return isMatch(s.substring(1), p.substring(1));
		}

		return false;
	}

	public boolean isMatch2(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (p.length() == 0)
            return (s.length() == 0);
            
        // the next char is not '*'
        if (p.length() == 1 || p.charAt(1) != '*'){
            if (s.length() != 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'))
                return isMatch(s.substring(1),p.substring(1));
            else
                return false;
        }
        
        // the next char is '*'
        int i;
        for (i = 0; i < s.length(); i++){
            if (p.charAt(0) == s.charAt(i) || p.charAt(0) == '.'){
                if (isMatch(s.substring(i),p.substring(2)))
                    return true;
            } else
            	break;
        }
        return isMatch(s.substring(i),p.substring(2));
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegExprMatch reg = new RegExprMatch();
		System.out.println(reg.isMatch2("b", "b"));
	}

}
