package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.model.Carro;


public class DAO {
	
	public DAO() {
		super();
	}	
	
	
	public void cadastrarCarro(Carro carro) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into carro (modelo, ano) values (?, ?)");
			p.setString(1, carro.getModeloCarro());
			p.setInt(2, carro.getAnoCarro());
			//p.setBoolean(3, carro.getPagaIPVA());
			System.out.println(p);
			
			p.executeUpdate();
			System.out.println("Carro cadastrado");
			p.close();
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<Carro> mostrarVeiculos(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Carro> carros = new ArrayList<>();
		try {
			PreparedStatement p = con.prepareStatement("select * from carro");
			ResultSet r = p.executeQuery();
			
			while(r.next()) {
				Integer id = r.getInt("id");
				String modelo = r.getString("modelo");
				Integer ano = r.getInt("ano");
				Boolean ipva = r.getBoolean("flag_ipva");
				
				Carro carro = new Carro(modelo, ano, ipva);
				carro.setIdCarro(id);
				carros.add(carro);
			}
			r.close();
			p.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
		return carros;	
	}
	
	
	
	public void deletarCarro (Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from carro where id = ?");
			p.setInt(1, id);
			System.out.println(p);
			
			p.executeUpdate();
			System.out.println("Carro deletado");
			p.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	

	
	public void alterarCarro(Carro carro) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update carro set modelo = ?, ano = ? where id = ?");
			p.setString(1, carro.getModeloCarro());
			p.setInt(2, carro.getAnoCarro());
			//p.setBoolean(3, carro.getFlag_ipva());
			p.setInt(3, carro.getIdCarro());
			System.out.println(p);
			
			p.executeUpdate();
			System.out.println("Alterado");
			
			p.close();
			con.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public Carro buscarCarro(Integer cod_carro) {
		
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Carro carro = null;
		
		try {
			PreparedStatement p = con.prepareStatement("select * from carro where id = ?");
			p.setInt(1, cod_carro);
			ResultSet r = p.executeQuery();
			
			while (r.next()) {
				Integer idCarro= r.getInt("id");
				String modeloCarro = r.getString("modelo");
				Integer anoCarro = r.getInt("ano");
				Boolean flag_ipva = r.getBoolean("flag_ipva");
				
				
				carro = new Carro(modeloCarro, anoCarro, flag_ipva);
				carro.setIdCarro(idCarro);
			}
			
			r.close();
			p.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return carro;
	}
	
	
//	public Integer verificarAnoIPVA() {
//		Conexao c = Conexao.getInstance();
//		Connection con = c.getConnection();
//		IPVA ano = new IPVA();
//		try {
//			PreparedStatement p = con.prepareStatement("select ano from ipva");
//			ResultSet r = p.executeQuery();
//			
//			if(r.equals(null) || r.equals("")) {
//				Integer id = r.getInt("id");
//				Integer ano = r.getString("ano");
//				IPVA ano = new IPVA(id, ano);
//			}
//			while(r.next()) {
//				Integer id = r.getInt("id");
//				String ano = r.getString("ano");
//
//				IPVA ipva = new IPVA(id, ano);
//				ipva.setIdIPVA(id);
//				listaIPVA.add(ipva);
//			}
//			r.close();
//			p.close();
//		}
//		catch (SQLException e){
//			e.printStackTrace();
//		}
//		
//		return listaIPVA;	
//	}
//	
	
	
//	public Integer contarCarrosCadastrados () {
//		Conexao c = Conexao.getInstance();
//		Connection con = c.getConnection();
//		Integer contagem = 0;
//		
//		try {
//			PreparedStatement p = con.prepareStatement("select count(*) from carro");
//			ResultSet r = p.executeQuery();
//			r.close();
//			p.close();
//		}
//		catch (SQLException e){
//			e.printStackTrace();
//		}	
//	}
//	return contagem;
}
