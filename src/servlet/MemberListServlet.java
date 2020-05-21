package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.member;
import Model.memberDAO;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/mlist")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		memberDAO dao= new memberDAO();
		//全て検索
		ArrayList<member> mlist=dao.findAll();

		request.setAttribute("list",mlist);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/JSP/mlist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
		request.setCharacterEncoding("UTF-8");
		String namestr = request.getParameter("name");
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
			member m1= new member(0, namestr,adrstr);
			dao.insert(m1);

			response.sendRedirect("mlist");
		}


		}catch(NumberFormatException e){
			request.setAttribute("mes", "");
			request.setAttribute("url", "mlist");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/error.jsp");
			dispatcher.forward(request, response);
		}



	}

}
