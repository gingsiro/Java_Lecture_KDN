package chapter14;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateTest {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DBUtil.getConnection();
			String sql = " update emp set ename=?, sal=? where empno=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "한전kdn");   // 첫번째 ?에 ename를 String으로 값 설정     
			stmt.setInt(2, 5000);           // 두번째 ?에 sal을 int로 값 설정 
			stmt.setInt(3, 9876);           // 세번째 ?에 empno을 int로 값 설정       
			
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
