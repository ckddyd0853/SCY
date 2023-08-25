package LibraryProgram;
import java.util.Scanner;
import java.util.ArrayList;
import LibraryProgram.BookManager;

public class Book {
	
	static Scanner booksc = new Scanner(System.in);
	
	static ArrayList<BookManager> books = new ArrayList<BookManager>();
	
	
	public static void Bookreg() {
		System.out.println("등록할 도서의 이름을 입력하세요.");
		System.out.println("---------------------");
		
		System.out.print("책 이름: ");
		String bookname = booksc.next();
		
		books.add(new BookManager(bookname, "대출 가능", "없음"));
		
		System.out.println("등록 되었습니다!");
	}
	
	public static void Bookloan() {
		System.out.println();
		System.out.print(">>>대출자 명: ");
		String loan = booksc.next();
		
		System.out.print(">>>찾는 도서명: ");
		String loanname = booksc.next();
		
			System.out.println(">>>대출완료!!");
		
		}
		
		
	public static void BookList() {
		System.out.println();

		for (BookManager books : books) {
			System.out.println(books);
		}
	}
	
	public static void BookProgram() {
		Boolean run3 = true;
		while (run3) {
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("|   1. 도서 등록   |   2. 대출   |   3. 반납   |   4. 도서리스트   |   5. 메인 메뉴");
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.print("메뉴를 선택하세요.");
			int n1 = booksc.nextInt();

			switch (n1) {
			
			case 1: // 고객 등록 메소드
				Bookreg();
				break;

			case 2: // 고객 대출 메소드
				Bookloan();
				break;

			case 3: // 고객 반납 메소드
				
				break;

			case 4: // 도서리스트 메소드
				BookList();
				break;

			case 5:
				run3 = false;
				System.out.println("메인메뉴로 돌아갑니다.");
				break;

			default:
				System.out.println("1 ~ 5 까지의 숫자만 입력하세요.");
				break;

			}

		}
	}
}
