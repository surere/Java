package book.vo;


public class Book
{
	private int bookNumber;
	private String bookName;
	private int bookKwon;
	
	
	public Book() {}
	
	public Book (int bookNumber, String bookName, int bookKwon){
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.bookKwon	= bookKwon;
		
	}
	
	public int getBookNumber(){
		return bookNumber;		
	}
	public void setBookNumber(int bookNumber){
		this.bookNumber = bookNumber;		
		
	}
	public String getBookName(){
		return bookName;		
	}
	public void setBookName (String bookName){
		this.bookName = bookName;	
	}
	
	public int getBookKwon(){
		return bookKwon;		
	}
	public void setBookKwon (int bookKwon){
		this.bookKwon = bookKwon;	
	}
		
	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookName=" + bookName + ", bookKwon=" + bookKwon
				+ "]";
	}


}