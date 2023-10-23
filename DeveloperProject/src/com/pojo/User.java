package com.pojo;

import com.pojo.Account;

public class User {
	private int userid;
	private String username;
	private String useremail;
	private String usercontact;
	private String userdob;
	private String userpan;
	private String useraadhar;
	private String useraddress;
	private String userpass;
	private String userrole;
	private Account account;
	public User() {
		super();
	}

	
	public User(String username, String useremail, String usercontact, String userdob, String userpan,
			String useraadhar, String useraddress, String userpass, Account account) {
		super();
		this.username = username;
		this.useremail = useremail;
		this.usercontact = usercontact;
		this.userdob = userdob;
		this.userpan = userpan;
		this.useraadhar = useraadhar;
		this.useraddress = useraddress;
		this.userpass = userpass;
		this.account = account;
	}


	public User(String username, String useremail, String usercontact, String userdob, String userpan,
			String useraadhar, String useraddress, String userpass, String userrole, Account account) {
		super();
		this.username = username;
		this.useremail = useremail;
		this.usercontact = usercontact;
		this.userdob = userdob;
		this.userpan = userpan;
		this.useraadhar = useraadhar;
		this.useraddress = useraddress;
		this.userpass = userpass;
		this.userrole = userrole;
		this.account = account;
	}


	public User(int userid, String username, String useremail, String usercontact, String userdob, String userpan,
			String useraadhar, String useraddress, String userpass, String userrole, Account account) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.usercontact = usercontact;
		this.userdob = userdob;
		this.userpan = userpan;
		this.useraadhar = useraadhar;
		this.useraddress = useraddress;
		this.userpass = userpass;
		this.userrole = userrole;
		this.account = account;
	}


	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public User(String username, String useremail, String usercontact, String userdob, String userpan,
			String useraadhar, String useraddress, String userpass) {
		super();
		this.username = username;
		this.useremail = useremail;
		this.usercontact = usercontact;
		this.userdob = userdob;
		this.userpan = userpan;
		this.useraadhar = useraadhar;
		this.useraddress = useraddress;
		this.userpass = userpass;
	}

	public User(int userid, String username, String useremail, String usercontact, String userdob, String userpan,
			String useraadhar, String useraddress, String userpass, String userrole) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.usercontact = usercontact;
		this.userdob = userdob;
		this.userpan = userpan;
		this.useraadhar = useraadhar;
		this.useraddress = useraddress;
		this.userpass = userpass;
		this.userrole = userrole;
	}

	
	public User(int userid, String username, String useremail, String usercontact, String userdob, String userpan,
			String useraadhar, String useraddress, String userpass) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.usercontact = usercontact;
		this.userdob = userdob;
		this.userpan = userpan;
		this.useraadhar = useraadhar;
		this.useraddress = useraddress;
		this.userpass = userpass;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUsercontact() {
		return usercontact;
	}

	public void setUsercontact(String usercontact) {
		this.usercontact = usercontact;
	}

	public String getUserdob() {
		return userdob;
	}

	public void setUserdob(String userdob) {
		this.userdob = userdob;
	}

	public String getUserpan() {
		return userpan;
	}

	public void setUserpan(String userpan) {
		this.userpan = userpan;
	}

	public String getUseraadhar() {
		return useraadhar;
	}

	public void setUseraadhar(String useraadhar) {
		this.useraadhar = useraadhar;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", useremail=" + useremail + ", usercontact="
				+ usercontact + ", userdob=" + userdob + ", userpan=" + userpan + ", useraadhar=" + useraadhar
				+ ", useraddress=" + useraddress + ", userpass=" + userpass + ", userrole=" + userrole + ", account="
				+ account + "]\n";
	}


	
	
	
}
