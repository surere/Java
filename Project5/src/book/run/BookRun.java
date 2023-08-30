package book.run;
import java.util.ArrayList;

import book.controller.BookController;
import Main.run.Mainrun;
import book.view.BookView;
import book.vo.Book;

public class BookRun
{
	public static void main(String[] args)
	{
		BookView bView = new BookView();
		ArrayList<Book> bList = new ArrayList<book.vo.Book>();
		BookController bCont = new BookController();
		Book book = null;
		
		while(true) {
			int choice = bView.mainMenu();
		switch(choice) {
			case 1 : //책조회
				bList = bCont.allBook();
				if(bList.isEmpty()) {bView.failMessge("조회");}
				else {
					bView.ShowAllBook(bList);
				}
				break;
			case 2 : //코드로 조회
					int bNo = bView.serchBNo();
					book = bCont.serchBno(bNo);
					if(book == null) {
						bView.failMessge("조회");
					}else {
						bView.serchBook(book);}
					
					break;
					
			case 3 : //추가하기
					int result = bCont.allBookList();
					book = bView.addBook();
					result = bCont.addbook(book, result);
					if(result == 0) {bView.failMessge("추가");}
					else {bView.successMassge("추가");}
					
					break;
			
			case 4 ://삭제하기
				bNo = bView.serchBNo();
				result = bCont.deleteBook(bNo);
				if(result == 0) {bView.failMessge("삭제");}
				else {bView.successMassge("삭제");}
				
				break;
			case 5 : Mainrun mRun = new Mainrun();
					mRun.main(args);
					break;
					
				default:
				System.out.println("입력오류");
				break;
			}
		}
	}

}
