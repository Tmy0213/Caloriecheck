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
 * Servlet implementation class UpdateDsp
 */
@WebServlet("/UpdateDsp")
public class UpdateDsp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDsp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		CalorieDao cd = new CalorieDao();
		String chk = request.getParameter("chk");
		List<CalorieDto> list = new ArrayList<CalorieDto>();
		list = cd.getId(chk);
		request.setAttribute("dbdata", list);
		ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/jsp/Updata.jsp");
        dispatcher.forward(request, response);



	}

}
