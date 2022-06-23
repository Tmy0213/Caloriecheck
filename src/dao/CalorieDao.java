package dao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import dto.CalorieDto;

public class CalorieDao extends HttpServlet{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";


	public void startDB() {
		//ドライバの準備
		try {
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e1) {
			e1.getMessage();
		}

	}
/*
 * 料理名検索
 */
	public List<CalorieDto> getName(String foodName) {
		startDB();

        try{
        	//データべース接続
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            //SQL文の設定
            String sql = "SELECT * FROM Calorie";
            sql = sql + " WHERE food_name LIKE '%"+ foodName +"%'";
            sql = sql +" ORDER BY food_id ASC";
            //SQｌ文実行
            rset = stmt.executeQuery(sql);

            List<CalorieDto> list = new ArrayList<CalorieDto>();

            while(rset.next()){
            	//一致するものをlistに追加
            	list.add(new CalorieDto(rset.getInt("food_id"),rset.getString("food_name"),rset.getInt("food_calorie"),rset.getString("food_pfc"),rset.getString("food_img"),rset.getString("registar")));
            }
           return list;
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
		return null;

	}
	/*
	 * ID検索
	 *
	 */
	public List<CalorieDto> getId(String foodId) {
		startDB();

        try{
        	//データベース接続
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            //SQL文設定
            String sql = "SELECT * FROM Calorie";
            sql = sql + " WHERE food_id = " +  foodId ;
            //SQL文実行
            rset = stmt.executeQuery(sql);

            List<CalorieDto> list = new ArrayList<CalorieDto>();

            while(rset.next()){
            	//一致したらlistに追加
            	list.add(new CalorieDto(rset.getInt("food_id"),rset.getString("food_name"),rset.getInt("food_calorie"),rset.getString("food_pfc"),rset.getString("food_img"),rset.getString("registar")));
            }
           return list;
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
		return null;
	}
	/*
	 * 削除実行
	 *
	 */
	public List<CalorieDto> delete(String check){
		startDB();
		try{
			//データベースへの接続
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            //SQL文の設定
            String sql = "DELETE FROM calorie ";
            sql = sql + " WHERE food_id = " +  check ;
            //SQL文実行
            rset = stmt.executeQuery(sql);
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
		return null;
	}
	/*
	 * 全表示
	 */

	public List<CalorieDto> selectAll(){
		startDB();

        try{
        	//データベース接続
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            //SQL文設定
            String sql = "SELECT * FROM Calorie ORDER BY food_id ASC";
            //SQL実行
            rset = stmt.executeQuery(sql);

            List<CalorieDto> list = new ArrayList<CalorieDto>();

            while(rset.next()){
            	//全データをlistに追加
            	list.add(new CalorieDto(rset.getInt("food_id"),rset.getString("food_name"),rset.getInt("food_calorie"),rset.getString("food_pfc"),rset.getString("food_img"),rset.getString("registar")));
            }
           return list;
        }
        catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(rset != null)rset.close();
                if(stmt != null)stmt.close();
                if(conn != null)conn.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
		return null;
	}

	/*
	 * 新規登録
	 */
	public List<CalorieDto> Insert(HttpServletRequest request) throws IOException, ServletException{
		startDB();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		int Id =Integer.parseInt(request.getParameter("food_id"));
		String name = request.getParameter("food_name");
		String cal =request.getParameter("food_calorie");
		String pfc = request.getParameter("food_pfc");
		String pfc2 = request.getParameter("food_pfc2");
		String pfc3 = request.getParameter("food_pfc3");
		String pfcall = pfc +"/"+ pfc2 + "/"+ pfc3;
		Part part = request.getPart("food_img");
		String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		String date = (String) request.getParameter("registar");

		final String SQL = "insert into calorie(food_id, food_name, food_calorie, food_pfc, food_img, registar) VALUES(?,?,?,?,?,?)";

		        try(Connection conn =
		                DriverManager.getConnection(url, user, password)){

		            conn.setAutoCommit(false);

		            try(PreparedStatement ps = conn.prepareStatement(SQL)){
		                ps.setInt(1,Id);
		                ps.setString(2,name);
		                ps.setString(3,cal);
		                ps.setString(4,pfcall);
		                ps.setString(5,filename);
		                ps.setString(6,date);
		                ps.executeUpdate();
		                conn.commit();
		            } catch (Exception e) {
		                conn.rollback();
		                System.out.println("rollback");
		                throw e;
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }finally {
		            System.out.println("処理が完了しました");
		        }
				return null;
	}

	/*
	 * 更新
	 */
	public List<CalorieDto> Update(HttpServletRequest request) throws IOException, ServletException{
		startDB();
		boolean bool = false;
		try {
			//文字化け防止
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		int Id =Integer.parseInt(request.getParameter("food_id"));
		String name = request.getParameter("food_name");
		String cal = request.getParameter("food_calorie");
		String pfc = request.getParameter("food_pfc");
		//Part part = request.getPart("food_img");
		//String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		//String img =request.getParameter("food_img");
		String date =request.getParameter("registar");

		PreparedStatement ps;

		        try(Connection conn =
		                DriverManager.getConnection(url, user, password)){

		            //conn.setAutoCommit(false);

		        	if(Id != 0) {
		        		//料理名更新
		            	if(name != "") {
		            		String SQL1 ="UPDATE calorie set food_name = ? WHERE food_id = ?";
		            		ps = conn.prepareStatement(SQL1);
		            		ps.setString(1,name);
		            		ps.setInt(2,Id );
		            		ps.executeUpdate();
		            	}
		            	//カロリー更新
		            	if(cal != "") {
		            		String SQL2= "UPDATE calorie set food_calorie = ? WHERE food_id = ?";
		            		ps = conn.prepareStatement(SQL2);
		            		ps.setString(1,cal);
		            		ps.setInt(2,Id );
		            		ps.executeUpdate();
		            	}
		            	//PFC更新
		            	if(pfc != "") {
		            		String SQL3 = "UPDATE calorie set food_pfc = ? WHERE food_id = ?";
		            		ps = conn.prepareStatement(SQL3);
		            		ps.setString(1,pfc);
		            		ps.setInt(2,Id );
		            		ps.executeUpdate();
		            	}
		            	//img更新
		            	/*if(img != "") {
		            		String SQL4 = "UPDATE calorie set food_img = ? WHERE food_id = ?";
		            		ps = conn.prepareStatement(SQL4);
		            		ps.setString(1,img);
		            		ps.setInt(2,Id );
		            		ps.executeUpdate();
		            	}*/
		            	//登録日更新
		            	if(date != "") {
		            		String SQL5 = "UPDATE calorie set registar = ? WHERE food_id = ?";
		            		ps = conn.prepareStatement(SQL5);
		            		ps.setString(1,date);
		            		ps.setInt(2,Id );
		            		ps.executeUpdate();
		            	}
		        	}
		        } catch (Exception e) {
		            e.printStackTrace();
		        }finally {
		            System.out.println("処理が完了しました");
		        }
				return null;
	}

}

