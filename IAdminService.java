package com.cg.asset.service;

import com.cg.asset.bean.AssetIMBean;

public interface IAdminService {
	public int displayInventory();
	public int addAsset(AssetIMBean bean1);
	public int modifyAsset(AssetIMBean bean2);
	public int displayAsset();

}
