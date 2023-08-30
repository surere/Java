import java.sql.*;

public class Main
{
	static
	{
		try
		{
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		try
		{
			// 오라클 DB 연결
			Connection con = DriverManager.getConnection(  //DB 연결을 위한 객체
					"jdbc:oracle:thin:@localhost:1521:xe",  // localhost:1521:xe 여기만 바꿈
					"scott",     // 아이디
					"TIGER");    // 패스워드
			//정적쿼리문을 전송 및 실행하기 위한 객체 생성 및 메서드 호출 
			Statement stmt = con.createStatement();  
			
			//-----------------------------------------------------------
			StringBuffer sb = new StringBuffer();
			sb.append("create table test1 ( ");   // SQL 문을 여기다 적음
			sb.append("   id varchar2(10),  ");
			sb.append("   age number )      ");
			
			int updateCount =
					stmt.executeUpdate(sb.toString());
			System.out.println("create Count : " + updateCount);
			
			//-----------------------------------------------------------
			sb.setLength(0);
			//정적 insert 쿼리문 작성(인파라미터가 없는 쿼리문) => ?가 아닌 쿼리
			sb.append("insert into test1  ");
			sb.append("values ('홍길동', 10)");
			updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("insertCount : " + updateCount);
			
			//-----------------------------------------------------------
			sb.setLength(0);
			sb.append("select * from test1");
			
			/*
			ResultSet 인터페이스
			: select문 실행시 쿼리의 실행결과를 ResultSet객체를 통해 받는다. 
			결과로 반환된 레코드의 처음부터 끝까지 next()메서드를 통해 확인후
			반복 인출한다. 
			
			컬럼의 자료형이
				number타입 : getInt()
				char/varchar2타입 : getString()
				date타입 : getDate() 메서드를 통해 출력한다. 
			해당 메서드의 인수는 인덱스(1부터시작) 혹은 컬럼명을 사용할 수 있다. 
			오라클 자료형에 상관없이 getString()으로 모두 출력할 수 있다. 
			
			executeQuery() 
				: select 쿼리를 실행할때 호출하는 메서드로 레코드에 영향을
				미치지않고 조회만 하는 경우 사용한다. 
				조회한 레코드를 반환값으로 받아야 하므로 ResultSet객체가
				반환타입으로 정의되어있다. 
			 */
			ResultSet rs = stmt.executeQuery(sb.toString());  // select 는 executeQuery 사용
			while(rs.next())
			{
				System.out.print("id : " + rs.getString(1) + ", ");        // 출력문
				System.out.println("age : " + rs.getString("age"));
			}
			
			//-----------------------------------------------------------
			sb.setLength(0);
			sb.append("update test1");
			sb.append("   set id='전우치', ");
			sb.append("       age=20       ");
			sb.append(" where id='홍길동'  ");  // 홍길동을 전우치로 바꿔라
			/*
			executeUpdate()
			 	: 쿼리문이 insert, update, delete와 같이 기존 레코드에 
			 	변화가 생기는 경우에 사용한다. 실행후 적용된 행의 갯수를
			 	int형으로 반환한다. 	
			 */
			updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("updateCount : " + updateCount);
			
			//-----------------------------------------------------------
			sb.setLength(0);
			sb.append("select * from test1");
			rs = stmt.executeQuery(sb.toString());
			while(rs.next())
			{
				System.out.print("id : " + rs.getString(1) + ", ");        // 출력문
				System.out.println("age : " + rs.getString("age"));
			}
			
			//-----------------------------------------------------------
			sb.setLength(0);
			sb.append("delete from test1");
			updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("deleteCount : " + updateCount);
			
			//-----------------------------------------------------------
			sb.setLength(0);
			sb.append("drop table test1");
			updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("dropCount : " + updateCount);
			
			
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException sqle)
		{
			System.out.println("Connection Error");
			sqle.printStackTrace();
		}
	}
}