import java.sql.*;

public class PreparedStatementEx
{
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		ResultSet rs = null;
		
		try
		{
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",  // localhost:1521:xe 여기만 바꿈
					"scott",     // 아이디
					"TIGER");    // 패스워드
			// 이렇게 입력해도 됨.
			String sql = "create table test2(id varchar2(10),      " + 
					     "                   password varchar2(10)) ";
			// 동적 쿼리 실행
			pstmt1 = con.prepareStatement(sql);
			int updateCount = pstmt1.executeUpdate();
			System.out.println("createCount : " + updateCount);
			
			//-----------------------------------------------------------
			// 쿼리문 준비 : 값의 세팅이 필요한 부분을 ?(인파라미터)로 기술한다.
			sql = "insert into test2 values(?, ?)";
			// prepared객체생성 : 객체 생성시 준비한 쿼리문을 인수로 전달한다.
			pstmt2 = con.prepareStatement(sql);
			/*
			인파라미터 설정 : ?의 순서대로 설정하고, 인덱스는 1부터 
				시작한다. 
				자료형이 
					숫자면 setInt()
					문자면 setString()
					날짜면 setDate()
				입력값이 문자 혹은 날짜면 자동으로 싱글쿼테이션이 추가된다.
			 */
			pstmt2.setString(1, "홍길동");
			pstmt2.setString(2, "1111");
			updateCount = pstmt2.executeUpdate();
			System.out.println("insertCount : " + updateCount);
			
			//-----------------------------------------------------------
			sql = "select * from test2";
			pstmt3 = con.prepareStatement(sql);
			rs = pstmt3.executeQuery();
			while(rs.next())
			{
				System.out.print("id : " + rs.getString(1));        // 출력문
				System.out.println(", password : " + rs.getString(2));
			}
			
			//-----------------------------------------------------------
			sql = "drop table test2";
			pstmt4 = con.prepareStatement(sql);
			updateCount = pstmt4.executeUpdate();
			System.out.println("dropCount : " + updateCount);
		}catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}finally
		{
			try
			{
				if (rs != null) rs.close();
				if (pstmt1 != null) pstmt1.close();
				if (pstmt2 != null) pstmt2.close();
				if (pstmt3 != null) pstmt3.close();
				if (pstmt4 != null) pstmt4.close();
				if (con != null) con.close();
			}catch(SQLException sqle) {}
		}
	}
}