package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoleInsert {
	// pool이 수영장 풀장 생각하면 됨.
	// 동시에 수용가능한 인원이 있는데 그것을 초과한다면 서버가 터졌다고 한다.
	// 쓰레드는 동기화가 중요하다. 쓰레드?
	// 동기화를 할 때 ArrayList를 쓴다면 수동적인 작업을 해야 하기 때문에 synchronized를 써야하지만 Vector는 기본적으로 내제되어있기 때문에 필요없음.
	// DBConnectionMgr = 튜브 대여소, 그 안에 Vector가 있기 때문에 서버가 터지는 걸 막을 수 있다.
	// .close()는 끊어주는 역할을 한다.
	// finally는 무조건 실행돼야 할 때
	private DBConnectionMgr pool; // DB의 정보를 담고있는 싱글톤 pool을 전역 변수로 선언 RoleInsert에서만 쓸 것이기 때문에 private
	
	public RoleInsert() {
		pool = DBConnectionMgr.getInstance(); 
	}

	public int saveRole(String roleName) { // successCount의 반환값이 int이기 때문에 int로 선언
		int successCount = 0;
		
		String sql = null; // sql에 들어갈 값은 DB에 넣을 때 문자열로 들어가야 하기 때문에 String으로 선언
		Connection con = null; // DB와 연결을 해주기 위한 수단
		PreparedStatement pstmt = null; // 쿼리에 올려주기 위한 수단
		ResultSet rs = null;
	
		try {
			con = pool.getConnection(); // DB와 연결
			sql = "insert into role_mst values (0, ?)"; // 해당 값은 내가 넣고 싶은 테이블 명과 그 값이다. 값 안에 0 = index 순서, ? = 어떤 값이 들어갈지 모르기 때문에 ?로 지정
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // sql값 삽입, RETURN ~ 이 있어야 GenetratedKey값을 들고올 수 있따
			pstmt.setString(1, roleName); // sql에 값을 넣어주는 과정 1 = index 순서, roleName = ?에 들어갈 값
			
			successCount = pstmt.executeUpdate(); // insert, update, delete 명령 실행, 행의 갯수가 return이 되기 때문에 int값을 가져온다
			
			int newKey = 0;
			// newKey는 preparedStatement를 담기 위한 용도
			rs = pstmt.getGeneratedKeys(); // AI 키값을 들고 있다, Key값이 중복이 되면 안 되기 때문에 Set이다
			
			if(rs.next()) {
				// rs 컬럼에 들어있는 첫 번째 키값을 들고와라.
				newKey = rs.getInt(1); // Key 값이 int이기 때문에 getInt이다 1은 next의 첫 번째 값을 의미함.
			}
			
			System.out.println(newKey != 0 ? "새로운 키값: " + newKey : "키가 생성되지 않음"); // 현재 role_mst에 들어있는 키값을 본다.
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return successCount;
		
	}
	
	public static void main(String[] args) {
		
		RoleInsert roleInsert = new RoleInsert(); // 새로운 키값을 넣어주기 위해 객체 생성
		
		int successCount = roleInsert.saveRole("ROLE_TESTER"); // saveRole이라는 메서드에 "ROLE_TESTER"를 넣어줌으로써 새로운 키값이 생긴다.
		System.out.println("intsert 성공 건수: " + successCount); // role_mst의 원래 키값에서 새로운 키값이 몇 개가 들어갔는지 확인할 수 있다. 
	}
	
}


















