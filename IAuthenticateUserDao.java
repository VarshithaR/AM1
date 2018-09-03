package com.cg.asset.dao;

import com.cg.asset.bean.UserAuthenBean;
import com.cg.asset.exception.AdminException;

public interface IAuthenticateUserDao {
	public int authenticateUser(String user,String password,int option) throws AdminException;
    //public int addAsset(int assetid);
	

}
