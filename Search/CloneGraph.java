package Search;
import java.util.*;

public class CloneGraph {

	public UndirectedGraphNode cloneGraph_dfs(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (node == null)
            return node;
            
        Map<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(root.label, root);
        
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        stack.push(root);
        Stack<UndirectedGraphNode> stackold = new Stack<UndirectedGraphNode>();
        stackold.push(node);
        
        UndirectedGraphNode cur, curold;
        while (!stackold.isEmpty()){
            curold = stackold.pop();
            cur = stack.pop();
            for (UndirectedGraphNode n: curold.neighbors){
                if (map.containsKey(n.label)){
                    cur.neighbors.add(map.get(n.label));
                    continue;
                }
                
                UndirectedGraphNode newNode = new UndirectedGraphNode(n.label);
                map.put(n.label,newNode);
                cur.neighbors.add(newNode);
                
                stackold.push(n);
                stack.push(newNode);
            }
        }
        
        return root;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
