package br.com.model;

public class IPVA {
	private Integer idIPVA;
	private String anoIPVA;
	
	public IPVA() {
		super();
	}
	
	public IPVA(Integer idIPVA, String anoIPVA) {
		super();
		this.idIPVA = idIPVA;
		this.anoIPVA = anoIPVA;
	}
	
	public IPVA(String anoIPVA) {
		super();
		this.anoIPVA = anoIPVA;
	}
	
	
	
	
	public Integer getIdIPVA() {
		return idIPVA;
	}
	public void setIdIPVA(Integer idIPVA) {
		this.idIPVA = idIPVA;
	}
	public String getAnoIPVA() {
		return anoIPVA;
	}
	public void setAnoIPVA(String anoIPVA) {
		this.anoIPVA = anoIPVA;
	}
	
	
	
	
	@Override
	public String toString() {
		return "IPVA [idIPVA=" + idIPVA + ", anoIPVA=" + anoIPVA + "]";
	}
}
