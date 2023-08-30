package PJ4;
import java.util.Scanner;

import Member.Run.MemberRun;
import book.run.BookRun;
import rental.run.RentalRun;



public class Mainview
{
	
		public int Main() {
			Scanner sc = new Scanner(System.in);
		
			System.out.println("-------------------");
			System.out.println("1. 책 등록");
			System.out.println("2. 책 조회");
			System.out.println("3. 책 전체 리스트 조회");
			System.out.println("4. 책 삭제");
			System.out.println("0. 종료");
			System.out.println("선택 : ");
			return sc.nextInt();
		}
			
		public class Mainrun{
			public static void main(String[] args) {
				
				Mainview view = new Mainview();
				
				int choice = 0;
			
			while(true) {
				choice = view.Main();
			switch(choice) {
				case 0 : 
					System.out.println("프로그램을 종료합니다.");
					break;
				case 1 : BookRun bRun = new BookRun(); //책 등록
						bRun.main(args);
						break;
				case 2 : CheckRun cRun= new CheckRun(); //책 조회
						cRun.main(args);
						break;
				
				case 3 :ListRun lRun= new ListRun(); //전체리스트
						lRun.main(args);
						break;
					
					break;
				case 4 : DeletRun dRun= new DeletRun(); //책삭제
						dRun.main(args);
						break;
						
					default:
					System.out.println("입력오류");
					break;
					}
			
				}
			}
		}
}