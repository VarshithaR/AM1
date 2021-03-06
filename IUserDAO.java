package com.cg.asset.dao;

import java.util.ArrayList;

import com.cg.asset.bean.AssetIMBean;
import com.cg.asset.exception.UserException;

public interface IUserDAO {
	public int raiseAsset(int eno,int assetId) throws UserException;
	//public int checkAsset();
	public ArrayList<AssetIMBean> displayAssetInventory() throws UserException;
	public int returnReqid(int assetid) throws UserException;
	public String validateReqId(int enumber,int allocreqid) throws UserException;
}
