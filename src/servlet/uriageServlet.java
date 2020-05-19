package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.UriageDAO;
import Model.shouhin;
import Model.shouhinDAO;
import Model.uriage;

/**
 * Servlet implementation class uriageServlet
 */
@WebServlet("/uriage")
public class uriageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public uriageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sid= request.getParameter("sid");
		int s1 = Integer.parseInt(sid);
		UriageDAO dao= new UriageDAO();
		ArrayList<uriage> list = dao.findBySid(s1);

		shouhinDAO daos= new shouhinDAO();
		shouhin s = daos.findBysid(s1);
		request.setAttribute("list", list);
		request.setAttribute("shouhin", s);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/JSP/uriage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String kosu= request.getParameter("kosu");
		String sid= request.getParameter("sid");
		int k = Integer.parseInt(kosu);
		int s = Integer.parseInt(sid);
		UriageDAO dao= new UriageDAO();
		uriage u = new uriage(0, s,k,null);
		dao.insert(u);

		response.sendRedirect("uriage?sid="+s);

	}

}
