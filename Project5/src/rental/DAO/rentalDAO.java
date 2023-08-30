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
		String query = "select leaseNo, bookNum,userId,Leasdate,returndate,bookname from RentalDB left join bookDB using (bookNum) "
				+ "left join MemberDB using (userId)  order by leaseNo";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			rList = new ArrayList<Rental>();
			while (rset.next()) {
				Rental rental = new Rental();
				rental.setLeaseNo(rset.getInt(1));
				rental.setBookNum(rset.getInt(2));
				rental.setUserId(rset.getString(3));
				rental.setLeasDate(rset.getDate(4));
				rental.setReturnDate(rset.getDate(5));
				rental.setBookName(rset.getString(6));
				
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
		String query = "select leaseno, bookNum,userNum,Leasdate,returndate, bookName  from RentalDB left join bookDB using (bookNum)" + 
				"left join MemberDB using (userId) where userId= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			rset = pstmt.executeQuery();
			
			rList = new ArrayList<Rental>();
			while(rset.next()) {
				Rental rental = new Rental();
				rental.setLeaseNo(rset.getInt(1));
				rental.setBookNum(rset.getInt(2));
				rental.setUserId(rset.getString(3));
				rental.setLeasDate(rset.getDate(4));
				rental.setReturnDate(rset.getDate(5));
				rental.setBookName(rset.getString(6));
				
				
				rList.add(rental);
				
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return rList;
	}

	public ArrayList<Rental> serchRentalBook(String bookName, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select leaseNo, bookNum, userId, Leasdate ,returndate, bookName from RentalDB left join bookDB using (bookNum)" + 
				"left join MemberDB using (userId) where bookName= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookName);
			rset = pstmt.executeQuery();
			
			rList = new ArrayList<Rental>();
			while(rset.next()) {
				Rental rental = new Rental();
				rental.setLeaseNo(rset.getInt(1));
				rental.setBookNum(rset.getInt(2));
				rental.setUserId(rset.getString(3));
				rental.setLeasDate(rset.getDate(4));
				rental.setReturnDate(rset.getDate(5));
				rental.setBookName(rset.getString(6));
				
				
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
		String query = "select count(*) from RentalDB left join bookDB using (bookNum)" + 
				" left join MemberDB using (userid)"
				+ " where bookName= ? ";
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
		String query = "select count(*) from bookDB"
				+ " where bookName= ? ";
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
		String query = "select count(*) from MemberDB"
				+ " where userId= ? ";
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
		String query = "insert into RentalDB values(?,sysdate,sysdate+7,?,?)";

		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rental.getLeaseNo());

			pstmt.setString(2, rental.getUserId());
			System.out.println(rental.getUserId());
			System.out.println(rental.getBookNum());
			pstmt.setInt(3, rental.getBookNum());
		
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
		String query = "select bookNum from bookDB"
				+ " where bookName= ? ";
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
		String query = "select leaseNo from RentalDB order by 1 desc";
				 
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
		String query = "delete RentalDB where leaseNo = ?";
		
		
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

