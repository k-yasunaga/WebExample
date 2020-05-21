package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.UriageDAO;
import Model.uriage;
import Model.user;

/**
 * Servlet implementation class uriagelistServlet
 */
@WebServlet("/ulist")
public class uriagelistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public uriagelistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();

		user u= (user)session.getAttribute("user");

		if(u==null) {
			response.sendRedirect("login");
			return;
		}
		UriageDAO dao= new UriageDAO();
		//全て検索
		ArrayList<uriage> ulist=dao.findAll();
		request.setAttribute("list",ulist);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/JSP/ulist.jsp");
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
