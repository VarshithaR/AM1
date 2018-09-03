package com.cg.asset.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.asset.bean.AssetIMBean;
import com.cg.asset.exception.AdminException;
import com.cg.asset.exception.UserException;
import com.cg.asset.service.AdminService;
//import com.cg.asset.bean.UserAuthen;
import com.cg.asset.service.AuthenticateUserService;
import com.cg.asset.service.IAdminService;
import com.cg.asset.service.IAuthenticateUserService;
import com.cg.asset.service.IUserService;
import com.cg.asset.service.UserService;

public class User {
	static IAuthenticateUserService service=new AuthenticateUserService();
	static int option=0;
	static int choice=0;
	static int flag=0;
	static int flag1=0;

	public static void main(String[] args)throws AdminException, UserException {
		
		int a=0;
		Scanner scan=new Scanner(System.in);
        System.out.println("***********ASSET MANAGEMENT PORTAL*************");
        do{
        	
        	try
        	{
        	    a=0;
		        System.out.println("Please select the type of user");
		        System.out.println("1.Admin");
		        System.out.println("2.Manager");
		        option=scan.nextInt();
		        if(option<1 || option>2)
		        {
		        	System.out.println("Invalid option");
		        	System.out.println("Enter either 1 or 2");
		        	a=1;
		        }
		        else
		        {
		        		System.out.println("Enter your userid");
				        String user=scan.next();
				        System.out.println("Enter password");
				        String password=scan.next();
				        flag=service.authenticateUser(user,password,option);
				        if (flag==1)
				        {
				        	System.out.println("Logged in successfully as admin");
				        	
				        }
				        else if(flag==2)
				        {
				        	System.out.println("Logged in succesfully as Manager");
				        }
				
		        }
        	}
           catch(InputMismatchException e)
           {
                 //scan.nextLine();
         		 a=1;
         	     System.err.println("Check and re-enter the inputs");
         	    //scan.nextLine();
           }
           catch(AdminException e)
           {
        	   	a=1;
	        	System.err.println(e);
	        	 
           }
        	System.err.flush();
        	scan.nextLine();
        	
     }while(a==1); 
   /* System.err.flush();
    	scan.nextLine();*/
    	
        
        if(flag==1)
        {
        
        	System.out.println("1.Add a new asset");
        	System.out.println("2. Modify an asset");
        	System.out.println("3.Approve/Reject a request");
            choice=scan.nextInt();
            int a1=0;
            switch(choice)
            {
            
            case 1: {
            	do{
            		try{
		            	    a1=0;
		                    System.out.println("Enter the asset name");
		                    String aname=scan.next();
		                    System.out.println("Enter the description of the asset");
		                    String z=scan.nextLine();
		                    String adesc=scan.nextLine();
		                    //String[] a = input. nextLine(). split(" ");
		                    System.out.println("Enter the asset quantity");
		                    int aquantity=scan.nextInt();
		                    System.out.println("Enter the status(Available / Not Available)");
		                    String astatus=scan.next();
		                    AssetIMBean bean1=new AssetIMBean();
		                    // bean1.setAssetId(aid);
		                    bean1.setAssetName(aname);
		                    bean1.setAssetDesc(adesc);
		                    bean1.setAssetQuantity(aquantity);
		                    bean1.setAssetStatus(astatus);
		                     
		                    // AssetIMBean bean1=new AssetIMBean(aid,aname,adesc,astatus);
		                    IAdminService service1=new AdminService();
		                    int inssuccess=service1.addAsset(bean1);
		                    if(inssuccess==1)
		                    {
		                    	System.out.println("Asset details inserted successfully");
		                    }
		                    else
		                    {
		                    	System.out.println("Asset insertion failed");
		                    }
		            }
            		catch(InputMismatchException e){
	            		 scan.nextLine();
	            		 a1=1;
	            	     System.out.println("Check the datatype of inputs");
              }
            	
            	  catch(Exception e)
            	  {
            		  throw new AdminException("Asset insertion failure"); 
            	  }
            	  scan.nextLine();  
            }while(a1==1);
            	 
                   break;
            }       
            case 2: 
            	{
            		System.out.println("Enter the assetID");
            	    int aid1=scan.nextInt();
                    System.out.println("Enter the asset name");
                    String aname1=scan.next();
                    System.out.println("Enter the description of the asset");
                    String adesc1=scan.next();
                    System.out.println("Enter the asset quantity");
                    int aquantity1=scan.nextInt();
                    System.out.println("Enter the status(Available/Not Available");
                    String astatus1=scan.next();
                    AssetIMBean bean2=new AssetIMBean();
                    bean2.setAssetId(aid1);
                    bean2.setAssetName(aname1);
                    bean2.setAssetDesc(adesc1);
                    bean2.setAssetQuantity(aquantity1);
                    bean2.setAssetStatus(astatus1);
                    IAdminService service2=new AdminService();
                    int modsuccess=service2.modifyAsset(bean2);
                    if(modsuccess==1)
                    {
                    	System.out.println("Asset modified successfully");
                    }
                    else
                    {
                    	System.out.println("Asset modification failed");
                    }
                    break;
            }
            
          }
        }
    if(flag==2)
        {
        	System.out.println("Select one among the following options");
        	System.out.println("1.Raise a request for an asset");
        	System.out.println("2.View status of an asset request");
        	choice=scan.nextInt();
        	int a1=0;
        	int a3=0;
        	switch(choice)
        	{
        	case 1: 
        		{
        			IUserService service=new UserService();
        		    IUserService service1=new UserService();
        		    IUserService service2=new UserService();
        		    System.out.println("ASSET INVENTORY");
        		 
        	        ArrayList<AssetIMBean> displayInventory= service.displayAssetInventory();
        	       
        	        for(AssetIMBean disp:displayInventory)
        	        {
        	             System.out.println("Asset Id:" + disp.getAssetId()+" "+ "Asset Name:"+disp.getAssetName());
        	        }
        	        
        	        do{
                  	  	try{
	                  	  		a1=0;
				        	    System.out.println("Enter Employee number");
				        	    int eno=scan.nextInt();
				        	    System.out.println("Enter asset id with reference to the above displayed inventory");
				        	    int assetid=scan.nextInt();
				        	    int allocsuccess=service1.raiseAsset(eno,assetid);
				        	    if(allocsuccess==1){
		        	        		System.out.println("Request submitted successfully");
		        	        		int reqidreturn=service2.returnReqid(assetid);
		        	        		System.out.println("Your asset requisition Id is: "+ reqidreturn);
		        	                System.out.println("Please remember this for future reference");
	        	                
				        	    }
				        	    else{
				        	    	System.err.println("Request submission unsuccessful");
	        	        		}
        	        	
                  	  		}

                  	    catch(InputMismatchException e){
		                  		
		                  		a1=1;
		                  	    System.err.println("Check and re-enter the inputs");
                  	    }
                  	  	catch(UserException e)
                  	  	{
                  	  		System.err.println(e);
                  	  	}
                  	  scan.nextLine();
                 }while(a1==1); 
        	break;
        	}
        	case 2: 
        	{   
        		do{
                      try{
        				    a3=0;
	        				System.out.println("Enter employee no.");
			        		int enumber=scan.nextInt();
			        		System.out.println("Enter the Asset requisition ID");
			        		int allocreqid=scan.nextInt();
			        		IUserService service3=new UserService();
			        		String reqstatus=service3.validateReqId(enumber,allocreqid);
			        		if(reqstatus.equals("Pending||pending")||reqstatus.equals("Available||available"))
			        		{
			        			System.out.println("The status of asset requisition for the ID: "+allocreqid+" is "+"<<"+reqstatus+">>");
			        		}
        			   }
        			
        			catch(UserException e)
        			{
	        				a3=1;
	        				System.err.println(e);
        			}
        			catch(Exception e)
	        		{
	        				a3=1;
	        				System.err.println("Unable to process the request");
        			}
        			System.err.flush();
        		    scan.nextLine();
        	}while(a3==1);
        		/*System.err.flush();
    		    scan.nextLine();*/
        	break;
      }
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	        /*System.out.println("Please fill the asset requisition requirements");
        	        System.out.println("Enter employee ID");
        	        int eid=scan.nextInt();
        	        System.out.println("Enter the Asset ID");
        	        int assetId=scan.nextInt();
        	        System.out.println("Enter the number of assets required");
        	        int quantity=scan.nextInt();
        	        IUserService user=new UserService();
        	        flag1=user.raiseAsset(assetId,quantity);*/
        	        
        		
        	
        	
        
        
 
        
        
	

        }
	}
  }
}
