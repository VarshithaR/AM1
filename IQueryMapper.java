package com.cg.asset.dao;

public interface IQueryMapper {
 public final static String LOGINQUERY="SELECT userid,userpassword,usertype from User_masters where userid=?  and userpassword=? and usertype=?";
 public final static String INSERTQUERY="INSERT into Asset values(genAssetID.nextval,?,?,?,?)";
 public final static String MODIFYQUERY="UPDATE Asset set assetname=?,assetdesc=?,quantity=?,status=? where assetid=?";
 public final static String DISPLAYINVQUERY="SELECT assetId, assetname from Asset";	
 public final static String EMPLOYEEQUERY="SELECT empno from Employees where empno=?";
 public final static String ALLOCINSERTQUERY="INSERT into Asset_Allocation values(reqid_seq.nextval,?,?,SYSDATE,SYSDATE+2,'Pending')"; 
 public final static String IDRETURNQUERY="SELECT allocationid from Asset_Allocation where assetid=?";
 public final static String VALIDATERIDQUERY="SELECT allocationid,empno from Asset_Allocation where allocationid=? and empno=?";
 public final static String STATUSQUERY="SELECT request_status from Asset_Allocation where allocationid=?";
}


/*assetid number primary key,assetname varchar2(25),assetdesc varchar2(25),quantity number,status varchar2(15));*/
