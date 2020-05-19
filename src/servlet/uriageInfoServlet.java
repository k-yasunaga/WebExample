package servlet;

import java.io.IOException;

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
 * Servlet implementation class uriageInfo
 */
@WebServlet("/uinfo")
public class uriageInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public uriageInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uidstr = request.getParameter("uid");
		int uid = Integer.parseInt(uidstr);



		UriageDAO dao= new UriageDAO();
		uriage u= dao.findByUid(uid);
		request.setAttribute("uriage",u);

		shouhinDAO dao1= new shouhinDAO();
		shouhin s= dao1.findBysid(u.getSid());
		request.setAttribute("shouhin",s);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/JSP/uinfo.jsp");
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
