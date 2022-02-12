package br.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.DAO;
import br.com.model.Carro;
//import br.com.model.IPVA;
//import model.Container;
import br.com.model.IPVA;

/**
 * Servlet implementation class ServletIPVA
 */
@WebServlet("/ServletIPVA")
public class ServletIPVA extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO dao;
	 IPVA ipva = new IPVA();
	//IPVA ano = new IPVA();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletIPVA() {
		super();
		  this.dao = new DAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opc = request.getParameter("option");
		if (opc == null) {
			opc = "qualquer coisa";
		}
		switch(opc) {
		case ("insertForm"):
			mostrarCarroInserido(request, response);
		break;
		case ("updateForm"):
			mostrarCarroAtualizado(request, response);
		break;
		case ("update"):
			alterarCarro(request, response);
		break;
		case ("delete"):
			deletarCarro(request, response);
		break;
		case ("insert"):
			inserirCarro(request, response);
		break;
		default:
			mostrarCarros(request, response);
	}
	}
	

	private void inserirCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modelo = request.getParameter("modeloCarro");
		String ano = request.getParameter("anoCarro");

		if (!modelo.equals(null) && !ano.equals(null)) {
			if (!modelo.equals("") && !ano.equals("")) {
				Integer anoNumero = Integer.parseInt(ano);
				Carro carro = new Carro(modelo, anoNumero);
				dao.cadastrarCarro(carro);
			}
		}
		response.sendRedirect("ServletIPVA");
	}

	private void mostrarCarros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("carros", dao.mostrarVeiculos());
	//	request.setAttribute("anoIPVA", dao.mostrarAnoIPVA());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void deletarCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idCarro");
		if (id != null) {
			Integer idNumero = Integer.parseInt(id);
			dao.deletarCarro(idNumero);
		}
		response.sendRedirect("ServletIPVA");
	}

	private void alterarCarro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("idCarro"));
		String modelo = request.getParameter("modeloCarro");
		String ano = request.getParameter("anoCarro");


		if ((modelo != null) && (ano != null)) {
			if (!modelo.equals("")) {

				Integer anoNumero = Integer.parseInt(ano);
				
				Carro carro = new Carro(modelo, anoNumero);
				carro.setIdCarro(id);
				dao.alterarCarro(carro);
				
			}
		}
		System.out.println("id não nulo");
		response.sendRedirect("ServletIPVA");
	}
	

	private void mostrarCarroAtualizado(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("idCarro"));
		Carro carro = dao.buscarCarro(id);
		
		request.setAttribute("carros", carro);

		request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
	}
	
	
	private void mostrarCarroInserido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("totalCadastrado", this.dao.contarCarros());
		request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
	}
	
	

}
