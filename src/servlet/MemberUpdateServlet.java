package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.member;
import Model.memberDAO;

/**
 * Servlet implementation class MmberUpdateServlet
 */
@WebServlet("/mupdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String midstr= request.getParameter("mid");
		int mid = Integer.parseInt(midstr);

		memberDAO dao= new memberDAO();
		member m=dao.findByMid(mid);

		request.setAttribute("member", m);

		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/JSP/mupdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String midstr= request.getParameter("mid");
		int m = Integer.parseInt(midstr);
		String namestr= request.getParameter("name");
		String adrstr = request.getParameter("adr");
		if(namestr.equals("")) {
			request.setAttribute("mes", "氏名を入力しやがれ");
			request.setAttribute("url", "mlist");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/error.jsp");
			dispatcher.forward(request, response);
		}
		if(adrstr.equals("")) {
			request.setAttribute("mes", "住所を入力しやがれ");
			request.setAttribute("url", "mlist");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/error.jsp");
			dispatcher.forward(request, response);
		}

		if(namestr.length() != 0 && adrstr.length() != 0) {
			memberDAO dao = new memberDAO();
			member m2 = new member(m, namestr,adrstr);
			dao.update(m2);
			response.sendRedirect("mlist");
		}
	}

}
