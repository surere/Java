package Member.server;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Member.common.JDBCTemplate;
import Member.dao.*;
import Member.vo.*;



public class MemberServer
{
	ArrayList mList = null;
	private JDBCTemplate jdbcTemplate;
	private MemberDAO mDao;
	int result = 0;
	
	public MemberServer()
	{
		jdbcTemplate = JDBCTemplate.getInstance();
		mDao = new MemberDAO();
	}
	
	public ArrayList<Member> serchName(String name){
		mList = new ArrayList<Member>();
		try {
			Connection conn = jdbcTemplate.createConnection();
			mList = mDao.serchName(name, conn);
			
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			jdbcTemplate.close();
		}
		
		return mList;
	}
	
	public ArrayList<Member> allMember()
	{
		mList = new ArrayList<Member>();
		try {
			Connection conn = jdbcTemplate.createConnection();
			mList = mDao.allMember(conn);
		}catch (ClassNotFoundException |  SQLException e) {
			e.printStackTrace();
		}finally {
			jdbcTemplate.close();
		}
		
		return mList;
	}
	
	public Member serchId(String userId)
	{
		Member member = new Member();
		Connection conn;
		try {
			conn = JDBCTemplate.createConnection();
			member = mDao.serchId(userId, conn);
	}catch (ClassNotFoundException |  SQLException e) {
		e.printStackTrace();
	}finally {
		jdbcTemplate.close();
	}
		return member;
	}
	
	public int insertMember(Member member, int result2){
		int result = 0;
		Connection conn;
		try {
			conn = jdbcTemplate.createConnection();
			result = mDao.insertMenu(member, conn, result2);
		}catch(ClassNotFoundException |  SQLException e) {
			e.printStackTrace();
		}finally {
			jdbcTemplate.close();
	}
		return result;
	}
	public int countMember()
	{
		Connection conn;
		try {
			conn = jdbcTemplate.createConnection();
			result = mDao.countMember(conn);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			jdbcTemplate.close();
	}
		return result;
	}
	public int delMember(String userId)
	{
		try {
			Connection conn = jdbcTemplate.createConnection();
			result = mDao.delMember(userId, conn);
			
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			jdbcTemplate.close();
	}
	
	return result;
}

public int updateMem(Member member)
{
	try {
		Connection conn = jdbcTemplate.createConnection();
		result = mDao.updateMember(member, conn);
	}catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}finally {
		jdbcTemplate.close();
	}
	
	return result;
}

public int countId(String userId)
{
	int result = 0;
	try {
		Connection conn = jdbcTemplate.createConnection();
		result = mDao.countId(userId, conn);
	}catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	
	return result;
	
	}
}
