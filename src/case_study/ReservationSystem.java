package case_study;

import java.util.Scanner;

public class ReservationSystem {
	static Scanner sc = new Scanner(System.in);
	static CRUDOps ops = new CRUDOps();

	public static void newBooking() {
		Reservation new_reservation = new Reservation();
		sc.nextLine();// for skipping
		System.out.println("Enter your name:");
		String name = sc.nextLine();
		System.out.println("Number of people:");
		int people_count = sc.nextInt();
		System.out.println("Enter preferred date(dd/mm/yyyy):");
		String date = sc.next();
		System.out.println("Enter preferred time(22:00):");
		String time = sc.next();
		new_reservation.setName(name);
		new_reservation.setPeopleCount(people_count);
		new_reservation.setDate(date);
		new_reservation.setTime(time);
		ops.insertData(new_reservation);
	}

	public static void reviewBooking() {
		sc.nextLine();
		System.out.println("Enter your name for which you want to review your reservation:");
		String name = sc.nextLine();
		ops.readData(name);
	}

	public static void updateBooking() {
		Reservation updatedReservation = new Reservation();
		sc.nextLine();
		System.out.println("Enter the name under which reservation is made:");
		String name = sc.nextLine();
		ops.readData(name);
		System.out.println("Enter the updated name:");
		String updated_name = sc.nextLine();
		System.out.println("Updated number of people:");
		int updated_people_count = sc.nextInt();
		System.out.println("Enter the updated date(dd/mm/yyyy):");
		String updated_date = sc.next();
		System.out.println("Enter the updated time(22:00):");
		String updated_time = sc.next();
		updatedReservation.setName(updated_name);
		updatedReservation.setPeopleCount(updated_people_count);
		updatedReservation.setDate(updated_date);
		updatedReservation.setTime(updated_time);
		ops.updateData(name, updatedReservation);
	}

	public static void cancelBooking() {
		sc.nextLine();
		System.out.println("Enter your name for which you want to cancel your reservation:");
		String name = sc.nextLine();
		ops.deleteData(name);
	}

	public static void main(String[] args) {

		System.out.println(
				"*******************************Welcome to the table reservation system*******************************");
		do {
			System.out.println("Press '1' for booking a table");
			System.out.println("Press '2' for reviewing your reservation");
			System.out.println("Press '3' for updating your reservation");
			System.out.println("Press '4' for cancelling your reservation");
			System.out.println("Enter your choice:");
			int ch = sc.nextInt();
			if (ch == 1)
				newBooking();
			else if (ch == 2)
				reviewBooking();
			else if (ch == 3)
				updateBooking();
			else if (ch == 4)
				cancelBooking();
			System.out.println("Do you want to continue(y/n)?");
			char choice = sc.next().charAt(0);
			if (choice == 'n')
				break;
		} while (true);
		System.out.println("*******************************Thank you*******************************");
	}

}
