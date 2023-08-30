package rental.DAO;

import java.sql.*;
import java.text.*;
import java.util.*;

import Member.common.*;
import rental.vo.Rental;

import Member.vo.*;
import book.vo.*;

public class rentalDAO
{
	ArrayList rList = null;

	public ArrayList<Rental> allList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select lease_no, book_no,user_Id,lease_date,return_date,book_name,user_name  from library left join book using (book_no) "
				+ "left join customer using (user_id)  order by lease_no";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			rList = new ArrayList<Rental>();
			while (rset.next()) {
				Rental rental = new Rental();
				rental.setReaseNo(rset.getInt(1));
				rental.setBookNo(rset.getInt(2));
				rental.setUserId(rset.getString(3));
				rental.setReasDate(rset.getDate(4));
				rental.setReturnDate(rset.getDate(5));
				rental.setBookName(rset.getString(6));
				rental.setUserName(rset.getString(7));
				rList.add(rental);

			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return rList;
	}

	public ArrayList<Rental> serchRentalId(String userid, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select lease_no, book_no,user_Id,lease_date,return_date,book_name,user_name  from library left join book using (book_no)" + 
				"left join customer using (user_id) where user_id= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			rset = pstmt.executeQuery();
			
			rList = new ArrayList<Rental>();
			while(rset.next()) {
				Rental rental = new Rental();
				rental.setReaseNo(rset.getInt(1));
				rental.setBookNo(rset.getInt(2));
				rental.setUserId(rset.getString(3));
				rental.setReasDate(rset.getDate(4));
				rental.setReturnDate(rset.getDate(5));
				rental.setBookName(rset.getString(6));
				rental.setUserName(rset.getString(7));
				
				rList.add(rental);
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rList;
	}

	public ArrayList<Rental> serchRentalBook(String bookName, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select lease_no, book_no,user_Id,lease_date,return_date,book_name,user_name  from library left join book using (book_no)" + 
				"left join customer using (user_id) where book_name= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookName);
			rset = pstmt.executeQuery();
			
			rList = new ArrayList<Rental>();
			while(rset.next()) {
				Rental rental = new Rental();
				rental.setReaseNo(rset.getInt(1));
				rental.setBookNo(rset.getInt(2));
				rental.setUserId(rset.getString(3));
				rental.setReasDate(rset.getDate(4));
				rental.setReturnDate(rset.getDate(5));
				rental.setBookName(rset.getString(6));
				rental.setUserName(rset.getString(7));
				
				rList.add(rental);
						
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return rList;
	}

	public int CountRental(String bookName, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) from library left join book using (book_no) left join customer using (user_id)"
				+ " where book_name= ? ";
		int Count =0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookName);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				Count = rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		
		
		return Count;
	}

	public int BookChek(String bookName, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) from book"
				+ " where book_name= ? ";
		int Count =0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookName);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				Count = rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		
		
		return Count;
	}

	public int userChek(String userid, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) from customer"
				+ " where user_id= ? ";
		int Count =0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				Count = rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		return Count;
	}

	public int insertRental(Rental rental,Connection conn) {

		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into library values(?,?,?,sysdate,sysdate+3)";

		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rental.getReaseNo());

			pstmt.setInt(2, rental.getBookNo());

			pstmt.setString(3, rental.getUserId());
		
			result = pstmt.executeUpdate();
			conn.commit();
			

			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
		return result;
	}

	public int foundBookNo(String bookName, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select book_no from book"
				+ " where book_name= ? ";
		int bookNo =0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookName);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				bookNo = rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		return bookNo;
	}

	public int foundleaseNo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select lease_no from library order by 1 desc";
				 
		int leaseNo =0;
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				leaseNo= rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		return leaseNo+1;
	}

	public int returnBook(int lease_no, Connection conn) {
		PreparedStatement pstmt = null;
		int result =0;
		String query = "delete library where lease_no = ?";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, lease_no);
			result = pstmt.executeUpdate();
			if(result==1) {
			conn.commit();}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return result ;
	}

}

