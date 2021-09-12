

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    @SuppressWarnings("deprecation")
	public Register() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {
	            // The newInstance() call is a work around for some
	            // broken Java implementations

	            Class.forName("com.mysql.jdbc.Driver").newInstance(); System.out.println("loaded");
	            Connection  conn =
	            	       DriverManager.getConnection("jdbc:mysql://localhost/unnati","root","");
	            if (conn != null) {
	            	// Execute SQL query
	                Statement stmt = (Statement) conn.createStatement();
	                String sql;
	                sql = "SELECT * FROM user";
	                ResultSet rs = (ResultSet) stmt.executeQuery(sql);
	             // Extract data from result set
	            	System.out.println("connected");
	            	int i=0;
	                while(rs.next()){
	                	i++;
	                   //Retrieve by column name
	                   String name = rs.getString("name");
	                   String email = rs.getString("email");
	                   String mobile = rs.getString("mobile");
	                   String pass = rs.getString("password");
	                   String photo = rs.getString("password");

	                   System.out.println(i);
	                   System.out.println(name);
	                   System.out.println(email);
	                   System.out.println(mobile);
	                   System.out.println(pass);

	                   
	   	    		response.getWriter().append("<table style='width:100%'>").append(
	   	    				"<tr><td>"+i+"</td><td>"+name+"</td><td>"+email+"</td><td>"+mobile+"</td><td>"+pass+"</td>"
	   	    						+ "<td><img src='C:\\Users\\ManishKumar\\OneDrive - Akal Information Systems Limited\\Documents\\uploads\\"+photo+"'></td></tr>"
	   	    				).append("</table>");



	                }
	               
	            }

	        } catch (Exception ex) {
	            // handle the error
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
