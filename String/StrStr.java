package String;

public class StrStr {

	private int[] buildBt(String needle) {
		int[] bt = new int[needle.length()];
		bt[0] = 0;

		int j = -1;
		for (int i = 1; i < needle.length(); i++) {
			while (j > -1 && needle.charAt(i) != needle.charAt(j + 1))
				j = bt[j] - 1;

			if (needle.charAt(i) == needle.charAt(j + 1))
				j++;

			bt[i] = j + 1;
		}

		return bt;
	}

	public String strStr(String haystack, String needle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (needle == null || haystack == null)
			return null;

		if (needle.length() == 0)
			return haystack;

		int[] bt = buildBt(needle);

		int j = -1;
		for (int i = 0; i < haystack.length(); i++) {
			while (j > -1 && haystack.charAt(i) != needle.charAt(j + 1))
				j = bt[j] - 1;

			if (haystack.charAt(i) == needle.charAt(j + 1))
				j++;

			if (j == needle.length() - 1) {
				int start = i - needle.length() + 1;
				return haystack.substring(start);
			}
		}

		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrStr strstr = new StrStr();
		System.out.println(strstr.strStr("test", ""));
	}

}
