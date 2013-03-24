package Graph;

import java.util.*;

public class Vertex {
	//flag indicating whether this vertex is explored or not
	public boolean flag;
	
	//indicating a group id
	public int gid;
	
	public int id;
	public ArrayList<Integer> adjEdges;
	
	public Vertex(int label){
		id = label;
		gid = -1;
		
		adjEdges = new ArrayList<Integer>(2);
		
		flag = false;
	}
}
