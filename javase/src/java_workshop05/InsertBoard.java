package java_workshop05;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertBoard {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = DBUtil.getConnection();
			String sql = " insert into board(no, title, id, contents, regdate) "
					   + " values(BOARD_NO.NEXTVAL, ?, ?, ?, SYSDATE) ";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, "처음 입력하다.");
			stmt.setString(2, "kdn");
			stmt.setString(3, "JDBC 첫번째 연습");

			int row = stmt.executeUpdate();
			if (row > 0) {
				System.out.println("insert 됨");
			} else {
				System.out.println("insert 안됨");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
}
