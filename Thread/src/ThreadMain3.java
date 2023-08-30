import java.io.*;
import java.lang.*;
import java.util.Scanner;

public class ThreadMain3
{
	public ThreadMain3() {
	}
	//생성자
	public void init() // 초기화 메서드, 입력 메서드
	{
		System.out.println("숫자를 입력해 주시요.");
		Scanner s = new Scanner(System.in);
		String s_num = s.nextLine();
		int n_num = Integer.parseInt(s_num);
	
		try {
			Thread tsub = new ThreadSub(n_num);
			tsub.start();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		System.out.println("이름을 입력해 주세요.");
		String s_name = s.nextLine();
	}
	
	public static void main(String[] args)
	{
		// 객체 생성
		ThreadMain3 tm = new ThreadMain3();
		tm.init();
	}
	
	class ThreadSub extends Thread
	{
		int nNum;
		
		public ThreadSub(int num)
		{
			this.nNum = num;
		}
	
		@Override
		public void run() {
			int i = 0;
			while (i<nNum) {
				try {
					Thread.sleep(1000);
					i = i+ 1;
					System.out.println("Thread : " +i);
					
				}catch(Exception e) {
					System.out.println("예외 : " +e);
				}
			}
		}
	}
}
