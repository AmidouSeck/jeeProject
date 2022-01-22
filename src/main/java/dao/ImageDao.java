package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Albums;
import beans.Images;
import jdbc.Database;
public class ImageDao {
	
	public static int lastId = 0;
	
	public static void ajouter(Images image) {
		Connection conn = Database.getConnection();
		try {
			//System.out.println("ALL VALUES: "+album.getTheme()+"--"+album.getVisibility()+"--"+album.getId_proprietaire()+"--"+album.getCover());
			PreparedStatement ps = conn.prepareStatement("insert into images values (?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, image.getId());
			ps.setString(2, image.getTitre());
			ps.setString(3, image.getDescription());
			ps.setDouble(4, image.getHauteur());
			ps.setDouble(5, image.getLargeur());
			ps.setString(6, image.getDateCreation());
			ps.setString(7, image.getDateMiseAjour());
			ps.setString(8, image.getFichier());
			ps.setInt(9, image.getId_album());
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	// la liste des images d'un album
	public static ArrayList<Images> getImages(int id){
		
		Connection conn = Database.getConnection();
		ArrayList<Images> images = new ArrayList<Images>();
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from images where id_album = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				Images image = new Images();
				image.setId(rs.getInt("id"));
				image.setId_album(rs.getInt("id_album"));
				image.setTitre(rs.getString("titre"));
				image.setDescription(rs.getString("description"));
				image.setFichier(rs.getString("fichier"));
				image.setHauteur(rs.getDouble("hauteur"));
				image.setLargeur(rs.getDouble("largeur"));
				image.setDateCreation(rs.getString("dateCreation"));
				image.setDateMiseAjour(rs.getString("dateMiseAjour"));
				
				images.add(image);
			}
			if(images.size() == 0) {
				images = null;
			}
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return images;	
	}
	
}
