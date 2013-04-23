package DataStructures;

import java.util.*;

public class HanoiTower {
	public static class Tower {
		private Stack<Integer> disks;
		public int index;

		public Tower(int i) {
			disks = new Stack<Integer>();
			index = i;
		}

		public void add(int d) {
			if (!disks.isEmpty() && disks.peek() <= d) {
				System.out.println("Error placing disk " + d + " on tower "
						+ index);
			} else {
				disks.push(d);
			}
		}

		public void moveTopTo(Tower t) {
			if (!disks.isEmpty()) {
				int top = disks.pop();
				t.add(top);
				System.out.println("Move disk " + top + " from " + index
						+ " to " + t.index);
			}
		}

		public void moveDisks(int n, Tower dest, Tower buf) {
			if (n > 0) {
				moveDisks(n - 1, buf, dest);
				moveTopTo(dest);
				buf.moveDisks(n - 1, dest, this);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		Tower[] towers = new Tower[n];
		int i;
		for (i = 0; i < n; i++) {
			towers[i] = new Tower(i);
		}

		for (i = n - 1; i >= 0; i--) {
			towers[0].add(i);
		}

		towers[0].moveDisks(n, towers[2], towers[1]);
	}

}
