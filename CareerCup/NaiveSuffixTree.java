package CareerCup;
import java.util.*;

// Chapter 18.8
public class NaiveSuffixTree {

	public static class SuffixTree{
		private SuffixTreeNode root;
		
		public SuffixTree(String str){
			root = new SuffixTreeNode();
			for(int i = 0; i < str.length(); i++)
				root.insertString(str.substring(i));
		}
		
		public boolean search(String str){
			return root.search(str);
		}
	}
	
	public static class SuffixTreeNode{
		public HashMap<Character,SuffixTreeNode> children = new HashMap<Character,SuffixTreeNode>();
		public SuffixTreeNode(){
			
		}
		
		public void insertString(String str){
			if (str != null && str.length() > 0){
				char val = str.charAt(0);
				SuffixTreeNode child = null;
				if (children.containsKey(val)){
					child = children.get(val);
				} else {
					child = new SuffixTreeNode();
					children.put(val, child);
				}
				child.insertString(str.substring(1));
			}
		}
		
		public boolean search(String str){
			if (str == null || str.length() == 0)
				return true;
			else {
				char val = str.charAt(0);
				if (children.containsKey(val)){
					return children.get(val).search(str.substring(1));
				} else {
					return false;
				}
			}
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuffixTree st = new SuffixTree(" ABCDAB ABCDABCDABDE");
		System.out.println(st.search("ABCDABC"));
		
	}

}
