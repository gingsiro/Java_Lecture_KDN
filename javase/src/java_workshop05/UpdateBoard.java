package java_workshop05;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateBoard {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DBUtil.getConnection();
			String sql = " update board set title=? where no=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "수정됨");
			stmt.setInt(2, 5);      
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
}
