package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Users;
import jdbc.Database;

public class UserDao {
	
	public static int lastId = 1;
	private static ArrayList<Users> users = new ArrayList<Users>();
	
	// ajout d'un utilisateur
	public static void ajouter(Users u) {
		Connection conn = Database.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into users values (?,?,?,?,?,?)");
			
			ps.setInt(1, u.getId());
			ps.setString(2, u.getFirstName());
			ps.setString(3,u.getLastName());
			ps.setString(4,u.getLogin());
			ps.setString(5,u.getPassWord());
			ps.setString(6,u.getRole());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Users getUserByLogin(String login) {
		
		Users u = new Users();
		Connection conn = Database.getConnection();
		
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from users where login = ?");
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u.setId(rs.getInt("id"));
				u.setFirstName(rs.getString("firstName"));
				u.setLastName(rs.getString("lastName"));
				u.setLogin(rs.getString("login"));
				u.setPassWord(rs.getString("passWord"));
				u.setRole(rs.getString("role"));
			}
			else {
				u = null;
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
		
	}
	// la liste des utilisateur
	public static ArrayList<Users> getAll() {
		
		ArrayList<Users> listUser = new ArrayList<>();
		Connection conn = Database.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from users");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//Users u = new Users();
				
				int id = rs.getInt("id");
				String firstName = rs.getString("firstName");
				String lastName =rs.getString("lastName");
				String login = rs.getString("login");
				String passWord = rs.getString("passWord");
				String role = rs.getString("role");
				Users utilisateur = new Users(id, firstName, lastName, login, passWord, role);
				listUser.add(utilisateur);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  return  listUser;
	  
		
	}
	
	public static boolean remove(int id) throws SQLException {
		Users user = find(id);
		//utilisateurs.remove(user);
		//return true;
String sql = "DELETE FROM users where id = ?";
		
Connection conn = Database.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, user.getId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		return rowDeleted;	
	}
	
	public static Users find(int id) throws SQLException {
		users = (ArrayList<Users>) getAll();
		for (int i = 0; i < users.size(); i++) {
			if(id == users.get(i).getId()) {
				return users.get(i);
			}
		}
		return null;
	}
	
public static boolean edit(Users utilisateur) throws SQLException {
		
		String sql = "UPDATE utilisateur SET firstName = ?, lastName = ?, login = ?, passWord = ?, role = ?";
		sql += " WHERE id = ?";
		Connection conn = Database.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, utilisateur.getFirstName());
		statement.setString(2, utilisateur.getLastName());
		statement.setString(3, utilisateur.getLogin());
		statement.setString(4, utilisateur.getPassWord());
		statement.setString(5, utilisateur.getRole());
		statement.setInt(6, utilisateur.getId());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		return rowUpdated;
	}
	
}
