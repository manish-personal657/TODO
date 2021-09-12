

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.nio.file.Paths;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Servlet implementation class SaveDetail
 */
@WebServlet("/SaveDetail")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class SaveDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name;String email;String mobile;String pass;
		// TODO Auto-generated method stub
		name= request.getParameter("name");
		email= request.getParameter("email");
		mobile= request.getParameter("mobile");
		pass= request.getParameter("pass");
		Part filePart = request.getPart("file");
		String cdate=null;
		String myfile=null;
		String paths="C:\\Users\\ManishKumar\\OneDrive - Akal Information Systems Limited\\Documents\\uploads\\";
        String fileName = filePart.getSubmittedFileName(); 
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        cdate=formatter.format(date);
		double random= Math.random() * (9999+1000 );

        myfile=fileName+random;
        InputStream is = filePart.getInputStream();

        Files.copy(is, Paths.get(paths + myfile),
                StandardCopyOption.REPLACE_EXISTING);
       
		 try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			 try {
				Connection  conn =
				 	       DriverManager.getConnection("jdbc:mysql://localhost/unnati","root","");
				if (conn != null) {
					System.out.println("connected");
					
					double randomNum= Math.random() * ( 1000 - 9999 );

					String sql="INSERT INTO user VALUES("+randomNum+",'"+name+"','"+email+"','"+mobile+"','"+pass+"','"+myfile+"')";
					System.out.println(sql);
					//System.exit(0);
					java.sql.PreparedStatement st = conn 
							.prepareStatement(sql);
					int count=st.executeUpdate(); 
					
					if (count > 0) {
						response.sendRedirect("/TODO/Register");

						}
						
					System.out.println("connected"+count);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} System.out.println("loaded");
        		response.getWriter().append("Check form data name: "+name+"\n"+email+"\n"+mobile+"\n"+pass+"\n").append(request.getContextPath());
	}

	private void If(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
