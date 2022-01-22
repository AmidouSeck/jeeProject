package services;

import javax.servlet.http.HttpServletRequest;

import beans.Albums;

import dao.AlbumDao;


//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;

import java.util.HashMap;
import java.util.Map;

public class AddAlbumService {
	private static final String CHAMP_THEME = "theme";
	private static final String CHAMP_VISIBILITY = "visibility";
	private static final String CHAMP_USERID = "id";
	private static final String CHAMP_COVER = "cover";
	
	
	private boolean status ;
	private String statusMessage;
	private Albums album;
	private HttpServletRequest request;
	private Map<String, String> erreurs;
	
	public AddAlbumService(HttpServletRequest request) {
		this.status = false;
		this.request = request;
		this.erreurs = new HashMap<>();
	}
	
	public boolean ajouter() throws SQLException {
		
		String theme = getParameter(CHAMP_THEME);
		String visibility = getParameter(CHAMP_VISIBILITY);
		int id = 1;//Integer.parseInt(getParameter(CHAMP_USERID));
		String cover = getParameter(CHAMP_COVER);
		
		album = new Albums(id,theme,visibility,cover);
		//System.out.println(user);
		//IUserMetier metier = new UserMetierImpl();
		
		validerChamps(CHAMP_THEME, CHAMP_VISIBILITY, CHAMP_USERID,CHAMP_COVER);
		
		if(erreurs.isEmpty()) {
			AlbumDao.ajouter(album);
			return true;
		}
		return false;
	}
	
	private String getParameter(String parametre) {
		
		String valeur = request.getParameter(parametre);
		
		if(valeur == null || valeur.trim().isEmpty()) {
			return null;
		}
		return valeur.trim();
	}
	
	private void validerChamps(String ...champs) {
		
		for (String champ : champs) {
			if(getParameter(champ) == null) {
				
				erreurs.put(champ, "Vous devez renseigner ce champ");
			}
		}
	}
	
	
	public boolean getStatus() {
		return status;
	}


	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String status) {
		this.statusMessage = status;
	}


	public Map<String, String> getErreurs() {
		return erreurs;
	}
	
}
