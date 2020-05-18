package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.sankaku;

/**
 * Servlet implementation class sankakuServlet
 */
@WebServlet("/sankaku")
public class sankakuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public sankakuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1= request.getParameter("num1");
		String num2= request.getParameter("num2");
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);

		sankaku s= new sankaku(n1,n2);

		request.setAttribute("sankaku", s);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/JSP/sankaku.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
