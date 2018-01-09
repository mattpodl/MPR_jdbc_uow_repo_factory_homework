package jdbcdemo.domain;

import java.sql.Date;

public class Accident implements IHaveId {

	private int id;
	private int carId;
	private Date date;
	private String description;

	public Accident(int id, int carId, Date date, String description) {
		super();
		this.id = id;
		this.carId = carId;
		this.date = date;
		this.description = description;
	}

	public Accident(int carId, Date date, String description) {
		super();
		this.carId = carId;
		this.date = date;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int car_id) {
		this.carId = car_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Accident details: ID: " + getId() + ", Car: " + getCarId() + ", Date: " + getDate() + ", Description: "
				+ getDescription() + ".";
	}
}
