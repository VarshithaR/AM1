package com.cg.asset.service;

import java.util.ArrayList;

import com.cg.asset.bean.AssetIMBean;
import com.cg.asset.dao.IUserDAO;
import com.cg.asset.dao.UserDAO;
import com.cg.asset.exception.UserException;

public class UserService implements IUserService {
    IUserDAO user1=new UserDAO();
    IUserDAO user2=new UserDAO();
    //IUserDAO user=new UserDAO();
    
	@Override
	public int raiseAsset(int eno,int assetId) throws UserException{

		return user2.raiseAsset(eno,assetId);
	}

	/*@Override
	public int checkAsset() {
		// TODO Auto-generated method stub
		return 0;
	}
*/
	@Override
	public ArrayList<AssetIMBean> displayAssetInventory() throws UserException {
	
		return user2.displayAssetInventory();
	}

	@Override
	public int returnReqid(int assetid) throws UserException {
		
		return user1.returnReqid(assetid);
	}

	@Override
	public String validateReqId(int enumber, int allocreqid) throws UserException {
		return user1.validateReqId(enumber,allocreqid);
		
	}

}
