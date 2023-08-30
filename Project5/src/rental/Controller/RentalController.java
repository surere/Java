package rental.Controller;

import java.util.ArrayList;

import rental.Service.RentalService;
import rental.vo.*;
import Member.vo.*;
import book.vo.*;

public class RentalController
{
RentalService rServer;
	
	public ArrayList<Rental> allList() {
		ArrayList<Rental> rList = new ArrayList<Rental>();
		rServer = new RentalService();
		rList = rServer.allList();
		
		return rList;
	}

	public ArrayList<Rental> serchId(String userid) {
		ArrayList<Rental> rList = new ArrayList<Rental>();
		rServer = new RentalService();
		rList = rServer.serchId(userid);
		
		return rList;
	}

	public ArrayList<Rental> serchBook(String bookName) {
		ArrayList<Rental> rList = new ArrayList<Rental>();
		rServer = new RentalService();
		rList = rServer.serchName(bookName);
		return rList;
	}

	public int contRental(String bookName) {
		rServer = new RentalService();
		int rentalCount = rServer.CountRental(bookName);
		return rentalCount;
	}

	public int bookCheck(String bookName) {
		rServer = new RentalService();
		int rentalCount = rServer.BookCheck(bookName);
		return rentalCount;
	}

	public int checkId(String userid) {
		rServer = new RentalService();
		int userCheck = rServer.UserCheck(userid);
		return userCheck;
	}

	public int addRental(Rental rental) {
		rServer = new RentalService();
		 int result = rServer.insertRental(rental);
		return result;
	}

	public int serchBookNo(String bookName) {
		rServer = new RentalService();
		int bookNo = rServer.foundBookNo(bookName);
		return bookNo;
	}

	public int leaseNo() {
		rServer = new RentalService();
		int leaseNo = rServer.foundLeaseNo();
		return leaseNo;
	}

	public int returnBook(int leaseNo) {
		rServer = new RentalService();
		int result = rServer.retrunBook(leaseNo);
		return result;
	}

}

