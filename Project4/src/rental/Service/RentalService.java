package rental.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Member.common.JDBCTemplate;
import rental.DAO.rentalDAO;
import rental.vo.Rental;

public class RentalService
{
	JDBCTemplate jdbctemplate;
	rentalDAO rDao;
	int result = 0;
	
	public RentalService() {
		jdbctemplate=JDBCTemplate.getInstance();
		rDao= new rentalDAO();
		
		
	}

	public ArrayList<Rental> allList() {
		ArrayList<Rental> rList = new ArrayList<Rental>();
		rDao = new rentalDAO();
		Connection conn = null;
		
		try {
			conn = jdbctemplate.createConnection();
			rList = rDao.allList(conn);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rList;
	}

	public ArrayList<Rental> serchId(String userid) {
		ArrayList<Rental> rList = new ArrayList<Rental>();
		Connection conn = null;
		rDao = new rentalDAO();
		
		try {
			conn = jdbctemplate.createConnection();
			rList = rDao.serchRentalId(userid, conn);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbctemplate.close();
		}
		
		
		return rList;
	}

	public ArrayList<Rental> serchName(String bookName) {
		ArrayList<Rental> rList = new ArrayList<Rental>();
		Connection conn = null;
		rDao = new rentalDAO();
		
		try {
			conn = jdbctemplate.createConnection();
			rList = rDao.serchRentalBook(bookName, conn);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			jdbctemplate.close();
		}
		
		return rList;
	
	}

	public int CountRental(String bookName) {
		Connection conn;
		int rentalCount=0;
		try {
			conn = jdbctemplate.createConnection();
			rentalCount = rDao.CountRental(bookName,conn);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbctemplate.close();
		}
		
		
		return rentalCount;
	}

	public int BookCheck(String bookName) {
		Connection conn;
		int rentalCount=0;
		try {
			conn = jdbctemplate.createConnection();
			rentalCount = rDao.BookChek(bookName,conn);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbctemplate.close();
		}
		
		
		return rentalCount;
	}

	public int UserCheck(String userid) {
		Connection conn;
		int userCount=0;
		try {
			conn = jdbctemplate.createConnection();
			userCount = rDao.userChek(userid,conn);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbctemplate.close();
		}
		
		
		return userCount;
	}

	public int insertRental(Rental rental) {
		rDao = new rentalDAO();
		Connection conn = null;
		int result = 0;
		
		try {
			conn= jdbctemplate.createConnection();
			result = rDao.insertRental(rental, conn);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	public int foundBookNo(String bookName) {
		rDao = new rentalDAO();
		Connection conn = null;
		int bookNo = 0;
		
		try {
			conn= jdbctemplate.createConnection();
			bookNo = rDao.foundBookNo(bookName, conn);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bookNo;
	}

	public int foundLeaseNo() {
		rDao = new rentalDAO();
		Connection conn = null;
		int leaseNo = 0;
		
		try {
			conn= jdbctemplate.createConnection();
			leaseNo = rDao.foundleaseNo(conn);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		jdbctemplate.close();
		}
		
		
		return leaseNo;
	}

	public int retrunBook(int lease_no) {
		Connection conn = null;
		rDao = new rentalDAO();
		int result = 0 ;
		
		try {
			conn=jdbctemplate.createConnection();
			result = rDao.returnBook(lease_no, conn);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} {
			jdbctemplate.close();
			}
		return result;
	}
	

}

