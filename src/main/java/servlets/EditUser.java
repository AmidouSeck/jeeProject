package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Users;
import dao.UserDao;



/**
 * Servlet implementation class EditUser
 */
@WebServlet("/editUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id != null && id.matches("[0-9]+")) {
			
			try {
				Users utilisateur = UserDao.find(Integer.parseInt(id));
			 if(utilisateur != null) {
				 request.setAttribute("user",utilisateur);
				 this.getServletContext().getRequestDispatcher("/WEB-INF/editUser.jsp").forward(request, response);
				 return;
			 }
			 } catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		response.sendRedirect(request.getContextPath()+"/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nom = request.getParameter("firstName");
		String prenom = request.getParameter("lastName");
		String login = request.getParameter("login");
		String password = request.getParameter("passWord");
		String role = request.getParameter("role");
		if(id != null && id.matches("[0-9]+")) {
			Users utilisateur = new Users(Integer.parseInt(id), nom, prenom, login, password, role);
			try {
				UserDao.edit(utilisateur);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect(request.getContextPath()+"/user");
	}

}
