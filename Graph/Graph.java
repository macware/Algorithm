package Graph;

import java.io.*;
import java.util.*;

public class Graph {

	public HashMap<Integer,Vertex> vertices;
	public ArrayList<Edge> edges;
	
	private Graph(){
		vertices = new HashMap<Integer,Vertex>(2);
		edges = new ArrayList<Edge>(2);
	}
	
	public static Graph reverseGraph(Graph g){
		
		if(g == null)
			return null;
		
		Graph graph = new Graph();	
		
		// share the same nodes set
		for(Integer i : g.vertices.keySet()){
			graph.vertices.put(i, new Vertex(i));
		}
		
		// reverse the edges
		Vertex tail,head;
		Edge edge;
		for(Edge e : g.edges){
			tail = graph.vertices.get(e.head.id);
			head = graph.vertices.get(e.tail.id);
			edge = new Edge(tail,head);
			
			// add edge to the graph
			graph.edges.add(edge);
			
			// add edge to the tail's adjacency list
			tail.adjEdges.add(graph.edges.indexOf(edge));
		}
		
		return graph;
	}
	
	public static Graph buildGraph(String filePath){
		Graph graph = null;
		
		try{
			BufferedReader bReader = new BufferedReader(new FileReader(filePath));
			String line;	
			graph = new Graph();
			
			while((line = bReader.readLine()) != null){
				String[] nodes = line.split(" ");
				
				Vertex tail = null;
				int id = Integer.parseInt(nodes[0]);
				// generate a new tail node
				if(graph.vertices.containsKey(id) == false){
					tail = new Vertex(id);
					graph.vertices.put(id, tail);
				} else {
					tail = graph.vertices.get(id);
				}
				
				Vertex head = null;
				for(int i = 1; i < nodes.length; i++){
					
					if(nodes[i].equals("") == true)
						continue;

					id = Integer.parseInt(nodes[i]);					
					// generate a new head node
					if(graph.vertices.containsKey(id) == false){
						head = new Vertex(id);
						graph.vertices.put(id, head);
					} else {
						head = graph.vertices.get(id);
					}
					
					Edge edge = new Edge(tail,head);
					graph.edges.add(edge);
					// add a edge to the adjacency list
					tail.adjEdges.add(graph.edges.indexOf(edge));					
				}				
			}
			
			bReader.close();
			
		} catch(Exception e){
			System.out.println("Fail to build a graph from file "+filePath);
			e.printStackTrace();
			graph = null;
		}
		
		return graph;
	}
}
