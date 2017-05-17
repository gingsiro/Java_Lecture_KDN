package chapter14;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DBUtil.getConnection();
			String sql = " delete emp where empno=? ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, 9876);
			
			//insert, update, delete문 실행은 executeUpdate()로 한다.
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

}
