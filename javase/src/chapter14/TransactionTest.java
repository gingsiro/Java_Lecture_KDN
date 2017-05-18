package chapter14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Connection은 기본적으로 auto commit이 되게 처리 한다.
 * transaction 처리를 위한 곳에서는 수동으로 commit 처리되야 한다.
 */

public class TransactionTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		PreparedStatement stmt3 = null;
		ResultSet rs = null;

		try {
			 con = DBUtil.getConnection();
			 con.setAutoCommit(false); //transaction처리를 위해 수동으로 commit 하도록 설정한다.
			 String sql1 = " select board_no.nextval from dual ";
			 String sql2 = " insert into board(no, id, title, regdate, contents) "
					 	 + " values(?, ?, ?, sysdate, ?) ";
			 String sql3 = " insert into boardfile(no, rfilename, sfilename, bno) "
					 	 + " values(boardfile_no.nextval, ?, ?, ? ";
			 stmt1 = con.prepareStatement(sql1);
			 rs = stmt1.executeQuery();
			 int no = 0;
			 if(rs.next()){
				 no = rs.getInt(1);
			 }
			 
			 stmt2 = con.prepareStatement(sql2);
			 stmt2.setInt(1, no);
			 stmt2.setString(2, "kdn");
			 stmt2.setString(3, "처음하는 게시판 예제");
			 stmt2.setString(4, "잘 되나용?");
			 stmt2.executeUpdate();
			 
			 //throw 해줄 때는 if 가 있어야 컴파일러가 이해함
			 if(true) throw new RuntimeException("롤백이 되나요?");
			 
			 stmt3 = con.prepareStatement(sql3);
			 stmt3.setString(1, "a.txt");
			 stmt3.setString(2, "a.txt");
			 stmt3.setInt(3, no);
			 stmt3.executeUpdate();
			 
			 //여기까지 문제없이 수행된 경우 이므로 commit 가능
			 con.commit();
		} catch (Exception e) {
			// 실행하다 오류가 난 경우 이기 때문에 RollBack하겠다.
			DBUtil.rollback(con);
			// 커넥션 풀을 쓴다면 con이 반납되어 재사용되기 때문에
			// con의 auto commit을 기본값으로 바꿔 주어야한다.
//			try{ con.setAutoCommit(true); } catch(Exception e1) {}
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt1);
			DBUtil.close(stmt2);
			DBUtil.close(stmt3);
			DBUtil.close(con);
		}
	}
}
