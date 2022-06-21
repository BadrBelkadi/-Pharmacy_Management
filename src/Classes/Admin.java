package Classes;

import java.io.Serializable;

public class Admin implements Serializable {
	private String UserName;
	private String Password_A;
	
	/***Getters and Setters ******/

	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword_A() {
		return Password_A;
	}
	public void setPassword(String password_A) {
		Password_A = password_A;
	}
	
	
	
}
