package assignment5_f20;

import java.util.HashMap;

public class Node implements NodeInterFace {
	
	private long idNum;
	private String label;
	public HashMap<String, Edge> Edges = new HashMap<String, Edge>();
	public long distance;

	public Node (long idNum, String label) {
		this.idNum = idNum;
		this.label = label;
		this.distance = 0;
	}

	@Override
	public long getIdNum() {
		// TODO Auto-generated method stub
		return idNum;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return label;
	}
	
	public void addEdge(String  dlabel, Edge edge) {
		Edges.put(dlabel, edge);
	}
	
	public boolean edgeExist(String dlabel) {
		return Edges.containsKey(dlabel);
	}
	
	public long getEdgeID(String dlabel) {
		return Edges.get(dlabel).getIdNum();
	}
	
	public long getWeight(String dlabel) {
		return Edges.get(dlabel).getWeight();
	}
	
	public void delEdge(String  dlabel) {
		Edges.remove(dlabel);
	}
	
	public HashMap<String, Edge> getEdgeMap() {
		return Edges;
	}
	public long distance() {
		System.out.println(distance);
		return this.distance;
	}
	// also do a hashmap

}
