package br.univel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Hashtable;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.univel.ejbsstateles.ProcessEntrega;
import br.univel.ejbsstateles.ProcessEntregaInterface;
import br.univel.model.Entrega;

/**
 * Servlet implementation class ServletEntrega
 */
@WebServlet("/ServletEntrega")
public class ServletEntrega extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(name = "processEntregaInterface")
	private ProcessEntregaInterface processEntregaInterface;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletEntrega() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.write("<h1>Realizando Pedido</h1><br>");

		try {

			Entrega entrega = new Entrega();
			entrega.setDataEntrega(new Date());
			entrega.setEndereco("Batatinha");

			processEntregaInterface.processarEntrega(entrega);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			out.write("<h1>Pedido Realizado com sucesso!</h1><br>");
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}