//run에서 받아온 값들을 dao클래스로 보내는 역할만 함
package book.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.vo.Book;

public class BookDAO
{
	ArrayList<Book> bList = null;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "study";
	private final String PASSWORD = "1234";
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	Book book = null;
	
	public ArrayList<Book> allBook()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from book order by book_no";
		bList = new ArrayList<Book>();
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				book = new Book();
				book.setBookNumber(rset.getInt(1));
				book.setBookName(rset.getString(2));
				book.setBookWriter(rset.getString(3));
				book.setBookPrice(rset.getInt(4));
				book.setPublisher(rset.getString(5));
				book.setGenre(rset.getString(6));
				bList.add(book);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return bList;
	}
public Book serchBNo(int bNo)
{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rset	=  null;
	String query = "select * from book where book_no = ?";
	
	try {
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1,bNo);
		rset = pstmt.executeQuery();
		
		if (rset.next()) {
			book = new Book();
			book.setBookNumber(rset.getInt(1));
			book.setBookName(rset.getString(2));
			book.setBookWriter(rset.getString(3));
			book.setBookPrice(rset.getInt(4));
			book.setPublisher(rset.getString(5));
			book.setGenre(rset.getString(6));
		}
	} catch(ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			conn.close();
			pstmt.close();
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return book;
}
	public int addBook(Book book, int i) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into book values (?, ?, ?)";
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,i+1);
			pstmt.setString(2, book.getBookName());
			pstmt.setString(3, book.getBookWriter());
			pstmt.setInt(4, book.getBookPrice());
			pstmt.setString(5, book.getPublisher());
			pstmt.setString(6, book.getGenre());
			
			result = pstmt.executeUpdate();
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int allBookList()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rset = null;
		String query = "select bookNum from bookDB order by 1 desc";
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
				
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		}
		
		return result;

	}
	
	public int delBook(int bNo)
	{
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "delete book where book_no=?";
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNo);
			result = pstmt.executeUpdate();
		
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
	
