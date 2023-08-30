import java.util.Scanner;

public class Book_test
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		BookManager bm = new BookManager();
		
		int num = 0;
		
		do {
			System.out.println("-------------------");
			System.out.println("1. 책 등록");
			System.out.println("2. 책 조회");
			System.out.println("3. 책 전체 리스트 조회");
			System.out.println("4. 책 삭제");
			System.out.println("5. 종료");
			System.out.println("-------------------");
			
			num = sc.nextInt();
			
			if(num == 1) {
				//책 등록
				System.out.println("아래 항목을 입력해주세요: ");
				
				System.out.print("책 번호: ");
				String title = sc.next();

				System.out.print("책 제목: ");
				String title2 = sc.next();
				
				System.out.print("책 권수: ");
				String title3 = sc.next();
				
				bm.add(title, title2, title3);
			}
			else if(num ==2) {
				//책 검색
				System.out.println("검색할 책의 제목을 입력하세요: ");
				String title = sc.next();
				bm.searchByTitle(title);
				
			}
			else if(num == 3) {
				//책 전체 리스트
				bm.getList();
			}
			else if(num == 4) {
				//책 삭제
				System.out.print("삭제할 책의 제목을 입력하세요: ");
				String title = sc.next();
				bm.remove(title);
			}
				
				
		}while(num != 5);
		System.out.println("프로그램을 종료합니다.");
	}

}
