package com.cg.asset.service;

import com.cg.asset.dao.AdminDAO;
import com.cg.asset.dao.IAdminDAO;
import com.cg.asset.bean.AssetIMBean;

public class AdminService implements IAdminService {
    
   IAdminDAO admin1=new AdminDAO();
   IAdminDAO admin2=new AdminDAO();
	
	
	public int addAsset(AssetIMBean bean1) {
		
		return admin1.addAsset(bean1);
	}

	@Override
	public int modifyAsset(AssetIMBean bean2) {
		
		return admin2.modifyAsset(bean2);
	}

	@Override
	public int displayAsset() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int displayInventory() {
		
		return admin1.displayInventory();
		
	
	}

}
