package Member.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Member.vo.*;

public class MemberDAO
{
ArrayList<Member> mList = null;

	public ArrayList<Member> allMember(Connection conn)
	{
		Statement stmt = null;
		ResultSet rset= null;
		String query = "select * from MemberDB order by UserNum";
		mList = new ArrayList<Member>();
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()){
				Member member = new Member();
				member.setUserNum(rset.getInt("userI"));
				member.setUserName(rset.getString("userName"));
				member.setUserId(rset.getString("userId"));
				
				member.setUserAge(rset.getInt("userAge"));
								
				mList.add(member);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return mList;
	}
	
	public ArrayList serchName(String name, Connection conn)
	{
		Statement stmt = null;
		ResultSet rset= null;
String query = "select * from MemberDB where UserName like '%"+name+"%'";
		
		try {
			stmt= conn.createStatement();
			rset= stmt.executeQuery(query);
			mList = new ArrayList<Member>();
			while(rset.next()) {

				Member member = new Member();
				
				member.setUserNum(rset.getInt("userNum"));
				member.setUserName(rset.getString("userName"));
				member.setUserId(rset.getString("userId"));
				
				member.setUserAge(rset.getInt("userAge"));
				
				mList.add(member);		
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mList;
	}

	public Member serchId(String userId, Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * from MemberDB where UserId ='"+userId+"'";
		
		Member member = null;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				member = new Member();
				member.setUserNum(rset.getInt("userNum"));
				member.setUserName(rset.getString("userName"));
				member.setUserId(rset.getString("userId"));
				
				member.setUserAge(rset.getInt("userAge"));
				
				
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return member;
	}

	public int insertMenu(Member member, Connection conn, int result2) {
		int result = 0;
		Statement stmt = null;
		String query = "insert into MemberDB values ("+ (result2+1)
				+", '"+member.getUserId()+"'"
				+", '"+member.getUserName()+"'"
				+",'"+member.getUserAge()+"'"+")";
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		
		
		return result;
	}

	public int countMember(Connection conn) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select UserId from MemberDB order by 1 desc";
		
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				result = rset.getInt("userId");
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		return result;
	}

	public int delMember(String userId, Connection conn) {
		int result = 0;
		Statement stmt = null;
		String query = "delete MemberDB where UserId ='"+userId+"'";
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

	public int updateMember(Member member, Connection conn) {
		Statement stmt = null;
		int result = 0;
		String query = "update MemberDB set userName = '"+member.getUserName()+"',"
				+" userAge ="+member.getUserAge()+""
				+" where userId = '"+member.getUserId()+"'";
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	public int countId(String userId, Connection conn) {
		
		Statement stmt = null;
		ResultSet rset = null;
		String query ="select count(*) as userId from MemberDB where UserId = '"+userId+"'";
		int result =0;
		try {
			stmt = conn.createStatement();
			rset=stmt.executeQuery(query);
			if(rset.next()) {
			result = rset.getInt("userID");
		

			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			stmt.close();
			rset.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

}