package br.com.model;

public class IPVA {
	private Integer idIPVA;
	private Integer anoIPVA;
	
	public IPVA() {
		super();
	}

	
	public IPVA(Integer idIPVA, Integer anoIPVA) {
		super();
		this.idIPVA = idIPVA;
		this.anoIPVA = anoIPVA;
	}


	public IPVA(Integer anoIPVA) {
		super();
		this.anoIPVA = anoIPVA;
	}


	public Integer getIdIPVA() {
		return idIPVA;
	}


	public void setIdIPVA(Integer idIPVA) {
		this.idIPVA = idIPVA;
	}


	public Integer getAnoIPVA() {
		return anoIPVA;
	}


	public void setAnoIPVA(Integer anoIPVA) {
		this.anoIPVA = anoIPVA;
	}


	@Override
	public String toString() {
		return "IPVA [idIPVA=" + idIPVA + ", anoIPVA=" + anoIPVA + "]";
	}
	
}
