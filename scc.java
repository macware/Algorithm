import Graph.*;
import java.util.*;

public class scc {

	private Graph graph;
	
	// decreasing finish time order of vertices 
	private ArrayList<Integer> stack;
	
	// scc groups
	private int[] groups;
	
	public scc(Graph g){
		graph = g;
		stack = new ArrayList<Integer>(5);
		groups = new int[5];
	}
	
	private void DFS_gRevLoop(Graph gRev){
		for(Vertex v : gRev.vertices.values()){
			if(v.flag == false)
				DFS_gRev(gRev,v.id);
		}
	}
	
	private void DFS_gRev(Graph g, int s){
		// mark s as explored
		Vertex src = g.vertices.get(s);
		src.flag = true;
		
		// for each arc
		Vertex v;
		for(Integer i : src.adjEdges){
			v = g.edges.get(i).head;
			if(v.flag == false)
				DFS_gRev(g,v.id);
		}
		
		// put s into the stack
		stack.add(0, s);
	}
	
	private void DFS_gLoop(){
		int group = 0;
		for(Integer i : stack){
			if(graph.vertices.get(i).gid == -1){
				groups[group] = 0;
				DFS_g(i,group);
				group++;
			}
		}
	}
	
	private void DFS_g(int s, int group){
		Vertex src = graph.vertices.get(s);
		src.gid = group;
		
		Vertex v;
		for(Integer i : src.adjEdges){
			v = graph.edges.get(i).head;
			if(v.gid == -1)
				DFS_g(v.id,group);
		}
		
		groups[group] += 1;
	}
	
	public void computeSCCs(){
		
		System.out.println("Start computing SCCs ... ");
		
		Graph gRev = Graph.reverseGraph(graph);
		DFS_gRevLoop(gRev);
		DFS_gLoop();
		
		System.out.println("the sizes of SCCs are");
		for(int i = 0; i < groups.length; i++)
			System.out.println(groups[i]);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("scc");
		
		Graph graph = Graph.buildGraph("//media//Work//src//Scc.txt");
		if(graph == null)
			return;
		
		scc sccs = new scc(graph);
		sccs.computeSCCs();
		
	}

}
