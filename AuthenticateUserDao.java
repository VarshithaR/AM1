package com.cg.asset.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.asset.bean.UserAuthenBean;
import com.cg.asset.exception.AdminException;

public class AuthenticateUserDao implements IAuthenticateUserDao {

    String type="";
	Connection conn=null;
	int status=0;
	public int authenticateUser(String user, String password, int option) throws AdminException {
		if(option==1)
		{
			type="Admin";
		}
		else if(option==2)
		{
			type="Manager";
		}
		
	    	try {
				conn=DBUtil.establishConnection();
			
				PreparedStatement pstmt=conn.prepareStatement(IQueryMapper.LOGINQUERY);
				
				pstmt.setString(1,user);
				pstmt.setString(2,password);
				pstmt.setString(3,type);
				
				ResultSet rs=pstmt.executeQuery();
			    rs.next();
				String userid=rs.getString(1);
				String userpwd=rs.getString(2);
				String uType=rs.getString(3);
				if(user.equals(userid) && password.equals(userpwd) && uType.equals("Admin"))
				{
					status=1;
				}
				else if(user.equals(userid) && password.equals(userpwd) && uType.equals("Manager"))
				{
					status=2;
				}
				else
				{ 
					status=0;
				}
			
			} catch (SQLException e) {
		
				throw new AdminException("Incorrect user credentials");
			   	
			}
	    	catch(NullPointerException e)
	    	{
	    		throw new AdminException("UserAuthentication not successful");
	    	}
	    	return status;	
	}

}
