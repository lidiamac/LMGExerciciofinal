package br.com.model;


public class Carro {
	private Integer idCarro;
	private String modeloCarro;
	private Integer anoCarro;
	private Boolean flag_ipva;

	

	public Carro() {
		super();
	}
	
	
	public Carro(String modeloCarro, Integer anoCarro) {
		super();
		this.modeloCarro = modeloCarro;
		this.anoCarro = anoCarro;
	}
	
	
	public Carro(String modeloCarro, Integer anoCarro, Boolean flag_ipva) {
		super();
		this.modeloCarro = modeloCarro;
		this.anoCarro = anoCarro;
		this.flag_ipva = flag_ipva;
	}
	
	
	public Carro(Integer idCarro, String modeloCarro, Integer anoCarro, Boolean flag_ipva) {
		super();
		this.idCarro = idCarro;
		this.modeloCarro = modeloCarro;
		this.anoCarro = anoCarro;
		this.flag_ipva = flag_ipva;
	}
	


	
	public Integer getIdCarro() {
		return idCarro;
	}


	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}


	public String getModeloCarro() {
		return modeloCarro;
	}


	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}


	public Integer getAnoCarro() {
		return anoCarro;
	}


	public void setAnoCarro(Integer anoCarro) {
		this.anoCarro = anoCarro;
	}

	
	public Boolean getFlag_ipva() {
		return true;
	}


	public void setFlag_ipva(Boolean flag_ipva) {
		this.flag_ipva = flag_ipva;
	}


	@Override
	public String toString() {
		return "\n\nCarro [idCarro=" + idCarro + ", \nmodeloCarro=" + modeloCarro + ", \nanoCarro=" + anoCarro + ", \npagaIPVA="
				+ flag_ipva + "]";
	}



	
}
