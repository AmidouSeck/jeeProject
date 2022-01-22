package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Albums;
import beans.Images;
import dao.AlbumDao;
import dao.ImageDao;

/**
 * Servlet implementation class AddImage
 */
@WebServlet("/addImage")
public class AddImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String album_id;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		album_id = request.getParameter("id");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath = "webapp\\images\\";
		LocalDate date = java.time.LocalDate.now();  
		//String id = request.getParameter("id");
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		double hauteur = Double.parseDouble(request.getParameter("hauteur"));
		double largeur = Double.parseDouble(request.getParameter("largeur"));
		String fichier = request.getParameter("fichier");
		//int id_album = Integer.parseInt(album_id);
		String dateMiseAJour = date.toString();
		String dateCreation = date.toString();
		if(titre != null ) {
			Images image = new Images( 5, titre, description,fichier, hauteur, largeur,dateCreation, dateMiseAJour);
			ImageDao.ajouter(image);
		}
		response.sendRedirect(request.getContextPath()+"/albums");
	}

}
