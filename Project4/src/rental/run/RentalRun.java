package rental.run;

import java.util.ArrayList;

import Main.run.*;
import Main.view.*;
import rental.Controller.*;
import rental.view.*;
import rental.vo.Rental;

public class RentalRun
{
	public static void main(String[] args)
	{
		RentalView rView = new RentalView();
		RentalController rCont = new RentalController();
		ArrayList<Rental> rList = null;
		
		 while (true) {
			int choice = rView.RentalMenu();
			switch (choice) {
			case 1://대여전체조회
				rList = rCont.allList();
				rView.viewAll(rList);
				break;
		case 2://회원아이디로 대여조회
			String userid = rView.serchId();
			rList = rCont.serchId(userid);
			if(rList.isEmpty()) {
				rView.FailMessage("대여 확인");
			}else {
				rView.viewAll(rList);
			}
			
			break;
		case 3://책이름으로 조회
			String bookName = rView.serchBook();
			rList = rCont.serchBook(bookName);
			if(rList.isEmpty()) {
				rView.FailMessage("대여 확인");
			}else {
				rView.viewAll(rList);
			}
			
			break;
		case 4://대여정보추가
			bookName = rView.serchBook();
			int rentalCount = rCont.contRental(bookName);
			if (rentalCount!=0) {
				rView.FailMessage("이미 대여된 책입니다, 대여");
			}else {
			rentalCount=rCont.bookCheck(bookName);
			if (rentalCount==0) {
				rView.FailMessage("도서관에 구비되지 않은 책입니다, 대여");
			}else {
				Rental rental = new Rental();
				userid = rView.serchId();
				int userCheck = rCont.checkId(userid);
				if(userCheck == 0 ) {
					rView.FailMessage("가입하지 않은 회원입니다, 대여");
					
				}else {
					rental.setUserId(userid);
					rental.setBookName(bookName);
					int bookNo = rCont.serchBookNo(bookName);
					rental.setBookNo(bookNo);
					int reaseNo = rCont.leaseNo();
					rental.setReaseNo(reaseNo);
					
					
					
					int result = rCont.addRental(rental);
					
					if(result == 0) {rView.FailMessage("대여");}
					else {rView.successMessage("대여");}
					
				}
			
			}
			
		}
//					Rental rental = new Rental();
//					rental =rView.setRental();
					
			break;
		case 6://메인메뉴로 이동
			Mainrun Run = new Mainrun();
			Run.main(args);
			
			break;
		case 5://반납
			int lease_no = rView.serchLeaseNo();
			int result = rCont.returnBook(lease_no);
			if(result==0) {
				rView.FailMessage("반납");
			}else {
				rView.successMessage("반납");
				}
				
				break ;
				
				
			default:
				break;
			}
		}
	}
}

