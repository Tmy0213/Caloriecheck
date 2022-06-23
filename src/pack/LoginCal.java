package pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;
import dto.LoginDto;

/**
 * Servlet implementation class LoginCal
 */
@WebServlet("/LoginCal")
public class LoginCal extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/jsp/Login.jsp");
        dispatcher.forward(request, response);
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		LoginDao ld = new LoginDao();

		List<LoginDto> list = new ArrayList<LoginDto>();
		list = ld.Loginchk(request);
		if(list != null) {
			request.setAttribute("logdata", list);
			ServletContext context = this.getServletContext();
	        RequestDispatcher dispatcher = context.getRequestDispatcher("/jsp/MainCal.jsp");
	        dispatcher.forward(request, response);
		}else {
			request.setAttribute("result","USERNAMEかPASSWORDが違います。");
			ServletContext context = this.getServletContext();
	        RequestDispatcher dispatcher = context.getRequestDispatcher("/jsp/Login.jsp");
	        dispatcher.forward(request, response);
	}

}

}