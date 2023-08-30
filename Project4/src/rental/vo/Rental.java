package rental.vo;

import java.sql.Date;
import java.util.*;

public class Rental
{
		
		private Date reasDate;
		private Date returnDate;
		private String userName;
		private String userId;
		private int bookNo;
		private int reaseNo;
		private String bookName;
		
		public Rental() {}
		
		public Rental (Date reasDate, Date returnDate, String userName, String userId, int bookNo, int reaseNo, String bookName){
			super();
			
			
			this.reasDate = reasDate;
			this.returnDate = returnDate;
			
			this.userName	= userName;
			this.userId	= userId;
			this.bookNo = bookNo;
			this.reaseNo = reaseNo;
			this.bookName =bookName;
		}

		public Date getReasDate()
		{
			return reasDate;
		}
		public void setReasDate(Date reasDate)
		{
			this.reasDate = reasDate;
		}

		public Date getReturnDate()
		{
			return returnDate;
		}
			
		public void setReturnDate(Date returnDate)
		{
			this.returnDate = returnDate;
		}

		
		public String getUserName()
		{
			return userName;
		}
		
		
		public void setUserName(String userName)
		{
			this.userName = userName;
		}
		
		public String getUserId()
		{
			return userId;
		}
		
		public void setUserId(String userId)
		{
			this.userId = userId;
		}

		public int getBookNo()
		{
			
			return bookNo;
		}
		
		public void setBookNo(int bookNo)
		{
			this.bookNo = bookNo;
		}

		public int getReaseNo()
		{
			
			return reaseNo;
		}
		public void setReaseNo(int reaseNo)
		{
			this.reaseNo = reaseNo;
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
			return "Book [reasDate=" + reasDate + ", returnDate=" + returnDate + ", userName=" + userName
					+ ", userId=" + userId + ", bookNo=" + bookNo + ", reaseNo=" + reaseNo + "]";
		}

	
	}

