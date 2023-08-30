package Main.view;

import java.util.Scanner;

public class Mainview
{
	
	
	public int Main()
	{
	Scanner sc = new Scanner(System.in);
	System.out.println("------------------------------");
	System.out.println("1. 책 관리");
	System.out.println("2. 회원관리");
	System.out.println("3. 대여 관리");
	System.out.println("0. 프로그램 종료");
	System.out.println("선택 :  ");
	return sc.nextInt();
 	}
}