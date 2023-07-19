package GraphNew;
import java.util.*;

//THIS IMPLEMENTS GRAPH USIGN ADJACENCY LIST

public class GraphUndirected{
	ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
	int vertices;
	
	GraphUndirected(int n){
		this.vertices = n;
		//this below code create array list at every position in g, i.e. g[0],g[1],...all are ArrayList
		for(int i=0;i<n;i++) {
			g.add(new ArrayList<Integer>());
		}
		
	}
	void addEdge(int u,int v) {
		g.get(u).add(v);
		g.get(v).add(u);
	}
	void printGraph() {
		for(int i=0;i<g.size();i++) {
			System.out.print(i+"->");
			System.out.println(g.get(i));
		}
	}

}