package chapter14;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertTest {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = DBUtil.getConnection();
			String sql = " insert into emp(empno, ename, sal) "
					   + " values(?, ?, ?) ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, 9876); // 첫번째 ?에 empno를 int로 값 설정
			stmt.setString(2, "kdn"); // 두번째 ?에 ename을 String으로 값 설정
			stmt.setInt(3, 5000); // 세번째 ?에 sal을 int로 값 설정

			int row = stmt.executeUpdate();
			if (row > 0) {
				System.out.println("insert 됨");
			} else {
				System.out.println("insert 됨");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);			
		}
	}
}
