package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import usermanagemaent.entity.User;


public class UserInsert {
	
	private DBConnectionMgr pool;
	
	public UserInsert() {
		pool = DBConnectionMgr.getInstance();
	}
	// Connection = JDBC library
	// PreparedStatement = SQL을 받아오고 받아온 것을 실행하는 것, SQL 안에 ?도 채워줌.
	// 값을 넣거나 지정해주는 것은 set, 가져오는 것은 get
	// 미완성된 sql 작성 -> preparedStatement에서 완성해준다.
	public int saveUser(User user) {
		int successCount = 0;
		
		String sql = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = pool.getConnection(); // DB 연결
			
			sql = "insert into user_mst\r\n"
					+ "values (0, ?, ?, ?, ?)"; // 물음표를 쓰는 이유 -> 뭐가 들어갈지 모름
			
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getUsername()); // 1번 ?에 getUsername이 들어간다는 의미 작은 따옴표까지 찍어서 만들어줌 그래서 위 코드에서 값에 ''를 빼줌
			preparedStatement.setString(2, user.getPassword()); // 2번 ?에 getPassword
			preparedStatement.setString(3, user.getName());
			preparedStatement.setString(4, user.getEmail());
			
			successCount = preparedStatement.executeUpdate(); // insert, update, delete 명령 실행, 행의 갯수가 return이 되기 때문에 int값을 가져온다
			
			resultSet = preparedStatement.getGeneratedKeys(); // AI 키값을 들고 있다, Key값이 중복이 되면 안 되기 때문에 Set이다
			// resultSet이 키값을 들고 있다
			if(resultSet.next()) { // 다음 값을 꺼낸다는 의미. next를 하지 않으면 초기값이 컬럼명으로 되어있기 때문에 next를 해줌으로써 첫 번째 값을 resultSet으로 들고온다.
				System.out.println("이번에 만들어진 user_id Key값: " + resultSet.getInt(1)); // Key 값이 정수이기 때문에 getInt다 1은 resultSet의 행이 아닌 열을 의미함
				user.setUserId(resultSet.getInt(1));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return successCount;
	}
	
	
	public int saveRoles(Map<String, Object> map) {
		int successCount = 0;
		
		String sql = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
		connection = pool.getConnection();
		List<Integer> roles = (List<Integer>)map.get("roles");
		User user = (User) map.get("user");
		
		sql = "insert into role_dtl values";
		
		for(int i = 0; i < roles.size(); i++) {
			
			sql += "(0, ?, ?)";
			
			if(i < roles.size() -1) {
				sql += ",";
			}
		}
		
		preparedStatement = connection.prepareStatement(sql);
		
		for(int i = 0; i < roles.size(); i++) {
			preparedStatement.setInt((i * 2) + 1, roles.get(i));
			preparedStatement.setInt((i * 2) + 2, user.getUserId());
		}
		
		successCount = preparedStatement.executeUpdate();
		
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return successCount;
	}
	
	
	
	public static void main(String[] args) {
		
		UserInsert userInsert = new UserInsert();
		
		User user = User.builder()
					.username("zzz")
					.password("1234")
					.name("zzz")
					.email("zzz@gamil.com")
					.build();
		
		int successCount = userInsert.saveUser(user);
		
		System.out.println("쿼리 실행 성공: " + successCount + "건");
		
		System.out.println(user); // user 주소 안에 setUserId가 들어가있다.
		
		/*=======================================================================*/
		// List = 순서대로 반복을 돌려서 하나씩 꺼내야 될 때 쓴다.
		List<Integer> roleIdList = new ArrayList<>();
		roleIdList.add(2);
		roleIdList.add(3);
		
		// Map = 지정해둔 키값이 있으면 그것을 바로 들고올 때. 꼬리표, 임시 entity객체라 생각하면 된다.
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		map.put("roles", roleIdList);
		
		System.out.println(map);
		
		successCount = userInsert.saveRoles(map);
		
		System.out.println("쿼리 실행 성공: " + successCount + "건");
		
	}

}
