package com.cg.asset.dao;

import com.cg.asset.bean.AssetIMBean;

public interface IAdminDAO {
	public int displayInventory();
	public int addAsset(AssetIMBean bean1);
	public int modifyAsset(AssetIMBean bean2);
	public int displayAsset();

}
