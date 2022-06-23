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
 * Servlet implementation class SearchCalbtn
 */
@WebServlet("/SearchCalbtn")
public class SearchCalbtn extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCalbtn() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF8");
		String foodId = request.getParameter("foodid");
		List<CalorieDto> list = new ArrayList<CalorieDto>();
		CalorieDao cd = new CalorieDao();
		list = cd.getId(foodId);
		request.setAttribute("dbdata", list);
		ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/jsp/MainCal.jsp");
        dispatcher.forward(request, response);
	}
}

