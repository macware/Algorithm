package Graph;

public class Edge {
	//flag indicating whether this edge is explored or not
	public boolean flag;
	public int weight;
	
	public Vertex tail;
	public Vertex head;
	
	public Edge(Vertex from, Vertex to){
		tail = from;
		head = to;
		
		weight = 1;
		flag = false;
	}
	
	public Edge(Vertex from, Vertex to, int cost){
		tail = from;
		head = to;
		
		weight = cost;
		flag = false;
	}
}
