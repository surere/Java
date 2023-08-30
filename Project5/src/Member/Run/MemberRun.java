package Member.Run;

import java.util.ArrayList;

import Main.run.Mainrun;
import Member.Controller.MemberController;
import Member.view.MemberView;
import Member.vo.Member;

public class MemberRun
{

	public static void main(String[] args)
	{
	MemberView mView = new MemberView();
	ArrayList<Member> mList = null;
	MemberController mCont = new MemberController();
	
		while(true) {
			int choice = mView.mainMenu();
			switch (choice) {
			case 1: //전체 조회
				mList = mCont.allMember();
				if(mList.isEmpty()) {
					mView.failMessage("조회");
				} else {
					mView.allMember(mList);
				}
				break;
			case 2:// 이름으로 조회
				String name = mView.serchName();
				mList = mCont.serchName(name);
				if(mList.isEmpty()) {
				} else {
					mView.allMember(mList);
				}
				
				break;
				
			case 3: //아이디로 조회
				String MemberId = mView.serchId();
				Member member = mCont.serchId(MemberId);
				if(member == null) {
					mView.failMessage("조회");
				} else {
					mView.viewMember(member);
				}
				break;
			case 4: //회원가입
				member = mView.insertMember();
				int result = mCont.countMember();
				result = mCont.insertMember(member, result);
				if(result == 0) {
					mView.failMessage("가입");
				} else {
					mView.successMessage("가입");
				}
				
				break;
				
			case 5: //정보수정
				MemberId = mView.serchId();
				result = mCont.countId(MemberId);
				
				if(result == 0) {
					mView.failMessage("아이디 조회");
				} else {
					
				member = mView.updateMember();
				member.setUserId(MemberId);
				result = mCont.updateMember(member);
				if(result ==0) {
					mView.failMessage("수정");
				}else {
					mView.successMessage("수정");
				}
				}
				
				break;
				
			case 6 : //회원탈퇴
				MemberId = mView.serchId();
				result = mCont.delMember(MemberId);
				if(result == 0) {
					mView.failMessage("탈퇴");
				}else {
					mView.successMessage("탈퇴");
				}
				
				break;
				
			case 7://메인메뉴
				Mainrun Mrun = new Mainrun();
				Mrun.main(args);
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
					
				}
			}
		}

	}
