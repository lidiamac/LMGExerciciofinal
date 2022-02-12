package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.model.Carro;
import br.com.model.IPVA;

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
			//p.setBoolean(3, carro.getFlag_ipva());
			System.out.println(p);

			p.executeUpdate();
			System.out.println("Carro cadastrado");
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Carro> mostrarVeiculos() {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Carro> carros = new ArrayList<>();
		try {
			PreparedStatement p = con.prepareStatement("select * from carro");
			ResultSet r = p.executeQuery();

			while (r.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return carros;
	}

	
	public void deletarCarro(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();

		try {
			PreparedStatement p = con.prepareStatement("delete from carro where id = ?");
			p.setInt(1, id);
			System.out.println(p);

			p.executeUpdate();
			System.out.println("Carro deletado");
			p.close();
		} catch (SQLException e) {
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
			// p.setBoolean(3, carro.getFlag_ipva());
			p.setInt(3, carro.getIdCarro());
			System.out.println(p);

			p.executeUpdate();
			System.out.println("Alterado");

			p.close();
			con.close();
		} catch (SQLException e) {
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
			PreparedStatement p2 = con.prepareStatement("select * from carro where id = ?");
			p.setInt(1, cod_carro);
			ResultSet r = p.executeQuery();

			while (r.next()) {
				Integer idCarro = r.getInt("id");
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

	
	
	
	public Integer mostrarAnoIPVA() {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		 try {
			 Integer ano = null;
			 PreparedStatement p = con.prepareStatement("select ano from ipva");
			 ResultSet r = p.executeQuery();
			 r.next();
			 
			 ano = r.getInt("ano");
			 
			 System.out.println(ano);
			 
			r.close();
			p.close();
			
			return ano;
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		return null;    		
    }
	
	
	
	
	public Integer contarCarros() {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		 try {
			 Integer cont = null;
			 PreparedStatement p = con.prepareStatement("select count(*) as NumeroDeCarros from carro");
			 ResultSet r = p.executeQuery();
			 r.next();
			 
			 cont = r.getInt("NumeroDeCarros");
			 
			 System.out.println(cont);
			
			//System.out.println(cont);
			r.close();
			p.close();
			
			return cont;
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		return null;    		
    }
	
	
	
	 public void compararAnos() {
//		 Carro c = new Carro();
		ArrayList<Carro> carros = new ArrayList();
				//this.mostrarVeiculos();

		 for (Carro c : carros) {
				if (c.getAnoCarro() <= this.mostrarAnoIPVA()) {
						c.setFlag_ipva(true);
				}
				
			} 
	 }
}
