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
			preparedStatement.setString(1, user.getUsername()); // 작은 따옴표까지 찍어서 만들어줌 그래서 위 코드에서 값에 ''를 빼줌
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setString(4, user.getEmail());
			
			successCount = preparedStatement.executeUpdate(); // insert, update, delete 명령 실행, 행의 갯수가 return이 되기 때문에 int값을 가져온다
			
			resultSet = preparedStatement.getGeneratedKeys(); // AI 키값을 들고 있다, Key값이 중복이 되면 안 되기 때문에 Set이다
			// 
			if(resultSet.next()) {
				System.out.println("이번에 만들어진 user_id Key값: " + resultSet.getInt(1)); // Key 값이 int이기 때문에 getInt다 1은 next의 첫 번째 값을 의미함.
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
		
		List<Integer> roleIdList = new ArrayList<>();
		roleIdList.add(2);
		roleIdList.add(3);
		
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		map.put("roles", roleIdList);
		
		System.out.println(map);
		
		successCount = userInsert.saveRoles(map);
		
		System.out.println("쿼리 실행 성공: " + successCount + "건");
		
	}

}
