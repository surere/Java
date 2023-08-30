package Member.Controller;

import java.util.ArrayList;

import Member.dao.*;
import Member.server.MemberServer;
import Member.vo.*;


public class MemberController
{
	ArrayList<Member> mList	= null;
	MemberDAO mDao = new MemberDAO();
	MemberServer mServer = null;
	
	public ArrayList<Member> allMember()
	{
		mServer = new MemberServer();
		mList = mServer.allMember();
		
		return mList;
	}
	
	public ArrayList<Member> serchName(String name)
	{
		mServer = new MemberServer();
		mList = mServer.serchName(name);
		
		return mList;
		
	}
	
	public Member serchId(String memberId)
	{
		mServer = new MemberServer();
		Member member = mServer.serchId(memberId);
		
		return member;
		
	}
	
	public int insertMember(Member member, int result2)
	{
		int result = 0;
		mServer = new MemberServer();
		result = mServer.insertMember(member, result2);
		
		return result;
	}
	
	public int countMember()
	{
		mServer = new MemberServer();
		int result = mServer.countMember();
		return result;
		
	}
	
	public int delMember(String memberId){
		mServer = new MemberServer();
		int result = mServer.delMember(memberId);
		return result;
	}
	
	public int updateMember(Member member)
	{
		mServer = new MemberServer();
		int result = mServer.updateMem(member);
		return result;
		
	}
	
	public int countId(String memberId)
	{
		mServer = new MemberServer();
		int result = 0;
		result = mServer.countId(memberId);
		return result;
	}
		
}
