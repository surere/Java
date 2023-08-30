package Member.view;

import java.util.ArrayList;
import java.util.Scanner;

import Member.vo.Member;

public class MemberView
{
	public int mainMenu()
	{
		System.out.println("---------회원관리-----------");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 이름 조회");
		System.out.println("3. 회원 아이디로 조회");
		System.out.println("4. 회원 가입");
		System.out.println("5. 회원 정보 수정");
		System.out.println("6. 회원 탈퇴");
		System.out.println("7. 메인 메뉴로 이동");
		System.out.print("선택: ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		return choice;
	}
	
	public String serchName()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");
		return sc.next();
	}
	public void failMessage(String string)
	{
		System.out.println("[서비스 결과] : "+string+"실패");
	}
	public void successMessage(String string)
	{
		System.out.println("[서비스 결과] : "+string+"실패");
	}
	public void allMember(ArrayList<Member> mList)
	{
		System.out.println("-------회원전체조회---------");
		for(Member member : mList) {
			System.out.println("회원번호 : "+member.getUserNo());
			System.out.println("이름 : "+member.getUserName());
			System.out.println("아이디 : "+member.getUserId());
			System.out.println("주소 : "+member.getAddr());
			System.out.println("나이 : "+member.getUserAge());
			System.out.println("성별 : "+member.getGender());
			System.out.println("가입일 : "+member.getEnrollDate());
			System.out.println("---------------------------");
		}
	}
	public String serchId()
	{
		System.out.println("아이디:");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	public void viewMember(Member member)
	{
		System.out.println("회원번호 : "+member.getUserNo());
		System.out.println("이름 : "+member.getUserName());
		System.out.println("아이디 : "+member.getUserId());
		System.out.println("주소 : "+member.getAddr());
		System.out.println("나이 : "+member.getUserAge());
		System.out.println("성별 : "+member.getGender());
		System.out.println("가입일 : "+member.getEnrollDate());
		System.out.println("---------------------------");
	}
	public Member insertMember()
	{
		Scanner sc = new Scanner(System.in);
		Member member = new Member();
		System.out.print("이름: ");
		member.setUserName(sc.next());
		
		System.out.print("아이디: ");
		member.setUserId(sc.next());
		
		System.out.print("주소: ");
		sc.nextLine();
		member.setAddr(sc.nextLine());
		
		System.out.print("나이: ");
		member.setUserAge(sc.nextInt());
		
		System.out.print("성별: ");
		member.setGender(sc.next().charAt(0));
		return member;
		
	}
	
	public Member updateMember()
	{
		Scanner sc = new Scanner(System.in);
		Member member = new Member();
		System.out.print("이름: ");
		member.setUserName(sc.next());
		System.out.print("주소: ");
		sc.nextLine();
		member.setAddr(sc.nextLine());
		System.out.print("나이: ");
		member.setUserAge(sc.nextInt());
		return member;
	}
	
}
