package GraphNew;
import java.util.*;

//THIS IMPLEMENTS GRAPH USIGN ADJACENCY LIST

public class GraphWeightedUndirected{
	ArrayList<ArrayList<ArrayList<Integer>>> g = new ArrayList<ArrayList<ArrayList<Integer>>>();
	int vertices;
	
	GraphWeightedUndirected(int n){
		this.vertices = n;
		//this below code create array list at every position in g, i.e. g[0],g[1],...all are ArrayList
		for(int i=0;i<n;i++) {
//			Adding arrayList of arrayList at each index of g
			g.add(new ArrayList<ArrayList<Integer>>());
		}
		
	}
	
	void addEdge(int u, int v, int weight) {
		ArrayList<Integer> tmp1 = new ArrayList<Integer>();
        ArrayList<Integer> tmp2 = new ArrayList<Integer>();
        
        tmp1.add(v);
        tmp1.add(weight);
        tmp2.add(u);
        tmp2.add(weight);
		
//        adding array (node,weight) at index position
		g.get(u).add(tmp1);
		g.get(v).add(tmp2);
	}
	
	void printGraph() {
		for(int i=0;i<g.size();i++) {
			System.out.print(i+"->");
			for(int j=0;j<g.get(i).size();j++) {
				System.out.print(g.get(i).get(j).get(0)+" "+g.get(i).get(j).get(1)+"  ");
			}
			System.out.println();
		}
	}

}