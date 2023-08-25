package LibraryProgram;
import java.util.Scanner;

import LibraryProgram.UserManager;

import java.util.ArrayList;
import LibraryProgram.Book;

public class User {
	
	
	static ArrayList<UserManager> users = new ArrayList<UserManager>();
	
	static Scanner sc = new Scanner(System.in);
	
	static int n = 0;
	
	public static void Customer (){ 
		System.out.println();
		System.out.println("추가할 고객의 정보를 입력하세요.");
		System.out.println("---------------------");
		
		System.out.print("이름: ");
		String name = sc.next();
		
		System.out.print("주소: ");
		String tel = sc.next();
		
		System.out.print("번호: ");
		String email = sc.next();
		
		users.add(new UserManager(name, tel, email));
		
		System.out.println("추가 되었습니다!");
	}
	
	public static void RemoveCustomer (){
		System.out.println();
		System.out.println("삭제할 고객의 이름을 입력하세요.");
		System.out.println("---------------------");
		
		System.out.print("이름: ");
		String name = sc.next();
		
		for (int i = 0; i < users.size(); i++) {
			if (name.equals(users.get(i).getName())) {
				users.remove(i);
				System.out.println("삭제되었습니다!");
			} else
				System.out.println("회원이 존재하지 않습니다.");
		}
	}
	
	public static void userList() {
	System.out.println();
	for (UserManager users : users)
		System.out.println(users);
	}
	
	public static void usermodify() {
		System.out.println();
		System.out.print("수정할 고객의 이름을 입력하세요.");
		
		String name = sc.next();
		for (int i = 0; i < users.size(); i++) {
			if (name.equals(users.get(i).getName())) {

				System.out.print("수정하실 항목을 선택하세요. (1)성함     (2)연락처     (3)이메일");
				n = sc.nextInt();
				System.out.println();

				switch (n) {
				case 1:
					System.out.print("이름을 새로 입력하세요");
					name = sc.next();
					users.get(i).setName(name);
					break;
					
				case 2:
					System.out.print("주소를 새로 입력하세요.");
					String tel1 = sc.next();
					users.get(i).setTel(tel1);
					break;
					
				case 3:
					System.out.print("번호를 새로 입력하세요.");
					String email = sc.next();
					users.get(i).setEmail(email);
					break;
					
				}
				System.out.println("수정되었습니다!");

			} else
				System.out.println("잘못된 정보입니다.");
		}

		}
	
	public static void UserProgram() {
		Boolean run2 = true;
		while (run2) {
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("|   1. 고객 등록   |   2. 고객 삭제   |   3. 고객리스트   |   4. 고객 정보 수정   |   5. 메인 메뉴");
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.print("메뉴를 선택하세요.");
			n = sc.nextInt();

			switch (n) {
			
			case 1: // 고객 등록 메소드
				Customer();
				break;

			case 2: // 고객 삭제 메소드
				RemoveCustomer();
				break;

			case 3: // 고객리스트 메소드
				userList();
				break;

			case 4: // 고객 정보 수정 메소드
				usermodify();
				break;

			case 5:
				run2 = false;
				System.out.println("프로그램이 종료되었습니다.");
				break;

			default:
				System.out.println("1 ~ 5 까지의 숫자만 입력하세요.");
				break;

			}

		}
	}
	
	public static void main(String[] args) {
		Boolean run = true;
		
		while (run) {
		System.out.println("-----------------------------------------------");
		System.out.println("|   1. 고객 관리   |   2. 도서 관리   |   3. 종료   |");
		System.out.println("-----------------------------------------------");
		System.out.print("메뉴를 선택하세요.");
		
		int m = sc.nextInt();
		
		switch (m) {
		case 1: {
			UserProgram();
			break;
		}
		
		case 2: {
			Book book = new Book();
			book.BookProgram();
		}
		
		case 3:
			run = false;
			System.out.println("프로그램이 종료되었습니다.");
			break;
			
		default:
			System.out.println("1 ~ 3 까지의 숫자만 입력해주세요.");
			break;
		}
	}

}

}
