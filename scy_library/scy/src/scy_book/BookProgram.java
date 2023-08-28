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
            System.out.println("1.������ 2.�������� 0.����");
            String userInput = sc.nextLine();
     
            switch (userInput) {
            case ("1"):
                insertBook(); 
                break;
     
            case ("2"):
                showUser(); 
                break;
                
            case ("0"):
                System.out.println("���α׷� ����");
                sc.close();
                System.exit(0);
                
            default:
                System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
                break;
            }
        }
    }
   
   public void showUser() throws InterruptedException {
	   boolean run = true;
        while (run) {
        	System.out.println("-----------------------------------------------------------------------------");
			System.out.println("|   1. ���� ���   |   2. ����   |   3. �ݳ�   |   4. ��������Ʈ   |   5. ���� �޴�  |");
			System.out.println("-----------------------------------------------------------------------------");
			System.out.print("�޴��� �����ϼ���.");
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
            	System.out.println("���θ޴��� ���ư��ϴ�.");
            	User user = new User();
            	user.Start();
               break;
               
            default:
                System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
                break;
            }
        }
   }
   


	//���� ���
    public void insertBook() throws InterruptedException {
        while (true) {
        	BookProgram book = new BookProgram();
            
            System.out.print("å�̸�:");
            book.setbTitle(sc.nextLine());
            book.setbAvailable("���� ����");
            book.setbName("����");
            bookList.add(book); 
            break;
        }
    }
    
    // å �뿩
    public void loanBook() {
        while (true) {
        	BookProgram book = new BookProgram();
           
           String sttmp = "���� ����";
           String stdf = "������";
           
            System.out.print(">>>������ �� :");
            bName = sc.nextLine();
            
            
            System.out.print(">>>ã�� ������ :");
            bTitle = sc.nextLine();
           
            
            for (int i = 0; i < bookList.size(); i++) {
               
               
               
                if (bTitle.equals(bookList.get(i).getbTitle())) {
                    
                   String bStatus = bookList.get(i).isbAvailable();
 
                    if (bStatus.equals(sttmp) == true ) {
                       bookList.get(i).setbAvailable(stdf);
                       bookList.get(i).setbName(bName);
                        System.out.println(">>>����Ϸ�!!!");
                    } else if (bStatus.equals(stdf) == true ) {
                        System.out.println(">>>���� �ٸ� ���� �̿����̹Ƿ� ������ �Ұ��մϴ�.");
                    }
                  
                    break;
                } 
            }
            
            break;
        }
    }
    
    //å �ݳ�
    public void returnBook() throws InterruptedException {
        while (true) {
        	BookProgram book = new BookProgram();
           
           String sttmp = "���� ����";
           String stdf = "������";
           
            System.out.print("�ݳ��� �� :");
            bName = sc.nextLine();
           
            bNameEquals(bName); 
            
            
            System.out.print("�ݳ��� ������ :");
            bTitle = sc.nextLine();
           
            bTitleEquals(bTitle, bName); 
            
            for (int i = 0; i < bookList.size(); i++) {
                if (bTitle.equals(bookList.get(i).getbTitle())) {
                    
                   String bStatus = bookList.get(i).isbAvailable();
 
                    if (bStatus.equals(stdf) == true ) {
                       bookList.get(i).setbAvailable(sttmp);
                       bookList.get(i).setbName("����");
                        System.out.println(">>>�ݳ��� �Ϸ�Ǿ����ϴ�.");
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
             System.out.println(">>>������ ��ܿ� �����ϴ�.");
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
             System.out.println(">>>" + title + " ������ �������� �ʾҽ��ϴ�.");
             showUser();
       }
    }
    
    
    // ��ü ��ȸ
    public void selectAll(){
    	for (BookProgram booklist : bookList)
    		System.out.println(booklist);}
        


    @Override
	public String toString() {
		return "Book [������" + " "+ bTitle + ", ���⿩��=" + bAvailable + ", ������=" + bName + "]";
	}
}
    
 
    
