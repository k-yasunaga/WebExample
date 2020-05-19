package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.shouhin;
import Model.shouhinDAO;

/**
 * Servlet implementation class delServlet
 */
@WebServlet("/del")
public class delServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public delServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sid= request.getParameter("sid");

		if(sid==null) {
			response.sendRedirect("slist");
			return;
		}
		int s1 = Integer.parseInt(sid);

		shouhinDAO dao= new shouhinDAO();
		shouhin s=dao.findBysid(s1);
		request.setAttribute("shouhin", s);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/JSP/del.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sid= request.getParameter("sid");
		int s1 = Integer.parseInt(sid);
		shouhinDAO dao= new shouhinDAO();
		dao.delete(s1);

		response.sendRedirect("slist");
	}

}
