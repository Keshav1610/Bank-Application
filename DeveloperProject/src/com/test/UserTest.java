package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.UserDaoImpl;
import com.pojo.User;
import com.utility.DBConnection;

public class UserTest {
//	static Connection conn=DBConnection.getConnect();
	static PreparedStatement ps;
	static ResultSet rs;
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		int userid;
		String username;
		String useremail;
		String usercontact;
		String userdob;
		String userpan;
		String useraadhar;
		String useraddress;
		String userpass;
		String userrole;
		User user = null;
		List<User>ulist=new ArrayList<User>();
		UserDaoImpl userdao=new UserDaoImpl();
		boolean result;
		int choice;
		char ch;
		char cc;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("1.Registration\n2.login");// nv
		System.out.println("Enter the choice:");
		int choice5=sc.nextInt();
	
		if(choice5==1) {
			System.out.println("-----welcome to kuberbank-----"); 
			
			System.out.println("Enter user name:");
			username=sc.next();
			System.out.println("Enter user email:");
			useremail=sc.next();
			System.out.println("Enter user contact:");
			usercontact=sc.next();
			System.out.println("Enter user dob:");
			userdob=sc.next();
			System.out.println("Enter user pan:");
			userpan=sc.next();
			System.out.println("Enter user aadhar:");
			useraadhar=sc.next();
			System.out.println("Enter user address:");
			useraddress=sc.next();
			System.out.println("Enter user password:");
			userpass=sc.next();
			user=new User(username, useremail, usercontact, userdob, userpan, useraadhar, useraddress, userpass);
			try {
				result=userdao.addUser(user);
				if(result)
					System.out.println("user added successfully");
				else
					System.out.println("user not added");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else {
			System.out.println("-----welcome to kuberbank-----");
			System.out.println("Enter  email!!");
			String uname=sc.next();
			System.out.println("Enter  Password!!");
			String passw=sc.next();
			String role=userdao.getUsernamePass(uname,passw);

			if(role.equals("admin")) {
				do {
					//System.out.println("-----welcome to SBI Bank-----");
					System.out.println("1.add user");
					System.out.println("2.update user");
					System.out.println("3.delete user");
					System.out.println("4.show user list");
					System.out.println("5.show user list with Account details");
					System.out.println("6.search user by id");
					System.out.println("7.search user by email");
					System.out.println("8.search user by account");
					System.out.println("9.search user by aadhar");
					System.out.println("10.activate acc"); // nv
					System.out.println("---------------------------------");
					System.out.println("Enter your choice:");
					choice=sc.nextInt();
					switch(choice) {
					case 1:
						System.out.println("Enter user name:");
						username=sc.next();
						System.out.println("Enter user email:");
						useremail=sc.next();
						System.out.println("Enter user contact:");
						usercontact=sc.next();
						System.out.println("Enter user dob:");
						userdob=sc.next();
						System.out.println("Enter user pan:");
						userpan=sc.next();
						System.out.println("Enter user aadhar:");
						useraadhar=sc.next();
						System.out.println("Enter user address:");
						useraddress=sc.next();
						System.out.println("Enter user password:");
						userpass=sc.next();
						user=new User(username, useremail, usercontact, userdob, userpan, useraadhar, useraddress, userpass);
						try {
							result=userdao.addUser(user);
							if(result)
								System.out.println("user added successfully");
							else
								System.out.println("user not added");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String str=Integer.toString(user.getAccount().getAccountno());
						userdao.activateAccount(str);
						break;
					case 2:
						System.out.println("Enter userid:");
						int uid=sc.nextInt();
						System.out.println("Enter user name:");
						username=sc.next();
						System.out.println("Enter user email:");
						useremail=sc.next();
						System.out.println("Enter user contact:");
						usercontact=sc.next();
						System.out.println("Enter user dob:");
						userdob=sc.next();
						System.out.println("Enter user pan:");
						userpan=sc.next();
						System.out.println("Enter user aadhar:");
						useraadhar=sc.next();
						System.out.println("Enter user address:");
						useraddress=sc.next();
						System.out.println("Enter user password:");
						userpass=sc.next();
						user=new User(uid, username, useremail,  usercontact, userdob, userpan,useraadhar,  useraddress,  userpass);
						try {
							userdao.updateUser(user);
						} catch (SQLException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 3:
						System.out.println("deleting data");
						System.out.println("enter userid: ");
						int id=sc.nextInt();
						try {
							System.out.println(	userdao.deleteUser(id));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 4:
						try {
							System.out.println(userdao.showUserList());

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 5:
						System.out.println("---------user list with account details-----------");
						try {
							ulist=userdao.showUserWithAccount();
							if(!ulist.isEmpty()) {
								for(User u:ulist) {
									System.out.println(u);
								}
							}
							else {
								System.out.println("userlist is empty");
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 6:
						System.out.println("search user and account by id:");
						userid=sc.nextInt();
						try {
							user=userdao.searchUserByUserid(userid);
							if(user!=null) {
								System.out.println(user);
							}
							else {
								System.out.println("user not found");
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 9:
						System.out.println("search user and account by aadhar:");
						useraadhar = sc.next();
						try {
							user=userdao.searchUserByAadhar(useraadhar);
							if(user!=null) {
								System.out.println(user);
							}
							else {
								System.out.println("user not found");
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 7:
						System.out.println("search user and account by email:");
						useremail=sc.next();
						try {
							user=userdao.searchUserByEmail(useremail);
							if(user!=null) {
								System.out.println(user);
							}
							else {
								System.out.println("user not found");
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 8:
						System.out.println("search user and account number:");
						String account=sc.next();
						try {
							user=userdao.searchUserByAccountno(account);
							if(user!=null) {
								System.out.println(user);
							}
							else {
								System.out.println("user not found");
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
						
					case 10://nv
						System.out.println("enter acc no to activate");
						String acc=sc.next();
						userdao.activateAccount(acc);
						break;
					}
					System.out.println("do you want to continue if yes enter y:");
					ch=sc.next().charAt(0);
				}
				while(ch=='y'|| ch=='Y');
			} 
			else if(role.equals("user")) {			
				int userids=0;
				user=userdao.searchUserByEmail(uname);
				userids=user.getAccount().getAccountno();
				String accno=Integer.toString(userids);
				//System.out.println(userids);
				char chs=0;
				//System.out.println(userids);
				do {
					if(userids!=0) {
						System.out.println("1.Credit\n2.Withdraw \n3.transition\n4.show balance\n5.add Payee");
						System.out.println("Enter choice");
						int choices=sc.nextInt();
						switch(choices) {
						case 1:
							System.out.println("enter amount:");
							int amt=sc.nextInt();
							System.out.println(userdao.deposit(accno,amt));
							break;
						case 2:
							System.out.println("enter amount:");
							int amt1=sc.nextInt();
							System.out.println(userdao.withdraw(accno,amt1) );
							break;
						case 3:
							System.out.println("enter  receiver account no:");
							String raccnos=sc.next();
							System.out.println("enter amount:");
							int amt2=sc.nextInt();
							System.out.println(userdao.Transaction(Integer.toString(user.getAccount().getAccountno()),raccnos,amt2));
							break;

						case 4:
							System.out.println("show balance !!");
							System.out.println("Enter accno:");
							String accno5=sc.next();
							System.out.println( userdao.showBalance(accno5));
							break;
						case 5:
							int saccno=user.getAccount().getAccountno();
							String accn=Integer.toString(saccno);
							 userdao.addPayee(accn);
							 break;
						default: 
							System.out.println("invalid input");
							break;
						}
						System.out.println("u want to continue enter y !!");
						chs=sc.next().charAt(0);
					}
				}while(chs=='Y' || chs=='y');
			}
			else {
				System.out.println("user not found please enter correct email and password !!");
			}

		}


	}

}
