package assignment5_f20;

public class Edge implements EdgeInterface {
	
	private long idNum;
	private String sLabel;
	private String dLabel;
	private long weight;
	private String eLabel;
	
	public Edge(long idNum, String sLabel, String dLabel, long weight, String eLabel ) {
		this.idNum = idNum;
		this.sLabel = sLabel;
		this.dLabel= dLabel;
		this.weight = weight;
		this.eLabel = eLabel;
		
	}

	@Override
	public long getIdNum() {
		// TODO Auto-generated method stub
		return idNum;
	}

	@Override
	public String getSLabel() {
		// TODO Auto-generated method stub
		return sLabel;
	}

	@Override
	public String getDLabel() {
		// TODO Auto-generated method stub
		return dLabel;
	}

	@Override
	public long getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public String getELabel() {
		// TODO Auto-generated method stub
		return eLabel;
	}
	

}
