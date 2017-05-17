package java_workshop05;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteBoard {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DBUtil.getConnection();
			String sql = " delete board where no=? ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, 5);
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
}
