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
 * Servlet implementation class updateServlet
 */
@WebServlet("/update")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sidstr= request.getParameter("sid");
		int sid = Integer.parseInt(sidstr);

		shouhinDAO dao= new shouhinDAO();
		shouhin s=dao.findBysid(sid);
		request.setAttribute("shouhin", s);

		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/JSP/update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sidstr= request.getParameter("sid");
		int sid = Integer.parseInt(sidstr);
		String sname = request.getParameter("sname");
		String tankaStr = request.getParameter("tanka");
		int tanka = Integer.parseInt(tankaStr);

		shouhinDAO dao = new shouhinDAO();
		shouhin s2 = new shouhin(sid, sname,tanka);
		dao.update(s2);


		response.sendRedirect("slist");
	}

}
