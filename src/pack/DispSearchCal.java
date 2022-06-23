package pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class DispSearchCal
 */
@WebServlet("/DispSearchCal")
public class DispSearchCal extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispSearchCal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//getDB(request);

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
		ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/jsp/MainCal.jsp");
        dispatcher.forward(request, response);
	}
/*	private void getDB(HttpServletRequest request) {
		try {
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e1) {
			//e1.printStackTrace();
			e1.getMessage();
		}

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";


        try{

            conn = DriverManager.getConnection(url, user, password);


           // conn.setAutoCommit(false);

            stmt = conn.createStatement();
            String sql = "SELECT * FROM Calorie ORDER BY food_id ASC";
            rset = stmt.executeQuery(sql);

            List<DataBean> list = new ArrayList<DataBean>();


            while(rset.next()){
            	list.add(new DataBean(rset.getInt("food_id"),rset.getString("food_name"),rset.getInt("food_calorie"),rset.getInt("food_pfc"),rset.getString("food_img"),rset.getString("registar")));
            }
            request.setAttribute("dbdata", list);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                if(rset != null)rset.close();
                if(stmt != null)stmt.close();
                if(conn != null)conn.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }

        }

	}*/
}
