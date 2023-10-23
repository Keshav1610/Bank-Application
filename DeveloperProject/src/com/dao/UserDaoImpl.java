package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pojo.Account;
import com.pojo.User;
import com.utility.DBConnection;

public class UserDaoImpl implements UserDao,AccountDao{

	Connection conn=DBConnection.getConnect();
	PreparedStatement ps;
	ResultSet rs;
	User user;
	int result;
	String sql;
	//User user;
	Scanner sc=new Scanner(System.in);
	Account account;
	List<User> ulist=new ArrayList<User>();
	@Override
	public boolean addUser(User user) throws SQLException {
		sql="insert into userinfo(username,useremail,usercontact,userdob,userpan,useraadhar,useraddress,userpass)values(?,?,?,?,?,?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setString(1,user.getUsername() );
		ps.setString(2, user.getUseremail());
		ps.setString(3, user.getUsercontact());
		ps.setString(4, user.getUserdob());
		ps.setString(5, user.getUserpan());
		ps.setString(6, user.getUseraadhar());
		ps.setString(7, user.getUseraddress());
		ps.setString(8, user.getUserpass());

		System.out.println("Query:"+ps);
		result=ps.executeUpdate();
		if(result>0)
			return true;
		return false;
	}

	@Override
	public boolean updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		sql="update userinfo set username=?,useremail=?,usercontact=?,userdob=?,userpan=?,useraadhar=?,useraddress=?,userpass=? where userid=?";
		ps=conn.prepareStatement(sql);

		ps.setString(1,user.getUsername() );
		ps.setString(2, user.getUseremail());
		ps.setString(3, user.getUsercontact());
		ps.setString(4, user.getUserdob());
		ps.setString(5, user.getUserpan());
		ps.setString(6, user.getUseraadhar());
		ps.setString(7, user.getUseraddress());
		ps.setString(8, user.getUserpass());
		ps.setInt(9, user.getUserid());
		System.out.println("Query:"+ps);
		result=ps.executeUpdate();
		if(result>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteUser(int userid) throws SQLException {
		// TODO Auto-generated method stub
		//	String sql="delete from userinfo where userid=(?)";
		String str="inactive";
		String sql="update accountinfo set status=(?) where userid=(?) ";
		ps=conn.prepareStatement(sql);
		ps.setString(1, str);
		ps.setInt(2, userid);

		int res=ps.executeUpdate();
		if(res>0) {
			return true;
		}

		return false;
	}

	@Override
	public List<User> showUserList() throws SQLException {
		// TODO Auto-generated method stub
		sql="select * from userinfo where userrole='user'";
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();

		while(rs.next()) {
			user=new User();
			user.setUserid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setUseremail(rs.getString(3));
			user.setUsercontact(rs.getString(4));
			user.setUserdob(rs.getString(5));
			user.setUserpan(rs.getString(6));
			user.setUseraadhar(rs.getString(7));
			user.setUseraddress(rs.getString(8));
			user.setUserpass(rs.getString(9));
			user.setUserrole(rs.getString(10));
			ulist.add(user);
		}
		//System.out.println(ulist);
		return ulist;
	}

	@Override
	public List<User> showUserWithAccount() throws SQLException {
		// TODO Auto-generated method stub
		sql="select u.userid,username,useremail,usercontact,userdob,userpan,useraadhar,useraddress,userpass,userrole,accno,acctype,balance,status"
				+ " from userinfo u join accountinfo a on u.userid=a.userid";
		ps=conn.prepareStatement(sql);	
		rs=ps.executeQuery();
		//int custid, String accounttype, double balance, String accstatu.
		while(rs.next()) {
			user=new User();
			user.setUserid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setUseremail(rs.getString(3));
			user.setUsercontact(rs.getString(4));
			user.setUserdob(rs.getString(5));
			user.setUserpan(rs.getString(6));
			user.setUseraadhar(rs.getString(7));
			user.setUseraddress(rs.getString(8));
			user.setUserpass(rs.getString(9));
			user.setUserrole(rs.getString(10));
			account=new Account(rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14));
			//account=new Account();
			//account.setAccount_no(rs.getInt(11));
			user.setAccount(account);
			ulist.add(user);
		}
		return ulist;
	}

	@Override
	public User searchUserByUserid(int userid) throws SQLException {
		// TODO Auto-generated method stub

		sql="select u.userid,username,useremail,usercontact,userdob,userpan,useraadhar,useraddress,userpass,userrole,accno,acctype,balance,status"
				+ " from userinfo u join accountinfo a on u.userid=a.userid where u.userid=?";
		ps=conn.prepareStatement(sql);	
		ps.setInt(1, userid);
		System.out.println("query:"+ps);
		rs=ps.executeQuery();

		while(rs.next()) {
			user=new User();
			user.setUserid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setUseremail(rs.getString(3));
			user.setUsercontact(rs.getString(4));
			user.setUserdob(rs.getString(5));
			user.setUserpan(rs.getString(6));
			user.setUseraadhar(rs.getString(7));
			user.setUseraddress(rs.getString(8));
			user.setUserpass(rs.getString(9));
			user.setUserrole(rs.getString(10));
			account=new Account(rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14));
			//account=new Account();
			//account.setAccount_no(rs.getInt(11));
			user.setAccount(account);

		}
		return user;

	}

	@Override
	public User searchUserByEmail(String email) throws SQLException {
		// TODO Auto-generated method stub

		sql="select u.userid,username,useremail,usercontact,userdob,userpan,useraadhar,useraddress,userpass,userrole,accno,acctype,balance,status"
				+ " from userinfo u join accountinfo a on u.userid=a.userid where u.useremail=?";
		ps=conn.prepareStatement(sql);	
		ps.setString(1, email);
		System.out.println("query:"+ps);
		rs=ps.executeQuery();

		while(rs.next()) {
			user=new User();
			user.setUserid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setUseremail(rs.getString(3));
			user.setUsercontact(rs.getString(4));
			user.setUserdob(rs.getString(5));
			user.setUserpan(rs.getString(6));
			user.setUseraadhar(rs.getString(7));
			user.setUseraddress(rs.getString(8));
			user.setUserpass(rs.getString(9));
			user.setUserrole(rs.getString(10));
			account=new Account(rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14));
			//account=new Account();
			//account.setAccount_no(rs.getInt(11));
			user.setAccount(account);
		}
		return user;
	}

	@Override
	public User searchUserByAadhar(String aadhar) throws SQLException {
		// TODO Auto-generated method stub
		sql="select u.userid,username,useremail,usercontact,userdob,userpan,useraadhar,useraddress,userpass,userrole,accno,acctype,balance,status"
				+ " from userinfo u join accountinfo a on u.userid=a.userid where u.useraadhar=?";
		ps=conn.prepareStatement(sql);	
		ps.setString(1, aadhar);
		System.out.println("query:"+ps);
		rs=ps.executeQuery();

		while(rs.next()) {
			user=new User();
			user.setUserid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setUseremail(rs.getString(3));
			user.setUsercontact(rs.getString(4));
			user.setUserdob(rs.getString(5));
			user.setUserpan(rs.getString(6));
			user.setUseraadhar(rs.getString(7));
			user.setUseraddress(rs.getString(8));
			user.setUserpass(rs.getString(9));
			user.setUserrole(rs.getString(10));
			account=new Account(rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14));
			//account=new Account();
			//account.setAccount_no(rs.getInt(11));
			user.setAccount(account);
		}
		return user;
	}

	@Override
	public User searchUserByAccountno(String accno) throws SQLException {
		// TODO Auto-generated method stub
		sql="select u.userid,username,useremail,usercontact,userdob,userpan,useraadhar,useraddress,userpass,userrole,accno,acctype,balance,status"
				+ " from userinfo u join accountinfo a on u.userid=a.userid where accno=?";
		ps=conn.prepareStatement(sql);	
		ps.setString(1, accno);
		System.out.println("query:"+ps);
		rs=ps.executeQuery();

		while(rs.next()) {
			user=new User();
			user.setUserid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setUseremail(rs.getString(3));
			user.setUsercontact(rs.getString(4));
			user.setUserdob(rs.getString(5));
			user.setUserpan(rs.getString(6));
			user.setUseraadhar(rs.getString(7));
			user.setUseraddress(rs.getString(8));
			user.setUserpass(rs.getString(9));
			user.setUserrole(rs.getString(10));
			account=new Account(rs.getInt(11),rs.getString(12),rs.getDouble(13),rs.getString(14));
			//account=new Account();
			//account.setAccount_no(rs.getInt(11));
			user.setAccount(account);
		}
		return user;
	}

	@Override
	public boolean addAccount(String accno, int custid) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	//	@Override
	//	public boolean deposit(int userid) throws SQLException {
	//		// TODO Auto-generated method stub
	//		int accnumber=0;
	//		try {
	//			user=new UserDaoImpl().searchUserByUserid(userid);
	//			accnumber=user.getAccount().getAccountno();
	//			
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		System.out.println("Enter the amount to deposit:");
	//		Double amt=sc.nextDouble();
	//		deposits(amt,accnumber);
	//		String sql2="update accountinfo set  balance=(?) where userid=(?)";
	//		double amts=0;
	//		try {
	//			amts= user.getAccount().getBalance()+amt;
	//			ps=conn.prepareStatement(sql2);
	//			ps.setDouble(1, amts);
	//			ps.setInt(2, userid);
	//			int r=ps.executeUpdate();
	//			if(r>1) {
	//				System.out.println("not updated");
	//			}
	//			else {
	//				System.out.println("updated success");
	//				return true;
	//			}
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		System.out.println("amount is: "+amts);
	//
	//
	//		return false;
	//	}

	//	@Override
	//	public boolean withdraw(int userid) throws SQLException {
	//		// TODO Auto-generated method stub
	//		System.out.println("withdraw amount from account");
	//		try {
	//			user=new UserDaoImpl().searchUserByUserid(userid);
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		System.out.println("Enter the amount to withdraw:");
	//		Double amt1=sc.nextDouble();
	//		int accnos=0;
	//		accnos=user.getAccount().getAccountno();
	//		withdrows(amt1,accnos);
	//		String sql3="update accountinfo set  balance=(?) where userid=(?)";
	//		double amts1=0;
	//		try {
	//			amts1= user.getAccount().getBalance();
	//			
	//			if(amts1>amt1) {
	//				amts1=user.getAccount().getBalance()-amt1;
	//				ps=conn.prepareStatement(sql3);
	//				ps.setDouble(1, amts1);
	//				ps.setInt(2, userid);
	//				int r=ps.executeUpdate();
	//				if(r>1) {
	//					System.out.println("not updated");
	//				}
	//				else {
	//					System.out.println("updated success");
	//					return true;
	//				}
	//			}
	//			else {
	//				System.out.println("not possible !!! amount is less than u want to withdraw");
	//			}
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		System.out.println("amount is: "+amts1);
	//
	//		return false;
	//	}


	//	@Override
	//	public boolean Transaction(int userid) throws SQLException {
	//		// TODO Auto-generated method stub
	//		User ur=null;
	//		System.out.println("Enter receivers account number:");
	//		String receiveracc=sc.next();
	//		System.out.println("Enter amount to transfer:");
	//		Double amountss=sc.nextDouble();
	//		int accountnumber=0;
	//		double senderbalance=0;
	//		double receiverbalance=0;
	//		int receiveruserid=0;
	//		try {
	//			user=new UserDaoImpl().searchUserByUserid(userid);
	//			accountnumber=user.getAccount().getAccountno();
	//			Transactions1(amountss,accountnumber);
	//			ur=new UserDaoImpl().searchUserByAccountno(receiveracc);
	//			int accountnumbers=0;
	//			accountnumbers=ur.getAccount().getAccountno();
	//			Transactions2(amountss,accountnumbers);
	//			if(ur!=null && user!=null && user.getUserid()!=ur.getUserid()) {
	//				receiveruserid=ur.getUserid();
	//				senderbalance=user.getAccount().getBalance();
	//				receiverbalance=ur.getAccount().getBalance();
	//				if(senderbalance-amountss>0) {
	//					senderbalance=user.getAccount().getBalance()-amountss;
	//					receiverbalance=ur.getAccount().getBalance()+amountss;
	//					String sqlr="update accountinfo set balance=(?) where  userid=(?)";
	//					ps=conn.prepareStatement(sqlr);
	//					ps.setDouble(1, receiverbalance);
	//					ps.setInt(2, receiveruserid);
	//
	//					int ansr=ps.executeUpdate();
	//					if(ansr>0) {
	//
	//						System.out.println("updated success");
	//
	//					}
	//					else {
	//						System.out.println("not updated");
	//					}	
	//					String sqls="update accountinfo set balance=(?) where  userid=(?)";
	//					ps=conn.prepareStatement(sqls);
	//					ps.setDouble(1, senderbalance);
	//					ps.setInt(2, userid);
	//					int anss=ps.executeUpdate();
	//					if(anss>0) {
	//						System.out.println("updated success");
	//						System.out.println("current amount is:"+senderbalance);
	//						return true;
	//					}
	//					else {
	//						System.out.println("not updated");
	//					}	
	//				}
	//				else {
	//					System.out.println("sender account have less amount !!");
	//				}
	//			}
	//			else {
	//				System.out.println("user not found");
	//			}
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			throw new SQLException("Invalid receiver account");
	//		}
	//
	//
	//		return false;
	//	}




	public void deposits(double tamount,int accno) {
		String sql="insert into transactioninfo(ttype,tamount,tdate,accno) values(?,?,NOW(),?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, "deposit");
			ps.setDouble(2, tamount);
			ps.setInt(3, accno);
			int rr=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void withdrows(int accno,double tamount) {
		String sql="insert into transactioninfo(ttype,tamount,tdate,accno) values(?,?,NOW(),?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, "Withdraw");
			ps.setDouble(2, tamount);
			ps.setInt(3, accno);
			int rr=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Transactions1(double tamount,int accno) {
		String sql="insert into transactioninfo(ttype,tamount,tdate,accno) values(?,?,NOW(),?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, "withdraw");
			ps.setDouble(2, tamount);
			ps.setInt(3, accno);
			int rr=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Transactions2(double tamount,int accno) {
		String sql="insert into transactioninfo(ttype,tamount,tdate,accno) values(?,?,NOW(),?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, "deposit");
			ps.setDouble(2, tamount);
			ps.setInt(3, accno);
			int rr=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public String getUsernamePass(String email,String password) {

		try {
			String sql="select * from userinfo where useremail=(?) and userpass=(?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);

			rs=ps.executeQuery();
			System.out.println();
			rs.first();
			return rs.getString(10);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("id not found");
		}

		return null;
	}

	@Override
	public boolean deposit(String accno, int amt) throws SQLException {
		// TODO Auto-generated method stub
		User u1=searchUserByAccountno(accno);
		int accno1=u1.getAccount().getAccountno();
		String status=u1.getAccount().getAccstatus();  //nv 

		if(status.equalsIgnoreCase("active")) {
			deposits(amt,accno1);
			String sql2="update accountinfo set  balance=(?) where accno=(?)";
			double amts=0;
			try {
				amts= user.getAccount().getBalance()+amt;
				ps=conn.prepareStatement(sql2);
				ps.setDouble(1, amts);
				ps.setInt(2, accno1);
				int r=ps.executeUpdate();
				if(r>1) {
					System.out.println("not updated");
				}
				else {
					System.out.println("updated success");
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("amount is: "+amts);
		}
		else {
			System.out.println("activate account");
		}
		return false;
	}

	@Override
	public boolean withdraw(String accno, int amt) throws SQLException {
		User u1=searchUserByAccountno(accno);
		int accno1=u1.getAccount().getAccountno();
		String status=u1.getAccount().getAccstatus();
		if(status.equalsIgnoreCase("active")) {
			double camts=0;
			if(accno1!=0) {
				camts=u1.getAccount().getBalance();
			}
			withdrows(accno1,amt);
			String sql2="update accountinfo set  balance=(?) where accno=(?)";
			double amts=0;
			try {
				if((camts-amt)>1000) {
					amts= user.getAccount().getBalance()-amt;
					ps=conn.prepareStatement(sql2);
					ps.setDouble(1, amts);
					ps.setInt(2, accno1);
					int r=ps.executeUpdate();
					System.out.println(r); 
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("amount is less");
			}
			System.out.println("amount is: "+amts);

		}
		else {
			System.out.println("activate account");
		}

		return false;

	}

	@Override
	public double showBalance(String accno) throws SQLException {
		// TODO Auto-generated method stub
		User u1=searchUserByAccountno(accno);

		return u1.getAccount().getBalance();
	}

	@Override
	public boolean Transaction(String accno,String racc, int amt) throws SQLException {
		// TODO Auto-generated method stub
		User sender=searchUserByAccountno(accno);
		User receiver=searchUserByAccountno(racc);
		String accstatus1=sender.getAccount().getAccstatus();
		String accstatus2=receiver.getAccount().getAccstatus();
		int accno1=sender.getAccount().getAccountno();
		int accno2=receiver.getAccount().getAccountno(); 

		if(accstatus1.equalsIgnoreCase("active") && accstatus2.equalsIgnoreCase("active")) {
			if(accno1!=0 && accno2!=0) { 
				double balances=sender.getAccount().getBalance();
				double balancer=receiver.getAccount().getBalance();


				if((balances-amt)>1000) {
					balances=sender.getAccount().getBalance()-amt;
					Transactions1(amt,accno1);
					balancer=receiver.getAccount().getBalance()+amt;
					Transactions2(amt,accno2);
					String sqlr="update accountinfo set balance=(?) where  accno=(?)";
					ps=conn.prepareStatement(sqlr);
					ps.setDouble(1, balances);
					ps.setInt(2, accno1);

					int ansr=ps.executeUpdate();
					if(ansr>0) {

						System.out.println("updated success");

					}
					else {
						System.out.println("not updated");
					}	
					String sqls="update accountinfo set balance=(?) where  accno=(?)";
					ps=conn.prepareStatement(sqls);
					ps.setDouble(1, balancer);
					ps.setInt(2, accno2);
					int anss=ps.executeUpdate();
					if(anss>0) {
						System.out.println("updated success");
						System.out.println("current amount is:"+balances);
						return true;
					}
					else {
						System.out.println("not updated");
					}	
				}	
			}


		}
		else if(accstatus1.equalsIgnoreCase("active")){
			System.out.println("activate the receiver account");
		}
		else {
			System.out.println("activate the sender account");
		}

		return false;


	}


	public void activateAccount(String accno) throws SQLException {
		//User u=searchUserByAccountno(accno);
		String sql="update accountinfo set status=(?) where accno=(?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, "active");
		ps.setString(2, accno);
		int rs=ps.executeUpdate();
		if(rs>0) {
			System.out.println("activated account");
		}
		else {
			System.out.println("not activated");
		}

	}
	public void addPayee(String sacc) throws SQLException {
		System.out.println("Enter the account number to add payee");
		String racc=sc.next();
		//boolean ispresent=false;
		boolean ispresent=isreceiveraddAsPayeeAlready(sacc,racc);
		if(ispresent) {
			System.out.println("already exists");
			return ;
		}
		if(!ispresent) {
			User u=searchUserByAccountno(racc);
			String accnor=Integer.toString(u.getAccount().getAccountno());
			String str="insert into payee values(?,?)";
			ps=conn.prepareStatement(str);
			ps.setString(1,sacc);
			ps.setString(2, accnor);
			int ans= ps.executeUpdate();
			if(ans>0) {
				System.out.println("payee added");
			}
			else {
				System.out.println("payee not added");
			}
		}
		else {
			System.out.println(" cannot add duplicate entry in payee");
		}
		
	}
	public boolean isreceiveraddAsPayeeAlready(String saccno,String raccno) throws SQLException {
		ArrayList<String> list=new ArrayList<String>();
		
		String str="select * from payee where fromaccno=(?) and toaccno=(?)";
		ps=conn.prepareStatement(str);
		ps.setString(1, saccno);
		ps.setString(2, raccno);
		boolean isp=ps.execute();
		ResultSet rr=null;
		if(isp) {
			rr=ps.executeQuery();
			if(rr.next()) {
				list.add(rr.getString(1));
				list.add(rr.getString(2));
				return true;
			}
			//System.out.println(rr.getString(1)+" "+rr.getString(2));
		}
		
		return false;
	}
}
