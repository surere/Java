package book.vo;


public class Book
{
	private int bookNumber;
	private String bookName;
	private String bookWriter;
	private int bookPrice;
	private String publisher;
	private String genre;
	
	public Book() {}
	
	public Book (int bookNumber, String bookName, String bookWriter, int bookPrice, String publisher, String genre){
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.bookWriter	= bookWriter;
		this.bookPrice = bookPrice;
		this.publisher = publisher;
		this.genre = genre;
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
	
	public String getBookWriter(){
		return bookWriter;		
	}
	public void setBookWriter (String BookWriter){
		this.bookWriter = bookWriter;	
	
	}
	public int getBookPrice(){
		return bookPrice;		
	}
	public void setBookPrice (int bookPrice){
		this.bookPrice = bookPrice;		
		
	}
	
	public String getPublisher(){
		return publisher;		
	}
	public void setPublisher (String publisher){
		this.publisher = publisher;	
	}
	
	public String getGenre(){
		return genre;		
	}
	public void setGenre (String genre){
		this.genre = genre;	
	}
	
	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookName=" + bookName + ", bookWriter=" + bookWriter
				+ ", bookPrice=" + bookPrice + ", publisher=" + publisher + ", genre=" + genre + "]";
	}


}