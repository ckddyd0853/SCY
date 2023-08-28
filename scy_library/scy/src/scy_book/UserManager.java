package scy_book;

public class UserManager {

		private String name;

		private String tel;

		private String email;


	
	public UserManager(String name, String tel, String email) {
		
	super();
	
	this.name = name;
	
	this.tel = tel;
	
	this.email = email;
	
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	

	@Override
	public String toString() {
		return "[ 성함: " + name + " " + "]"  + " " + "[" + "연락처: "  + tel + " " + "]" + " " + "[" + "이메일: "  + email + " " + "]"; 
	}
}