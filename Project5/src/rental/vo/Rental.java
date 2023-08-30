package rental.vo;

import java.sql.Date;
import java.util.*;

public class Rental
{
		private int leaseNo;
		private Date leasDate;
		private Date returnDate;
		private int bookNum;
		private String bookName;
		private String userId;
		private int userNum;
		
		public Rental() {}
		
		public Rental (int leaseNo, Date leasDate, Date returnDate, String bookName, int bookNum, String userId, int userNum){
			super();
			
			this.leaseNo = leaseNo;
			this.leasDate = leasDate;
			this.returnDate = returnDate;
			this.bookName = bookName;
			this.bookNum = bookNum;
			this.userId	= userId;
			this.userNum = userNum;

		}

		public Date getLeasDate()
		{
			return leasDate;
		}
		public void setLeasDate(Date leasDate)
		{
			this.leasDate = leasDate;
		}

		public Date getReturnDate()
		{
			return returnDate;
		}
			
		public void setReturnDate(Date returnDate)
		{
			this.returnDate = returnDate;
		}

		
		public int getBookNum()
		{
			return bookNum;
		}
		
		
		public void setBookNum(int bookNum)
		{
			this.bookNum = bookNum;
		}
		
		public String getUserId()
		{
			return userId;
		}
		
		public void setUserId(String userId)
		{
			this.userId = userId;
		}

		public int getLeaseNo()
		{
			
			return leaseNo;
		}
		public void setLeaseNo(int leaseNo)
		{
			this.leaseNo = leaseNo;
		}
		
		public int getUserNum()
		{
			return userNum;
		}
		
		public void setUserNum(int userNum)
		{
			this.userNum = userNum;
		}
		
		public String getBookName()
		{
			return bookName;
		}
		
		public void setBookName(String bookName)
		{
			this.bookName = bookName;
		}

		@Override
		public String toString() {
			return "Book [leaseNo=" + leaseNo + ", leasDate=" + leasDate + ", returnDate=" + returnDate + ", bookName = " + bookName +", bookNum=" + bookNum
					+ ", userId=" + userId + ", userNum=" + userNum + "]";
		}

	
	}

