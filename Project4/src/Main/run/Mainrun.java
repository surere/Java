package Main.run;

import Main.view.Mainview;
import book.view.*;
//import Member.Run.MemberRun;
import book.run.*;
import book.run.BookRun;

public class Mainrun
{

	public static void main(String[] args)
	{
		Mainview view = new Mainview();
				
		int choice = 0;
			
			while(true) {
				choice = view.Main();
			switch(choice) {
				case 0 : 
					System.out.println("프로그램을 종료합니다.");
					break;
				case 1 : BookRun bRun = new BookRun(); // 책 관리
						bRun.main(args);
						break;
				/*case 2 : MemberRun bRun= new MemberRun(); //회원관리
						cRun.main(args);
						break;
				
				case 3 : RentalRun rRun = new RentalRun(); //대여관리
						rRun.main(args);
						break;*/
					
				case 4 : System.out.println("입력오류");;
						break;
					
					default:
					System.out.println("입력오류");
					break;
					}
			
				}
			}
		}
	



