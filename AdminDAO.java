package com.cg.asset.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.asset.bean.AssetIMBean;
import com.cg.asset.dao.DBUtil;
import com.cg.asset.dao.IQueryMapper;

public class AdminDAO implements IAdminDAO {
	int insertsuccess=0;
	int modsuccess=0;
	@Override
	public int addAsset(AssetIMBean bean1) {
		Connection conn=null;
		try {
			conn=DBUtil.establishConnection();
			PreparedStatement pstmt=conn.prepareStatement(IQueryMapper.INSERTQUERY);
			//pstmt.setInt(1,bean1.getAssetId());
			pstmt.setString(1, bean1.getAssetName());
			pstmt.setString(2, bean1.getAssetDesc());
            pstmt.setInt(3,bean1.getAssetQuantity());
            pstmt.setString(4,bean1.getAssetStatus());
            insertsuccess=pstmt.executeUpdate();
           // System.out.println(insertsuccess);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	    return insertsuccess;
	}

	@Override
	public int modifyAsset(AssetIMBean bean2) {
		Connection conn=null;
		try {
			conn=DBUtil.establishConnection();
			PreparedStatement pstmt=conn.prepareStatement(IQueryMapper.MODIFYQUERY);
			pstmt.setString(1, bean2.getAssetName());
			pstmt.setString(2, bean2.getAssetDesc());
            pstmt.setInt(3,bean2.getAssetQuantity());
            pstmt.setString(4,bean2.getAssetStatus());
            pstmt.setInt(5,bean2.getAssetId());
            modsuccess=pstmt.executeUpdate();
		    
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return modsuccess;
	}

	@Override
	public int displayAsset() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int displayInventory() {
		
		
		
		
		return 0;
		
	}

}
