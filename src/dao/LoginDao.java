package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import dto.LoginDto;

public class LoginDao extends HttpServlet{
	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;

	String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "postgres";


public void startDB() {
	try {
		Class.forName("org.postgresql.Driver");

	} catch (ClassNotFoundException e1) {
		e1.getMessage();
	}
}

public List<LoginDto> Loginchk(HttpServletRequest request){
	startDB();
	try {
		request.setCharacterEncoding("UTF-8");
	} catch (UnsupportedEncodingException e1) {
		e1.printStackTrace();
	}

	String username = request.getParameter("user");
	String pass = request.getParameter("pass");

	try {
		conn = DriverManager.getConnection(url, user, password);
		stmt = conn.createStatement();
		String login = "SELECT * FROM Login ";
		login = login + "where username ='" + username +"' and pass ='" + pass+"'";
		rset = stmt.executeQuery(login);
	     List<LoginDto> list = new ArrayList<LoginDto>();

		while(rset.next()){
			if(rset.getString("username").equals(username) && rset.getString("pass").equals(pass)) {
				list.add(new LoginDto(rset.getString("username"),rset.getString("pass")));
				return list;
			}else {
				return null;
			}

		}
	} catch (SQLException e) {
		e.getMessage();
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
}

