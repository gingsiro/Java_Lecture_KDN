package chapter14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//DAO (Data Access Object) : 데이터를 처리해주는 오브젝트
class BatchDAO{
		public void addBatch(List<HashMap<String, String>> lists){
			Connection con = null;
			PreparedStatement stmt = null;

			try {
				con = DBUtil.getConnection();
				String sql = " insert into emp(empno, ename, sal) "
						   + " values(?, ?, ?) ";
				stmt = con.prepareStatement(sql);
				for (HashMap<String, String> emp : lists) {
					stmt.setInt(1, Integer.parseInt(emp.get("empno")));
					stmt.setString(2, emp.get("ename"));
					stmt.setInt(3, Integer.parseInt(emp.get("sal")));
					stmt.addBatch(); //batch처리 할 수 있도록 데이터를 추가한다.
				}
				
				//Batch문 실행은 executeBatch()로 한다. !!!!!!!!!!
				int[] rows = stmt.executeBatch();
				for (int i = 0; i < rows.length; i++) {
					System.out.println(rows[i]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(stmt);
				DBUtil.close(con);			
			}
		}
}

public class BatchInsertTest {
	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> datas = new ArrayList<HashMap<String, String>>(3);
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("empno","9876");
		map1.put("ename","9876");
		map1.put("sal","10000");
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("empno","8765");
		map2.put("ename","8765");
		map2.put("sal","10000");
		HashMap<String, String> map3 = new HashMap<String, String>();
		map3.put("empno","7653");
		map3.put("ename","7653");
		map3.put("sal","10000");
		
		datas.add(map1);
		datas.add(map2);
		datas.add(map3);
		
		BatchDAO bd = new BatchDAO();
		bd.addBatch(datas);
	}
}
