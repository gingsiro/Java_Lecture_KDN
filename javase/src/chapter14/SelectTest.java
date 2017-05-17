package chapter14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest {
	public static void main(String[] args) {
		Connection con = null;			// 데이터베이스 서버와 연결을 담당
		PreparedStatement stmt = null;	// 데이터베이스 서버에 query 처리를 요청
		ResultSet rs = null;			// select문을 수행한 결과
		//네트워크 이기 때문에 꼭 try catch 해줘야함 안해주면 에러
		try {
			con = DBUtil.getConnection();
			// 쿼리 작성 시 습관적으로 앞뒤로 공백을 줘야 한다.
			String sql = " select empno, ename, sal, to_char(hiredate, 'yy-mm-dd') hiredate " 
					   + " from emp "; //마지막에 세미콜론 안주고 처리
			stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery(); //데이터베이스 서버에 쿼리 실행 요청
			
			//결과 처리
			//rs.next() : 데이터가 있으면 true, 없으면 false
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				String hiredate = rs.getString("hiredate");
				System.out.printf("%d\t%s\t%d\t%s\t\n",empno, ename, sal, hiredate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		
	}
}
