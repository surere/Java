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
		String query = "select * from customer order by user_no";
		mList = new ArrayList<Member>();
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()){
				Member member = new Member();
				member.setUserNo(rset.getInt("user_no"));
				member.setUserName(rset.getString("user_name"));
				member.setUserId(rset.getString("user_id"));
				member.setUserAge(rset.getInt("user_age"));
				member.setGender(rset.getString("gender").charAt(0));
				member.setEnrollDate(rset.getDate("enroll_date"));
				member.setAddr(rset.getString("addr"));
				
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
String query = "select * from customer where user_name like '%"+name+"%'";
		
		try {
			stmt= conn.createStatement();
			rset= stmt.executeQuery(query);
			mList = new ArrayList<Member>();
			while(rset.next()) {

				Member member = new Member();
				
				member.setUserNo(rset.getInt("user_no"));
				member.setUserName(rset.getString("user_name"));
				member.setUserId(rset.getString("user_id"));
				member.setUserAge(rset.getInt("user_age"));
				member.setAddr(rset.getString("addr"));
				member.setGender(rset.getString("gender").charAt(0));
				member.setEnrollDate(rset.getDate("enroll_date"));
				
				mList.add(member);		
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mList;
	}

	public Member serchId(String memberId, Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * from customer where user_id ='"+memberId+"'";
		
		Member member = null;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				member = new Member();
				member.setUserNo(rset.getInt("user_no"));
				member.setUserName(rset.getString("user_name"));
				member.setUserId(rset.getString("user_id"));
				member.setUserAge(rset.getInt("user_age"));
				member.setAddr(rset.getString("addr"));
				member.setGender(rset.getString("gender").charAt(0));
				member.setEnrollDate(rset.getDate("enroll_date"));
				
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return member;
	}

	public int insertMenu(Member member, Connection conn, int result2) {
		int result = 0;
		Statement stmt = null;
		String query = "insert into customer values ("+ (result2+1)
				+", '"+member.getUserId()+"'"
				+", '"+member.getUserName()+"'"
				+","+member.getUserAge()+""
				+", '"+member.getAddr()+"'"
				+",'"+member.getGender()+"',"
				+"sysdate)";
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
		String query = "select user_no from customer order by 1 desc";
		
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				result = rset.getInt("user_no");
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		return result;
	}

	public int delMember(String memberId, Connection conn) {
		int result = 0;
		Statement stmt = null;
		String query = "delete customer where user_id ='"+memberId+"'";
		
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
		String query = "update customer set user_name = '"+member.getUserName()+"',"
				+" user_age ="+member.getUserAge()+","
				+"addr = '"+member.getAddr()+"' where user_id = '"+member.getUserId()+"'";
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	public int countId(String memberId, Connection conn) {
		
		Statement stmt = null;
		ResultSet rset = null;
		String query ="select count(*) as user_id from customer where user_id = '"+memberId+"'";
		int result =0;
		try {
			stmt = conn.createStatement();
			rset=stmt.executeQuery(query);
			if(rset.next()) {
			result = rset.getInt("user_id");
		

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