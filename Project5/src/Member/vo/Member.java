package Member.vo;

import java.util.Date;

public class Member
{
	private int userNum;
	private String userId;
	private String userName;
	
	private int userAge;

	
	public Member() {
		
	}
	public Member(int userNum, String userId, String userName, int userAge
			) {
		super();
		this.userNum = userNum;
		this.userId = userId;
		this.userName = userName;
		
		this.userAge = userAge;
		
	}
	
	public int getUserNum()
	{
		return userNum;
	}
	public void setUserNum(int userNum)
	{
		this.userNum = userNum;
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
			
	@Override
	public String toString() {
		return "Member [ userNo="+userNum + ", userId=" + userId + ", userName=" + userName + ", userAge=" + userAge
				+ "]";
	}
}
