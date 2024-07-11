package com.edubridge.contactapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.contactapp.model.Contact;
import com.edubridge.contactapp.util.DBUtils;

public class ContactDaoImpl implements ContactDao {

	public int addContact(Contact c) {
		String INSERT = "insert into contact(name,email,mobile) values(?,?,?)";
		Connection con = DBUtils.getConnection();
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(INSERT);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setLong(3, c.getMobile());
			
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Contact> getAllContacts() {
		String SELECT = "select * from contact";
		Connection con = DBUtils.getConnection();
		List<Contact> contacts = new ArrayList<Contact>();		
		try {
			PreparedStatement ps = con.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Contact c = new Contact();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setMobile(rs.getLong("mobile"));				
				contacts.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contacts;
	}

	public Contact getContact(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateContact(Contact c) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteContact(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteAllContacts() {
		// TODO Auto-generated method stub

	}
}
