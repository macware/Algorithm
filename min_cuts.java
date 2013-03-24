import Graph.*;

import java.util.*;

public class min_cuts {
	/**
	 * @param args
	 */
	private int nodesNum;
	private int edgesNum;
	private Graph graph;

	private int gid;
	private HashMap<Integer, HashSet<Integer>> groups;
	
	public min_cuts(Graph g) {
		graph = g;
		gid = 0;

		groups = new HashMap<Integer, HashSet<Integer>>();

		nodesNum = g.vertices.size();
		edgesNum = g.edges.size();
	}

	public Edge rChooseEdge() {
		Random random = new Random();
		int idx = random.nextInt(edgesNum);
		Edge edge = null;

		for (int i = 0; i < graph.edges.size(); i++) {
			edge = graph.edges.get(i);
			if (edge.flag == false) {
				if (idx == 0)
					break;
				idx--;
			}
		}

		return edge;
	}

	public void mergeGroups(int g1, int g2) {

		if (g1 == g2)
			return;

		HashSet<Integer> hSet = groups.get(g2);
		for (Integer id : hSet) {
			graph.vertices.get(id).gid = g1;
			groups.get(g1).add(id);
		}

		groups.remove(g2);
	}

	private void contractEdge(Vertex v, int group) {
		Edge e;
		Vertex t;
		int i, j;

		for (i = 0; i < v.adjEdges.size(); i++) {
			e = graph.edges.get(v.adjEdges.get(i));
			if (e.flag == false
					&& groups.get(group).contains(e.head.id) == true) {
				e.flag = true;
				if (Debug.ON) {
					System.out.println("Contract Edge " + e.tail.id + " -- "
							+ e.head.id);
				}
				edgesNum--;
				if (e.tail.id != e.head.id) {
					// contract the other edge
					t = e.head;
					for (j = 0; j < t.adjEdges.size(); j++) {
						e = graph.edges.get(t.adjEdges.get(j));
						if (e.flag == false && e.head.id == v.id) {
							e.flag = true;
							if (Debug.ON) {
								System.out.println("Contract Edge " + e.tail.id
										+ " -- " + e.head.id);
							}
							edgesNum--;
							break;
						}
					}
				}
			}
		}
	}

	public void contract(Edge edge) {

		if (Debug.ON) {
			System.out.println("Contracting ");
			System.out.println("Choosing Edge " + edge.tail.id + " -- "
					+ edge.head.id);
		}

		// THE FOLLOWING CODES MUST BE CHANGED WHEN DEALING WITH DIRECTED GRAPH

		int group = -1;
		if (edge.tail.gid != -1) {
			group = edge.tail.gid;
			if (edge.head.gid != -1)
				mergeGroups(edge.tail.gid, edge.head.gid);
			else
				edge.head.gid = group;
		} else if (edge.head.gid != -1) {
			group = edge.head.gid;
			if (edge.tail.gid != -1)
				mergeGroups(edge.head.gid, edge.tail.gid);
			else
				edge.tail.gid = group;
		} else {
			group = gid;
			gid++;
			groups.put(group, new HashSet<Integer>());
			edge.tail.gid = group;
			edge.head.gid = group;
		}

		if (groups.get(group).add(edge.tail.id) == true)
			nodesNum--;
		if (groups.get(group).add(edge.head.id) == true)
			nodesNum--;

		if (nodesNum < 0)
			nodesNum = 0;

		// contract edges from its tail's adjacency list
		contractEdge(edge.tail, group);
		// contract edges from its head's adjacency list
		contractEdge(edge.head, group);

		if (Debug.ON) {
			System.out.println("Edges " + edgesNum + " Groups " + groups.size()
					+ " Nodes " + nodesNum);
			System.out.println();
		}
	}

	public void reset() {
		gid = 0;

		groups.clear();

		nodesNum = graph.vertices.size();
		edgesNum = graph.edges.size();

		for (Edge edge : graph.edges) {
			edge.flag = false;
		}

		for (Vertex vertex : graph.vertices.values()) {
			vertex.gid = -1;
		}
	}

	public int calculateMinCuts(int rounds) {
		int cuts, n = 1;
		cuts = 0;
		while (n <= rounds) {
			if (Debug.ON) {
				System.out.println("Start round " + n);
			}

			while ((groups.size() + nodesNum) > 2) {
				contract(rChooseEdge());
			}

			if (n == 1 || cuts > edgesNum / 2)
				cuts = edgesNum / 2;

			reset();
			n++;
		}

		return cuts;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = Graph.buildGraph("//media//Work//src//kargerAdj.txt");
		if (graph == null)
			return;

		min_cuts minCuts = new min_cuts(graph);
		int cuts = minCuts.calculateMinCuts(1600);

		System.out.println("Min cuts is " + cuts);

	}

}
