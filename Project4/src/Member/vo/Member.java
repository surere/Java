package Member.vo;

import java.util.Date;

public class Member
{
	private int userNo;
	private String userId;
	private String userName;
	private int userAge;
	private String Addr;
	private char gender;
	private Date enrollDate;
	
	public Member() {
		
	}
	public Member(int userNo, String userId, String userName, int userAge, String addr,
			char gender, Date enrollDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
		Addr = addr;
		this.gender = gender;
		this.enrollDate = enrollDate;
	}
	
	public int getUserNo()
	{
		return userNo;
	}
	public void setUserNo(int userNo)
	{
		this.userNo = userNo;
	}
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public int getUserAge()
	{
		return userAge;
	}
	public void setUserAge(int userAge)
	{
		this.userAge = userAge;
	}
	public String getAddr()
	{
		return Addr;
	}
	public void setAddr(String addr)
	{
		Addr = addr;
	}
	public char getGender()
	{
		return gender;
	}
	public void setGender(char gender)
	{
		this.gender = gender;
	}
	public Date getEnrollDate()
	{
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate)
	{
		this.enrollDate = enrollDate;
	}
	
	@Override
	public String toString() {
		return "Member [ userNo="+userNo + ", userId=" + userId + ", userName=" + userName + ", userAge=" + userAge
				+ ", Addr=" + Addr + ", gender=" + gender + ", enrollDate=" + enrollDate + "]";
	}
}
