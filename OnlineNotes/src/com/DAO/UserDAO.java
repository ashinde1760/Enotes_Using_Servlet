package com.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Servlet.AddNotes;
import com.User.Notes;
import com.User.UserDetails;

public class UserDAO {

	public Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addUser(UserDetails ud) {
		boolean result = false;
		try {
			String query = "insert into user(name,email,password) values(?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, ud.getName());
			stmt.setString(2, ud.getEmail());
			stmt.setString(3, ud.getPassword());
			int i = stmt.executeUpdate();

			if (i == 1) {
				result = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	public UserDetails loginUser(UserDetails ud) {
		UserDetails user = null;

		try {
			String query = "select * from user where email=? and password=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, ud.getEmail());
			stmt.setString(2, ud.getPassword());
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				user = new UserDetails();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean addNotes(String title, String content, String uid) {
		boolean result = false;

		try {
			String query = "insert into notes(title,content,uid) values(?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setString(3, uid);
			int i = stmt.executeUpdate();

			if (i == 1) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Notes> getData(int id)
	{
		List<Notes> list= new ArrayList<Notes>(); 
		Notes nt;
		try {
			
				String query="select * from notes where uid=? order by id DESC";
				PreparedStatement stmt=conn.prepareStatement(query);
				stmt.setInt(1,id);
				ResultSet rs=stmt.executeQuery();
				
				while(rs.next())
				{
					nt=new Notes();
					nt.setId(rs.getInt(1));
					nt.setTitle(rs.getString(2));
					nt.setContent(rs.getString(3));
					nt.setDate(rs.getTimestamp(4));
					list.add(nt);
				}
					
		} catch (Exception e) {
			
		}
		

	return list;
}
	
	public Notes getDataById(int note_id)
	{
		Notes nt=null;
		try {
			String query="select * from notes where id=?";
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setInt(1, note_id);
			
			ResultSet rs=stmt.executeQuery();
			
			if(rs.next())
			{
				nt=new Notes();
				nt.setId(rs.getInt(1));
				nt.setTitle(rs.getString(2));
				nt.setContent (rs.getString(3));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nt;
	}
	
	public boolean updateNotes(int id,String title,String content)
	{
		boolean result=false;
		try {
			
			String query="update notes set title=? , content=? where id=?";
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setInt(3, id);
			
			int i=stmt.executeUpdate();
			if(i==1)
			{
				result=true; 
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public boolean deleteNote(int id)
	{
		boolean result=false;
		try {
			
			String query="delete from notes where id=?";
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setInt(1, id);
			int i=stmt.executeUpdate();
			if(i==1)
			{
				result=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean forgetPassword(String email,String lpass) {
		boolean result=false;
		
		try {
			String query = "select * from user where email=? and password=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, email);
			stmt.setString(2, lpass);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result=true;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public boolean changePassword(String email,String npass) {
		boolean result=false;
		
		try {
			String query = "update user set password=? where email=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, npass);
			stmt.setString(2, email);
			int i=stmt.executeUpdate();

			if (i==1) {
				result=true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}