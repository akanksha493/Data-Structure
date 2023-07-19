package GraphNew;
import java.util.*;

//SINCE EDGE IS ALREADY DEFINED IN PRIMS WE WILL USE THAT


//this class is implemented in order to detect any cycles in the graph
class DisjointSet{
	int[] parent, rank;
	DisjointSet(int v){
		parent = new int[v];
		rank = new int[v];
		for(int i=0;i<v;i++) {
			parent[i]=i;
		}
	}
	int find(int x) {
		if(parent[x]!=x) {
			parent[x]= find(parent[x]);
		}
		return parent[x];
	}
	void union(int x,int y) {
		int xparent = find(x);
		int yparent = find(y);
		if(xparent == yparent) {
			return ;
		}
		if(rank[xparent]>rank[yparent]) {
			parent[yparent]=xparent;
		}
		else if(rank[xparent]<rank[yparent]) {
			parent[xparent]=yparent;
		}
		else {
			parent[xparent]=yparent;
			rank[yparent]++;
		}
	}
}

class MstKruskal{
	void printMst(ArrayList<Edge> mst) {
		for(Edge e: mst) {
			System.out.println(e.src+" - "+e.dest+" "+e.wt);
		}
	}
	ArrayList<Edge> makeEdgeList(ArrayList<ArrayList<ArrayList<Integer>>> g){
		int vertices = g.size();
		ArrayList<Edge> edgeList = new ArrayList<>();
		
		for(int i=0;i<vertices;i++) {
			for(int j=0;j<g.get(i).size();j++) {
				int src = i;
				int dest = g.get(i).get(j).get(0);
				int wt = g.get(i).get(j).get(1);
				edgeList.add(new Edge(src,dest,wt));
			}
		}
		
		return edgeList;
	}
	
	int kruskalAlgo(GraphWeightedUndirected obj) {
		ArrayList<Edge> edgeList = makeEdgeList(obj.g);
		DisjointSet d = new DisjointSet(obj.vertices);
		Collections.sort(edgeList);
		int sum =0;
		ArrayList<Edge> mst = new ArrayList<>();
		
//		this loop just ensures that v-1 edges are selected
		int count = 1;
		for(int i=0;count<obj.vertices;i++) {
			Edge e = edgeList.get(i);
			int srcParent = d.find(e.src);
			int destParent = d.find(e.dest);
//			only add if they are not connected
			if(srcParent!=destParent) {
				d.union(srcParent, destParent);
				mst.add(e);
				sum +=e.wt;
				count++;
			}
		}
		
		System.out.println("Minimum Spanning Tree:");
		printMst(mst);
		return sum;
		
	}
}

class Kruskal{
	public static void main(String args[]) {
		GraphWeightedUndirected gwu = new GraphWeightedUndirected(5);
		gwu.addEdge(0, 1, 2);
		gwu.addEdge(0, 3, 6);
		gwu.addEdge(3, 1, 8);
		gwu.addEdge(1, 2, 3);
		gwu.addEdge(1, 4, 5);
		gwu.addEdge(2, 4, 7);
		gwu.addEdge(3, 4, 9);
		
		gwu.printGraph();
		
		MstKruskal p = new MstKruskal();
		System.out.println("MST sum: "+p.kruskalAlgo(gwu));
        
        
	}
}