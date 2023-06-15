package dev.trip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.trip.Util.DBUtil;
import dev.trip.model.Trip;

public class TripDAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	public List<Trip> selectAll() {
		// DB에 접근하는 코드 작성
		final String selectQuery = "SELECT * FROM Trip";
		List<Trip> trips = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQuery);

			while (rs.next()) {
				int id = rs.getInt("id");
				String continent = rs.getString("continent");
				String country = rs.getString("country");
				String city = rs.getString("city");
				boolean isVisited = rs.getBoolean("is_visit");

				trips.add(new Trip(id, continent, country, city, isVisited));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 반납, 해제(순서 -> 역순)
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return trips;
	}

	// 추가
	public Trip insertTrip(Trip trip) {
		final String insertQuery = "INSERT INTO trip (continent, country, city) VALUES (?, ?, ?)";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery,
						Statement.RETURN_GENERATED_KEYS);) {

			statement.setString(1, trip.getContinent());
			statement.setString(2, trip.getCountry());
			statement.setString(3, trip.getCity());
			// statement.setBoolean(4, trip.getIsVisited());

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 1) {
				rs = statement.getGeneratedKeys();
				if (rs.next()) {
					int generatedId = rs.getInt(1);
					trip.setId(generatedId);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trip;
	}

	// 삭제
	public void deleteTrip(int id) {
	    final String deleteQuery = "DELETE FROM trip WHERE id = ?";
	    
	    try (Connection connection = DBUtil.getConnection();
	         PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

	        statement.setInt(1, id);
	        int rowsAffected = statement.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	// 수정
	public void updateTrip(Trip trip, int updateId) {
	    final String updateQuery = "UPDATE Trip SET continent = ?, country = ?, city = ? WHERE id = ?";

	    try (Connection connection = DBUtil.getConnection();
	            PreparedStatement statement = connection.prepareStatement(updateQuery)) {

	           statement.setString(1, trip.getContinent());
	           statement.setString(2, trip.getCountry());
	           statement.setString(3, trip.getCity());
	           statement.setInt(4, updateId);

	           statement.executeUpdate(); // 수정된 부분

	       } catch (SQLException e) {
	           e.printStackTrace();
	       }
	}

}
