package pack;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.CalorieDao;
import dto.CalorieDto;

/**
 * Servlet implementation class InsertCalbtn
 */
@WebServlet("/InsertCalbtn")
@MultipartConfig
public class InsertCalbtn extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCalbtn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		//インスタンス生成
		CalorieDao cd = new CalorieDao();
		//imgをPartとして受け取る
		Part part = request.getPart("food_img");
		//ファイル名取得
		String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		//アップロードするフォルダ
		String path = getServletContext().getRealPath("/upload");
		//保存先の確認
		System.out.print(path);
		//フォルダへの書き込み
		part.write(path+File.separator+filename);
		cd.Insert(request);
		List<CalorieDto> list = new ArrayList<CalorieDto>();
		list = cd.selectAll();
		request.setAttribute("dbdata", list);
		request.setAttribute("filename", filename);



		ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/jsp/MainCal.jsp");
        dispatcher.forward(request, response);
	}

}
