package Search;

import java.util.*;

public class RestoreIP {

	public void restoring(ArrayList<String> res, String s, int[] ip, int n) {
		if (n == 3) {
			if (s.length() > 3 || s.length() == 0
					|| (s.length() > 1 && s.charAt(0) == '0'))
				return;

			ip[n] = Integer.parseInt(s);
			if (ip[n] > 255)
				return;

			res.add(ip[0] + "." + ip[1] + "." + ip[2] + "." + ip[3]);
			return;
		}

		if (s.length() < 4 - n)
			return;

		if (s.charAt(0) == '0') {
			ip[n] = 0;
			restoring(res, s.substring(1), ip, n + 1);
		} else {
			int l = Math.min(3, s.length());
			while (l > 0) {
				ip[n] = Integer.parseInt(s.substring(0, l));
				if (ip[n] <= 255)
					restoring(res, s.substring(l), ip, n + 1);
				l--;
			}
		}

		return;
	}

	public ArrayList<String> restoreIpAddresses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> res = new ArrayList<String>();
		if (s == null || s.length() < 4 || s.length() > 12)
			return res;

		int[] ip = new int[4];
		restoring(res, s, ip, 0);
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreIP ri = new RestoreIP();
		System.out.println(ri.restoreIpAddresses("255255118"));
	}

}
