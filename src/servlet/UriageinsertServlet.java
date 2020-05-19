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
 * Servlet implementation class UriageinsertServlet
 */
@WebServlet("/uinsert")
public class UriageinsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UriageinsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		shouhinDAO dao= new shouhinDAO();
		//全て検索
		ArrayList<shouhin> slist=dao.findAll();

		request.setAttribute("list",slist);

		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/JSP/uinsert.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setCharacterEncoding("UTF-8");
		String sidstr = request.getParameter("sid");
		String kosustr = request.getParameter("kosu");

		int sid = Integer.parseInt(sidstr);
		int kosu = Integer.parseInt(kosustr);

		UriageDAO dao = new UriageDAO();
		uriage u = new uriage(0, sid,kosu,null);
		dao.insert(u);

		response.sendRedirect("ulist");
		}catch(NumberFormatException e) {
			request.setAttribute("mes", "個数には数字を入力してください");
			request.setAttribute("url", "uinsert");
			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/JSP/error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
