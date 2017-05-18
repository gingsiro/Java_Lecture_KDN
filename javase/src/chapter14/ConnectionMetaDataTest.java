package chapter14;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

/**
 * DatabaseMetaData를 통해 DB 서버에 대한 정보 추출
 *  
 */
public class ConnectionMetaDataTest {
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			DatabaseMetaData dbmd = con.getMetaData();
			
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDatabaseProductVersion());
			System.out.println(dbmd.getUserName());
			System.out.println(dbmd.getDriverMajorVersion());
			System.out.println(dbmd.getURL());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con);
		}
	}
}
