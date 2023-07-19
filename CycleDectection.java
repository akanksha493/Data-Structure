package GraphNew;
//import java.util.*;

//Using GraphUndirected.java class
//Using GraphDirected.java class

class CycleDetectionUndirected{
	
	boolean isCyclicUtil(int node, int parent, boolean[] visited,GraphUndirected obj) {
		visited[node]=true;
		
		for(int neighbor:obj.g.get(node)) {
			if(!visited[neighbor]) {
				if(isCyclicUtil(neighbor,node,visited,obj)) {
					return true;
				}
			}
			else if(parent != node) {
				return true;
			}
		}
		return false;
	}
	boolean isCyclic(GraphUndirected obj,int vertices) {
		boolean visited[] = new boolean[vertices];
		
		for(int i=0;i<vertices;i++) {
			if(isCyclicUtil(i,-1,visited,obj)) {
				return true;
			}
		}
		return false;
	}
}

class CycleDetectionDirected{
	boolean isCyclicUtil(int node, boolean recS[], boolean visited[], GraphDirected obj) {
		visited[node]= true;
		recS[node] = true;
		
		for(int neighbor: obj.g.get(node)) {
			if(!visited[neighbor]) {
				if(isCyclicUtil(neighbor,recS,visited,obj)) {
					return true;
				}
			}
			else if(recS[neighbor]) {
				return true;
			}	
		}
		recS[node]= false;
		return false;
	}
	boolean isCyclic(GraphDirected obj, int vertices) {
		boolean visited[] = new boolean[vertices];
		boolean recS[] =  new boolean[vertices];
		
		for(int i=0;i<vertices;i++) {
			if(isCyclicUtil(i,recS,visited,obj)) {
				return true;
			}
		}
		return false;
	}
}

public class CycleDectection{
	public static void main(String args[]) {
		
		GraphUndirected gu = new GraphUndirected(3);
		gu.addEdge(0, 1);
		gu.addEdge(1, 2);
		gu.addEdge(2, 0);
		gu.printGraph();
		
		CycleDetectionUndirected a = new CycleDetectionUndirected();
		System.out.println(a.isCyclic(gu, 3));
		
		GraphDirected gd = new GraphDirected(4);
		gd.addEdge(0, 1);
		gd.addEdge(1, 2);
		gd.addEdge(2, 0);
		gd.addEdge(2, 3);
		
		gd.printGraph();
		
		CycleDetectionDirected b = new CycleDetectionDirected();
		System.out.println(b.isCyclic(gd, 4));
		
		
		
	}
}