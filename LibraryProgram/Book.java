package LibraryProgram;
import java.util.Scanner;
import java.util.ArrayList;
import LibraryProgram.BookManager1;

public class Book {
	
	static Scanner sc = new Scanner(System.in);
	
	static ArrayList<BookManager1> books = new ArrayList<BookManager1>();
	
	
	public static void Bookreg() {
		System.out.println("등록할 도서의 이름을 입력하세요.");
		System.out.println("---------------------");
		
		System.out.print("책 이름: ");
		String bookname = sc.next();
		
		books.add(new BookManager1(bookname, "가능", "없음"));
		books.add(new BookManager1("자바", "가능", "없음"));
		System.out.println("등록 되었습니다!");
	}
	
	public static void Bookloan() {
		System.out.println();
		
		System.out.print(">>>대출자 명: ");
		String loan = sc.next();
		
		System.out.print(">>>찾는 도서명: ");
		String loanname = sc.next();
		
		System.out.println(">>>대출완료!!");
		
	}
	
	public static void BookList() {
			System.out.println();
			for (BookManager1 books : books)
				System.out.println(books);
	}
	

}
