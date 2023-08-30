import java.sql.*;

public class TransactionEx
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
		PreparedStatement pstmt = null;
		boolean success = false;
		
		try
		{
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",  
					"scott",     // 아이디
					"TIGER");    // 패스워드
			
			/*
			자바에서 데이터베이스의 트랜잭션을 시작하는 유일한 방법입니다. 
			setAutoCommit(true)는 모든 SQL statement를 래핑합니다.
			(JDBC 라이브러리 룰에 따라 자동으로 커밋, 롤백 즉 트랜잭션이 이뤄집니다.) 
			setAutoCommit(false)는 이와 반대로 트랜잭션의 주인은 내가 됩니다. 
			즉 제어를 내가하고 내가 원할 때 커밋 또는 롤백합니다.
			 * */
			con.setAutoCommit(false);
			
			//-----------------------------------------------------------
			String sql = "insert into test3 values('홍길동', '1111')";
			
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("11111"); // 프로그램이 어디까지 되었는지 파악 할때 좋음
			
			sql = "insert into test3 values('전우치', '2222')";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("22222");
			
			sql = "insert into test3 values('손오공', '3333')";  // ) 없애서 에러를 유도
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("33333");
			
			success = true;
			
		}catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}finally
		{
			try
			{
				if (success)
				{
					System.out.println("44444");
					con.commit();  // 여기서 커밋
				}else
				{
					System.out.println("55555");
				}
				
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			}catch(SQLException sqle) {}
		}
	}
}