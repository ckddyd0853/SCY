package LibraryProgram;

public class BookManager1 {
	
	private String bookname;
	public String loan;
	public String loanname;
	
	public BookManager1(String bookname, String loan, String loanname) {
		
		super();
		
		this.bookname = bookname;
		this.loan = loan;
		this.loanname = loanname;
	}


	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getLoan() {
		return loan;
	}

	public void setLoan(String loan) {
		this.loan = loan;
	}

	public String getLoanname() {
		return loanname;
	}

	public void setLoanname(String loanname) {
		this.loanname = loanname;
	}

	

	@Override
	public String toString() {
		return "Book [도서명" + " "+ bookname + ", 대출여부=" + loan + ", 대출자=" + loanname + "]";
	}
	
	
	
}

