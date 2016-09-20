package br.univel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.univel.ejbsstateles.ProcessVendaInterface;
import br.univel.model.Venda;

/**
 * Servlet implementation class ServletVenda
 */
@WebServlet("/ServletVenda")
public class ServletVenda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(name = "processVendaInterface")
	private ProcessVendaInterface processVendaInterface;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVenda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.write("<h1>Realizando Pedido</h1><br>");

		try {

			Venda venda = new Venda();
			venda.setValorTotal(BigDecimal.valueOf(50.0));


			processVendaInterface.processarVenda(venda);

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}