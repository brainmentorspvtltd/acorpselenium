package com.brainmentors.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.brainmentors.dto.User;
import com.brainmentors.utils.DBConnection;
import com.brainmentors.utils.QueryConstants;

public class UserDAO {
	private static Logger logger = Logger.getLogger(UserDAO.class);
	
	public ArrayList<User> getUsers() throws ClassNotFoundException, SQLException {
		logger.debug("Inside getusers");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<User> users = new ArrayList<>();
		try {
			// Connection Build
			con = DBConnection.getConnection();
			// Prepare a Query
			pstmt = con.prepareStatement(QueryConstants.USER_SQL);
			// Execution of Query and Store the Result in ResultSet
			rs = pstmt.executeQuery();
			// rs.next() checking row is present in a result or not.
			while(rs.next()) {
				String userid = rs.getString("userid"); // getting the column and store it in  a variable
				String password = rs.getString("password");
				User user = new User(); // create an empty object
				user.setUserid(userid); // filling the object
				user.setPassword(password);
				users.add(user); // after filling the object , store the object in a arraylist
			}
			logger.debug("After Fetching the records "+users);
		}
		finally {
			// Resources Close
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
			logger.debug("Resources Closed SuccessFully");
		}
		return users;
	}

}
