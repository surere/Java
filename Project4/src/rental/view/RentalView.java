package rental.view;

import java.util.ArrayList;
import java.util.Scanner;

import rental.vo.Rental;

public class RentalView
{
public int RentalMenu() {
		
		System.out.println("1. 대여 관리 전체 조회\r\n" 
				+ "2. 회원 아이디로 대여 조회\r\n" 
				+ "3. 책 이름으로 대여 조회\r\n" 
				+ "4. 대여정보 추가\r\n"
				+ "5. 반납 정보 입력");
		System.out.println("6. 메인 메뉴로 이동");
		System.out.print("메뉴선택 : ");
		
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public void viewAll(ArrayList<Rental> rList) {
		for (int i  =0; i<rList.size();i++) {
			Rental rental = rList.get(i);
		System.out.println("=-=-=-=-==-=-=--=-=-");
		System.out.println("대여번호 : "+rental.getReaseNo());
		System.out.println("도서번호 : "+rental.getBookNo());
		System.out.println("도서명 : "+rental.getBookName());
		System.out.println("고객아이디 : "+rental.getUserId());
		System.out.println("고객이름 : "+rental.getUserName());
		System.out.println("대여일 : "+rental.getReasDate());
		System.out.println("반납일 : "+rental.getReturnDate());
		}
		System.out.println("=-=-=-=-=-=-=-=-=-=-");
	}

	public String serchId() {
		System.out.print("아이디 : ");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	public void FailMessage(String string) {
		System.out.println("[시스템 결과] : "+string+"실패");
		
	}

	public String serchBook() {
		Scanner sc = new Scanner(System.in);
		System.out.print("책 이름 : ");
		
		return sc.nextLine();
	}

	public Rental setRental() {
		Rental rental = new Rental();
		System.out.println("=-=-=-=-=대여정보 입력 =-=-=-=-=-=");
		
		return rental;
	}

	public void successMessage(String string) {
		System.out.println("[시스템 결과] : "+string+"성공");
		
	}

	public int serchLeaseNo() {
		System.out.print("대여 코드 입력 : ");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	

}

