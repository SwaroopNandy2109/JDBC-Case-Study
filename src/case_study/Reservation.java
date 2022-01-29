package case_study;

public class Reservation {
	private String name;
	private int people_count;
	private String date;
	private String time;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPeopleCount() {
		return people_count;
	}

	public void setPeopleCount(int people_count) {
		this.people_count = people_count;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void displayReservationDetails() {
		System.out.println("Your Reservation Details:");
		System.out.println("Name: " + this.name);
		System.out.println("Table for: " + this.people_count);
		System.out.println("Date: " + this.date);
		System.out.println("Time: " + this.time);
	}

}
