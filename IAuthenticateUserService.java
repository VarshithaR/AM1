package com.cg.asset.service;

import com.cg.asset.bean.UserAuthenBean;
import com.cg.asset.exception.AdminException;

public interface IAuthenticateUserService {
	
	//public int authenticateUser(UserAuthen user);

	public int authenticateUser(String user, String password, int option) throws AdminException;
    //public int addAsset(int assetId);
}
