package case_study;

import java.sql.*;
import java.util.Scanner;

public class CRUDOps extends MySqlConnection {

	// reserve a table
	public void insertData(Reservation reservation) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn
					.prepareStatement("insert into reservations(name, people_count, date,time) values(?,?,?,?);");
			statement.setString(1, reservation.getName());
			statement.setInt(2, reservation.getPeopleCount());
			statement.setString(3, reservation.getDate());
			statement.setString(4, reservation.getTime());
			statement.executeUpdate();
			System.out.println("Reservation Successfull!!");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// review reservation
	public void readData(String name) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("select * from reservations where name=?");
			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();
			Reservation reservation = new Reservation();
			if (resultSet.next()) {
				reservation.setName(resultSet.getString(2));
				reservation.setPeopleCount(resultSet.getInt(3));
				reservation.setDate(resultSet.getString(4));
				reservation.setTime(resultSet.getString(5));
				reservation.displayReservationDetails();
			} else {
				System.out.println("There is no reservation under this name.");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// update reservation
	public void updateData(String name, Reservation updatedReservation) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn
					.prepareStatement("update reservations set name=?, people_count=?, date=?, time=? where name = ?;");
			statement.setString(1, updatedReservation.getName());
			statement.setInt(2, updatedReservation.getPeopleCount());
			statement.setString(3, updatedReservation.getDate());
			statement.setString(4, updatedReservation.getTime());
			statement.setString(5, name);
			statement.executeUpdate();
			System.out.println("Updating Reservation Successfull!!");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// delete reservation
	public void deleteData(String name) {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("delete from reservations where name=?");
			statement.setString(1, name);
			statement.executeUpdate();
			conn.close();
			System.out.println("Cancelled Reservation.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
