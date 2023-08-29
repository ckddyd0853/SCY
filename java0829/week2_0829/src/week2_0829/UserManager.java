package week2_0829;

public class UserManager {

	public static void main(String[] args) {
		// 1.등록 2.수정 3.리스트보기 4.종료
		UserDAO dao = new UserDAO();

		User u=new User("bbb","9765","공유","765432","gold");
		dao.inserUser(u);
		
		dao.printUserList();
		
	}

}
