package GraphNew;
import java.util.*;

class Edge implements Comparable<Edge>{
	int src,dest,wt;
	Edge(int _src, int _dest, int _wt){
		this.src = _src;
		this.dest = _dest;
		this.wt = _wt;
	}
	public int compareTo(Edge that) {
		return this.wt- that.wt;
	}
}

class MstPrim{
	void printMst(ArrayList<Edge> mst) {
		for(Edge e: mst) {
			System.out.println(e.src+" - "+e.dest+" "+e.wt);
		}
	}
	int primsAlgo(GraphWeightedUndirected obj) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean included[] = new boolean[obj.g.size()];
//		int mst[] = new int[obj.g.size()-1];
		ArrayList<Edge> mst = new ArrayList<Edge>();
		
		int sum = 0;
		int node ,parent;
		included[0]= true;
		
		pq.offer(new Edge(-1,0,0));
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			parent = e.src;
			node = e.dest;
			if(!included[node]) {
				included[node]= true;
				mst.add(new Edge(parent,node, e.wt));
				sum += e.wt;
			}
			for(int i=0;i<obj.g.get(node).size();i++) {
				int neighbor = obj.g.get(node).get(i).get(0);
				int weight = obj.g.get(node).get(i).get(1);
				if(!included[neighbor]) {
					pq.offer(new Edge(node,neighbor,weight));
				}
			}
			
		}
		
		printMst(mst);
		return sum;
	}
	
}

public class Prims{
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
		
		MstPrim p = new MstPrim();
		System.out.println("MST sum: "+p.primsAlgo(gwu));
		
	}
}