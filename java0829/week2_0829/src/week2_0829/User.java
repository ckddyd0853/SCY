package week2_0829;

public class User {
	private String userid;
	private String pwd;
	private String name;
	private String tel;
	private String grade;
	
	public User() {
		
	}	
	
	public User(String userid, String pwd, String name, String tel, String grade) {
		this.userid = userid;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
		this.grade = grade;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	
}
