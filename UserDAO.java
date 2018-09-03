package com.cg.asset.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.asset.bean.AssetIMBean;
import com.cg.asset.exception.UserException;

public class UserDAO implements IUserDAO {
	Connection conn=null;
	int insertsuccess=0;
	public int raiseAsset(int eno,int assetId)throws UserException {
       try {
			conn=DBUtil.establishConnection();
			PreparedStatement pstmt=conn.prepareStatement(IQueryMapper.EMPLOYEEQUERY);
			pstmt.setInt(1,eno);
			ResultSet rs=pstmt.executeQuery();
		    rs.next();
		    int empid=rs.getInt(1);
			if(empid==eno)
			{
				PreparedStatement pstmt1=conn.prepareStatement(IQueryMapper.ALLOCINSERTQUERY);
				pstmt1.setInt(1,assetId);
				pstmt1.setInt(2,eno);
				insertsuccess=pstmt1.executeUpdate();
			}
			else
			{
				System.err.println("Employee ID is invalid");
			}
		 }
			catch (SQLException e) {
		   throw new UserException("Invalid details");
			//e.printStackTrace();
		}
		return insertsuccess;
	}

	
	/*@Override
	public int checkAsset() {
		// TODO Auto-generated method stub
		return 0;
	}
*/
	@Override
	public ArrayList<AssetIMBean> displayAssetInventory() throws UserException{
		ArrayList<AssetIMBean> displayInventory=new ArrayList();
		try {
			Connection conn=DBUtil.establishConnection();
			PreparedStatement pstmt=conn.prepareStatement(IQueryMapper.DISPLAYINVQUERY);
	        ResultSet rs=pstmt.executeQuery();
	        while(rs.next())
	       {
	            int assetid=rs.getInt(1);
	            String assetname=rs.getString(2);
	            AssetIMBean display=new AssetIMBean();
	            display.setAssetId(assetid);
	            display.setAssetName(assetname);
	            displayInventory.add(display);
	       }
		
		
		
		
		} catch (SQLException e) {
		
			throw new UserException("Unable to display inventory at this moment");
		}
		catch(NullPointerException e){
		throw new UserException("Inventory is Empty");
		}
		return displayInventory;
	}


	@Override
	public int returnReqid(int assetid)throws UserException {
		int reqid=0;
		try{
		conn=DBUtil.establishConnection();
		PreparedStatement pstmt3=conn.prepareStatement(IQueryMapper.IDRETURNQUERY);
		pstmt3.setInt(1,assetid);
		ResultSet rs1=pstmt3.executeQuery();
		rs1.next();
		reqid=rs1.getInt(1);
		
		}
		catch (SQLException e) {
			System.err.println("Asset ID is invalid");
			
		
		}
		return reqid;
	}


	@Override
	public String validateReqId(int enumber, int allocreqid) throws UserException {
		String status="";
		try{
			conn=DBUtil.establishConnection();
			PreparedStatement pstmt4=conn.prepareStatement(IQueryMapper.VALIDATERIDQUERY);
			pstmt4.setInt(1,allocreqid);
			pstmt4.setInt(2,enumber);
		    ResultSet rs1=pstmt4.executeQuery();
		    rs1.next();
		    int allocationid=rs1.getInt(1);
		    int employeenum=rs1.getInt(2);
		    if(allocationid==allocreqid && employeenum==enumber)
		    {
		    	PreparedStatement pstmt=conn.prepareStatement(IQueryMapper.STATUSQUERY);
		    	pstmt.setInt(1, allocreqid);
		    	ResultSet rs=pstmt.executeQuery();
		    	rs.next();
		    	status=rs.getString(1);
		    }
		}  
		    catch (SQLException e) {
		       throw new UserException("Check EmployeeID and Request ID again");
		  
		}
		  catch(NullPointerException e)
		{
			  throw new UserException("No allocations exist");
		}
	
		return status;

	}
}

