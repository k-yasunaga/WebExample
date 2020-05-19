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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String sname = request.getParameter("sname");
			String tankaStr = request.getParameter("tanka");
			int tanka = Integer.parseInt(tankaStr);
			if(sname.equals("")) {
				request.setAttribute("mes", "商品名を入力してください");
				request.setAttribute("url", "insert.html");

				RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/JSP/error.jsp");
				dispatcher.forward(request, response);
				return;
			}
			shouhin s1 = new shouhin(0, sname,tanka);

			request.setAttribute("shouhin", s1);
			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/JSP/kakunin.jsp");
			dispatcher.forward(request, response);
		}catch(NumberFormatException e) {
			request.setAttribute("mes", "単価には数字を入力してください");
			request.setAttribute("url", "insert.html");
			RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/JSP/error.jsp");
			dispatcher.forward(request, response);
		}
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sname = request.getParameter("sname");
		String tankaStr = request.getParameter("tanka");
		int tanka = Integer.parseInt(tankaStr);

		shouhinDAO dao = new shouhinDAO();
		shouhin s1 = new shouhin(0, sname,tanka);
		dao.insert(s1);


		response.sendRedirect("slist");
//		request.setAttribute("shouhin",s1);
//		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/JSP/insert.jsp");
//		dispatcher.forward(request, response);

	}

}