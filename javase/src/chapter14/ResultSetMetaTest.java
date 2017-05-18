package chapter14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * ResultSetMetaData : 수행한 select 문에 대한 meta data를 추출
 *
 */

public class ResultSetMetaTest {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		try {
//			String sql = " select * from emp";
			String sql = " select * from borad ";
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			rsmd = rs.getMetaData();

			int count = rsmd.getColumnCount(); // select문에 의해 추출된 컬럼의 수
			for (int i = 1; i < count; i++) {  //컬럼 이름 출력
				System.out.print(rsmd.getColumnName(i));
				System.out.print("\t");
			}
			System.out.println();
			
			
			while (rs.next()) {				   //데이터 추출
				for (int i = 1; i <= count; i++) {
					System.out.print(rs.getString(i));
					System.out.print("\t");
				}
				System.out.println();
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
