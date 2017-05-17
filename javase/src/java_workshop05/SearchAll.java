package java_workshop05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchAll {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			con = DBUtil.getConnection();
			String sql = " select * "
					   + " from board "
					   + " order by no desc ";
			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery();

			while(rs.next()){
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String id = rs.getString("id");
				String contents = rs.getString("contents");
				String regdate = rs.getString("regdate");
				System.out.printf("%d\t%s\t%s\t%s\t%s\n", no, title, id, contents, regdate);
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
