package scy_book;

import java.util.ArrayList;
import java.util.Scanner;

import scy_book.UserManager;
import scy_book.User;
import scy_book.BookProgram;

public class BookProgram {
   Scanner sc = new Scanner(System.in);
    private String bUser;
    private String bTitle;
    String bAvailable;
    String bName;
    private ArrayList<BookProgram> bookList = new ArrayList<BookProgram>();
    
    public String getbTitle() {
        return bTitle;
    }
    
    public void setbTitle(String bTitle) {
        this.bTitle = bTitle;
    }
    
    public String isbAvailable() {
        return bAvailable;
    }
 
    public void setbAvailable(String bAvailable) {
        this.bAvailable = bAvailable;
    }
    
    public String getbName() {
        return bName;
    }
    
    public void setbName(String bName) {
        this.bName = bName;
    }
    
    public String getbUser() {
        return bUser;
    }
    
    public void setbUser(String bUser) {
        this.bUser = bUser;
    }
   
   public void showMain() throws InterruptedException {
        while (true) {
            System.out.println("1.고객관리 2.도서관리 0.종료");
            String userInput = sc.nextLine();
     
            switch (userInput) {
            case ("1"):
                insertBook(); 
                break;
     
            case ("2"):
                showUser(); 
                break;
                
            case ("0"):
                System.out.println("프로그램 종료");
                sc.close();
                System.exit(0);
                
            default:
                System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
                break;
            }
        }
    }
   
   public void showUser() throws InterruptedException {
	   boolean run = true;
        while (run) {
        	System.out.println("-----------------------------------------------------------------------------");
			System.out.println("|   1. 도서 등록   |   2. 대출   |   3. 반납   |   4. 도서리스트   |   5. 메인 메뉴  |");
			System.out.println("-----------------------------------------------------------------------------");
			System.out.print("메뉴를 선택하세요.");
            String userInput = sc.nextLine();
     
            switch (userInput) {
            case ("1"):
                insertBook(); 
                break;
     
            case ("2"):
                loanBook(); 
                break;
                
            case ("3"):
                returnBook(); 
                break;
     
            case ("4"):
                selectAll();
                break;
                
            case ("5"):
            	System.out.println("메인메뉴로 돌아갑니다.");
            	User user = new User();
            	user.Start();
               break;
               
            default:
                System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
                break;
            }
        }
   }
   


	//도서 등록
    public void insertBook() throws InterruptedException {
        while (true) {
        	BookProgram book = new BookProgram();
            
            System.out.print("책이름:");
            book.setbTitle(sc.nextLine());
            book.setbAvailable("대출 가능");
            book.setbName("없음");
            bookList.add(book); 
            break;
        }
    }
    
    // 책 대여
    public void loanBook() {
        while (true) {
        	BookProgram book = new BookProgram();
           
           String sttmp = "대출 가능";
           String stdf = "대출중";
           
            System.out.print(">>>대출자 명 :");
            bName = sc.nextLine();
            
            
            System.out.print(">>>찾는 도서명 :");
            bTitle = sc.nextLine();
           
            
            for (int i = 0; i < bookList.size(); i++) {
               
               
               
                if (bTitle.equals(bookList.get(i).getbTitle())) {
                    
                   String bStatus = bookList.get(i).isbAvailable();
 
                    if (bStatus.equals(sttmp) == true ) {
                       bookList.get(i).setbAvailable(stdf);
                       bookList.get(i).setbName(bName);
                        System.out.println(">>>대출완료!!!");
                    } else if (bStatus.equals(stdf) == true ) {
                        System.out.println(">>>현재 다른 고객이 이용중이므로 대출이 불가합니다.");
                    }
                  
                    break;
                } 
            }
            
            break;
        }
    }
    
    //책 반납
    public void returnBook() throws InterruptedException {
        while (true) {
        	BookProgram book = new BookProgram();
           
           String sttmp = "대출 가능";
           String stdf = "대출중";
           
            System.out.print("반납자 명 :");
            bName = sc.nextLine();
           
            bNameEquals(bName); 
            
            
            System.out.print("반납할 도서명 :");
            bTitle = sc.nextLine();
           
            bTitleEquals(bTitle, bName); 
            
            for (int i = 0; i < bookList.size(); i++) {
                if (bTitle.equals(bookList.get(i).getbTitle())) {
                    
                   String bStatus = bookList.get(i).isbAvailable();
 
                    if (bStatus.equals(stdf) == true ) {
                       bookList.get(i).setbAvailable(sttmp);
                       bookList.get(i).setbName("없음");
                        System.out.println(">>>반납이 완료되었습니다.");
                    }
                   
                    break;
                }
            }
            break;
        }
    }
    
    
    public void bNameEquals(String name) throws InterruptedException {
       
       while(true) {
          for (int i = 0; i < bookList.size(); i++) {
              if (name.equals(bookList.get(i).bName) == true ) {
                       return;
               }
                  
           }
             System.out.println(">>>대출자 명단에 없습니다.");
             showUser();
       }
    }
    
   public void bTitleEquals(String title, String name) throws InterruptedException {
       
       while(true) {
          for (int i = 0; i < bookList.size(); i++) {
              if (title.equals(bookList.get(i).bTitle) == true ) {
                       return;
               }
                
           }
             System.out.println(">>>" + title + " 도서를 대출하지 않았습니다.");
             showUser();
       }
    }
    
    
    // 전체 조회
    public void selectAll(){
    	for (BookProgram booklist : bookList)
    		System.out.println(booklist);}
        


    @Override
	public String toString() {
		return "Book [도서명" + " "+ bTitle + ", 대출여부=" + bAvailable + ", 대출자=" + bName + "]";
	}
}
    
 
    
