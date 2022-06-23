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

import dao.CalorieDao;
import dto.CalorieDto;

/**
 * Servlet implementation class DspUpdate
 */
@WebServlet("/DspUpdate")
public class DspUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DspUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	// TODO Auto-generated method stub
	//getDB(request);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CalorieDto> list = new ArrayList<CalorieDto>();
		CalorieDao cd = new CalorieDao();
		list = cd.getId("chk");
		request.setAttribute("dbdata", list);
		ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/jsp/Updata.jsp");
        dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/jsp/Updata.jsp");
        dispatcher.forward(request, response);
	}

}
